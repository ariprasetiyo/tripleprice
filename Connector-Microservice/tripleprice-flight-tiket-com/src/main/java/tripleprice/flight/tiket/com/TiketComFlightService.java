package tripleprice.flight.tiket.com;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.general.Baggage;
import tripleprice.flight.general.FlightFacility;
import tripleprice.flight.general.LoadDetails;
import tripleprice.flight.search.FlightItems;
import tripleprice.flight.search.FlightParams;
import tripleprice.flight.search.FlightPrice;
import tripleprice.flight.search.FlightRoute;
import tripleprice.flight.search.FlightSegment;
import tripleprice.flight.search.MarketingAirline;
import tripleprice.flight.service.FlightService;
import tripleprice.flight.tiket.com.enumeration.ResultType;
import tripleprice.flight.tiket.com.json.response.DepartureFlight;
import tripleprice.flight.tiket.com.json.response.Fares;
import tripleprice.flight.tiket.com.json.response.ItemsKeySearchResponse;
import tripleprice.flight.tiket.com.json.response.Schedules;
import tripleprice.flight.tiket.com.pojo.TiketComFlightParams;
import tripleprice.service.PieceType;
import tripleprice.util.DateUtil;

/**
 * @author ari.prasetiyo
 */
@Service
public class TiketComFlightService implements FlightService {

	@Autowired
	TiketComConnector tiketComConnector;

	private static final Logger LOGGER = LoggerFactory.getLogger(TiketComFlightService.class);
	private static final short SEARCH_ID = 3;
	private static final short VENDOR_ID = 3;
	private static final SimpleDateFormat YYYY_MM_DDD = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat HH_MM = new SimpleDateFormat("HH:mm");
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final ObjectReader READER_TIKET_COM_SEARCH = OBJECT_MAPPER.readerFor(ItemsKeySearchResponse.class);
	private static final DateUtil DATE_UTIL = DateUtil.getInstanceThreadSafe();
	private static final String ORIGINAL_TYPE = "AIRPORT";
	private static final String DESTINATION_TYPE = "CITY";
	
	@Override
	public FlightItems flightSearchItem(final FlightParams flightParams) {
		final String responseJsonResult = tiketComConnector.getSearch(flightSearchItemMapping(flightParams));
		try {
			return flightItemsMapping(READER_TIKET_COM_SEARCH.readValue(responseJsonResult));
		} catch (IOException e) {
			LOGGER.debug("Tiket.com error read json={}", e.getMessage(), e);
		}
		return null;
	}
	
	private final TiketComFlightParams flightSearchItemMapping(final FlightParams flightParams) {
		final TiketComFlightParams tiketComFlightParams = new TiketComFlightParams();
		tiketComFlightParams.setOrigin(flightParams.getDepartureAirportCode());
		tiketComFlightParams.setDestination(flightParams.getArrivalAirportCode());
		tiketComFlightParams.setDepatureDate(DATE_UTIL.getDateYYYYMMDD(flightParams.getDepatureDate()));
		tiketComFlightParams.setAdult(flightParams.getAdultsNum());
		tiketComFlightParams.setChild(flightParams.getChildrenNum());
		tiketComFlightParams.setInfant(flightParams.getInfantsNum());
		tiketComFlightParams.setFlightClassType(flightParams.getFlightClassType());
		tiketComFlightParams.setOriginType(ORIGINAL_TYPE);
		tiketComFlightParams.setDestionationType(DESTINATION_TYPE);
		tiketComFlightParams.setTripType(flightParams.getTripType());
		tiketComFlightParams.setResultType(ResultType.ALL);
		tiketComFlightParams.setAsync(true);
		return tiketComFlightParams;
	}

	private final FlightItems flightItemsMapping(final ItemsKeySearchResponse tiketFlightSearch) {
		final FlightItems flightItems = new FlightItems();
		flightItems.setFlightSearchItemId(SEARCH_ID);
		flightItems.setFlightSearchVendorId(VENDOR_ID);

		final List<FlightSegment> outboundSegments = new ArrayList<>();
		for (final DepartureFlight outbound : tiketFlightSearch.getData().getSearchList().getDepartureFlights()) {

			final FlightSegment flightSegment = new FlightSegment();
			flightSegment.setTotalDuration(outbound.getTotalTravelTimeInMinutes());
			flightSegment.setAvailableSeat(outbound.getSeatAvailability());
			// flightSegment.setMaximumSeat(outbound.getMaximumSeat());
			flightSegment.setNumberOfStops(outbound.getTotalTransit());
			// flightSegment.setParam(outbound.getParam());

			final MarketingAirline marketingAirline = new MarketingAirline();
			marketingAirline.setAirlineCode(outbound.getMarketingAirline().getCode());
			marketingAirline.setAirlineName(outbound.getMarketingAirline().getDisplayName());
			// marketingAirline.setFlightNumber(outbound.getId());
			// marketingAirline.setFlightClassType(FlightClassType.valueOf(outbound.getClassType()));
			flightSegment.setMarketingAirline(marketingAirline);

			/*
			 * final FlightFacility flightFacility = new FlightFacility(); final
			 * Baggage baggageSegment = new Baggage();
			 * baggageSegment.setWeight(outbound.getBaggage());
			 * baggageSegment.setBaggageType(BaggageType.valueOf(outbound.
			 * getBaggageType()));
			 * baggageSegment.setDefaultLuggage(outbound.getDefaultLuggage());
			 * flightFacility.setBaggage(baggageSegment);
			 * flightFacility.setFreeMeal(outbound.isFoodOnboard());
			 * flightSegment.setFlightFacility(flightFacility);
			 */

			final FlightPrice flightPrice = new FlightPrice();

			final Fares[] fares = outbound.getFareDetail().getFares();
			final Fares airlineFare = fares[fares.length-1];

			flightPrice.setCurrency(airlineFare.getCurrency());
			flightPrice.setBannerPromo(airlineFare.getDiscountLabels());
			flightPrice.setTaxFare(airlineFare.getTotalFare().getTax());
			flightPrice.setOneWayFare(0);
			flightPrice.setRoundtripFares(0);
			flightPrice.setTotalPrice(outbound.getFareDetail().getCheapestFare());
			flightPrice.setDiscount(airlineFare.getTotalFare().getDiscount());
			flightSegment.setFlightPrice(flightPrice);

			final List<FlightRoute> flightRoutes = new ArrayList<FlightRoute>();
			for (final Schedules segment : outbound.getSchedules()) {

				final FlightRoute flightRoute = new FlightRoute();
				flightRoute.setAirlineCode(segment.getAirline().getCode());
				flightRoute.setAirlineName(segment.getAirline().getName());
				flightRoute.setFlightNumber(segment.getFlightNumber());
				flightRoute.setArrivalCity(segment.getArrivalDetail().getCityName());
				flightRoute.setArrivalAirportCode(segment.getArrivalDetail().getAirportCode());
				flightRoute.setArrivalDate(getTiketComDateTime(segment.getArrivalDetail().getDate(),
						segment.getArrivalDetail().getTime()));
				flightRoute.setArrivalAirportTerminal(segment.getArrivalDetail().getTerminal());

				flightRoute.setDepartureCity(segment.getDepartureDetail().getCityName());
				flightRoute.setDepatureDate(getTiketComDateTime(segment.getDepartureDetail().getDate(),
						segment.getDepartureDetail().getTime()));
				flightRoute.setDepatureAirportCode(segment.getDepartureDetail().getAirportCode());
				flightRoute.setDepartureAirportTerminal(segment.getDepartureDetail().getTerminal());

				flightRoute.setDuration(segment.getTotalTravelTimeInMinutes());

				final FlightFacility flightFacilityRoute = new FlightFacility();
				final Baggage baggageRoute = new Baggage();

				LoadDetails loadDetails = new LoadDetails();
				loadDetails.setWeight(segment.getBaggage().getCheckIn().getQuantity());
				loadDetails
						.setMeansurement(PieceType.valueOfString(segment.getBaggage().getCheckIn().getMeasurement()));
				baggageRoute.setCheckIn(loadDetails);

				loadDetails = new LoadDetails();
				loadDetails.setWeight(segment.getBaggage().getCabin().getQuantity());
				loadDetails.setMeansurement(PieceType.valueOfString(segment.getBaggage().getCabin().getMeasurement()));
				baggageRoute.setCabin(loadDetails);

				flightFacilityRoute.setBaggage(baggageRoute);
				flightFacilityRoute.setFreeMeal(segment.isBundlingMeal());
				flightRoute.setFlightFacility(flightFacilityRoute);

				flightRoute.setFlightClassType(FlightClassType.valueOf(segment.getCabinClass()));
				flightRoute.setHiddenStop(segment.getTotalTransitTimeInMinutes() == 0 ? false : true);
				flightRoutes.add(flightRoute);
			}
			flightSegment.setFlightRoutes(flightRoutes);

			flightSegment.setDepartureAirportCode(outbound.getDeparture().getAirportCode());
			flightSegment.setDepartureDate(
					getTiketComDateTime(outbound.getDeparture().getDate(), outbound.getDeparture().getTime()));
			flightSegment.setArrivalAirportCode(outbound.getArrival().getAirportCode());
			flightSegment.setArrivalDate(
					getTiketComDateTime(outbound.getArrival().getDate(), outbound.getArrival().getTime()));

			outboundSegments.add(flightSegment);
		}
		flightItems.setOutboundFlights(outboundSegments);

		return flightItems;
	}

	private long getTiketComDateTime(final String date, final String time) {
		try {
			return (YYYY_MM_DDD.parse(date).getTime() + HH_MM.parse(time).getTime());
		} catch (ParseException e) {
			LOGGER.debug("tiket.com connector error={}", e.getMessage(), e);
		}
		return 0l;
	}

}

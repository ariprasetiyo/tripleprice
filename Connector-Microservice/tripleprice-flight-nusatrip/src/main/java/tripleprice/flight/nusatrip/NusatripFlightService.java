package tripleprice.flight.nusatrip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.general.AircraftType;
import tripleprice.flight.general.Baggage;
import tripleprice.flight.general.BaggageType;
import tripleprice.flight.general.FlightFacility;
import tripleprice.flight.general.LoadDetails;
import tripleprice.flight.nusatrip.api.response.NusatripFlightSearchResponse;
import tripleprice.flight.nusatrip.api.response.Outbounds;
import tripleprice.flight.nusatrip.api.response.Segments;
import tripleprice.flight.search.FlightItems;
import tripleprice.flight.search.FlightParams;
import tripleprice.flight.search.FlightPrice;
import tripleprice.flight.search.FlightRoute;
import tripleprice.flight.search.FlightSegment;
import tripleprice.flight.search.MarketingAirline;
import tripleprice.flight.service.FlightService;

/**
 * @author ari.prasetiyo
 *         http://www.nusatrip.com/flights/search?departDate=20180924&lang=en&departure=DPS&adultNum=2&arrival=CGK
 */
@Service
public class NusatripFlightService implements FlightService {

	private static final Logger LOGGER = LoggerFactory.getLogger(NusatripFlightService.class);
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final ObjectReader NUSATRIP_FLIGHT_SEARCH_READER = OBJECT_MAPPER
			.readerFor(NusatripFlightSearchResponse.class);
	private static final short VENDOR_ID = 1;
	private static final short SEARCH_ID = 1;

	@Autowired
	private NusatripConnector nusatripConnector;

	NusatripFlightService(String coba) {
		System.out.println("\n\n\n" + coba);
	}

	@Override
	public FlightItems flightSearchItem(final FlightParams flightParams) {
		
		final NusatripFlightParams nusatripFlightParams = new NusatripFlightParams();
		nusatripFlightParams.setDepatureDate(flightParams.getDepatureDate());
		nusatripFlightParams.setDepartureAirportCode(flightParams.getDepartureAirportCode());
		nusatripFlightParams.setArrivalAirportCode(flightParams.getArrivalAirportCode());
		nusatripFlightParams.setAdultsNum(flightParams.getAdultsNum());
		nusatripFlightParams.setChildrenNum(flightParams.getChildrenNum());
		nusatripFlightParams.setInfantsNum(flightParams.getInfantsNum());

		final String jsonResponse = nusatripConnector.getSearch(nusatripFlightParams);
		try {
			final NusatripFlightSearchResponse nusatripFlightSearchResponse = NUSATRIP_FLIGHT_SEARCH_READER
					.readValue(jsonResponse);
			if (nusatripFlightSearchResponse == null) {
				return null;
			}
			return flightItemsMapping(nusatripFlightSearchResponse);
		} catch (IOException e) {
			LOGGER.error("flightSearchItem error={}", e.getMessage(), e);
		}
		return null;
	}

	private final FlightItems flightItemsMapping(final NusatripFlightSearchResponse nusatripFlightSearch) {
		final FlightItems flightItems = new FlightItems();
		flightItems.setFlightSearchItemId(SEARCH_ID);
		flightItems.setFlightSearchVendorId(VENDOR_ID);

		final List<FlightSegment> outboundSegments = new ArrayList<>();
		for (final Outbounds outbound : nusatripFlightSearch.getOutbounds()) {
			
			final FlightSegment flightSegment = new FlightSegment();
			flightSegment.setTotalDuration(outbound.getDuration());
			flightSegment.setAvailableSeat(outbound.getAvailableSeat());
			flightSegment.setMaximumSeat(outbound.getMaximumSeat());
			flightSegment.setNumberOfStops(outbound.getNumberOfStops());
			flightSegment.setParam(outbound.getParam());
			
			final MarketingAirline marketingAirline = new MarketingAirline();
			marketingAirline.setAirlineCode(outbound.getAirlineCode());
			marketingAirline.setAirlineName(nusatripFlightSearch.getAirlines().get(outbound.getAirlineCode()));
			marketingAirline.setFlightNumber(outbound.getId());
			marketingAirline.setFlightClassType(FlightClassType.valueOf(outbound.getClassType()));
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
			flightPrice.setCurrency(outbound.getCurrency());
			flightPrice.setPromo(outbound.isPromo());
			flightPrice.setTaxIncluded(outbound.isTaxIncluded());
			flightPrice.setOneWayFare(outbound.getOneWayFare());
			flightPrice.setRoundtripFares(
					(outbound.getRoundtripFares() == null ? 0 : Double.valueOf(outbound.getRoundtripFares())));
			flightPrice.setTotalPrice(outbound.getLowestTotaFare());
			flightSegment.setFlightPrice(flightPrice);
			
			String departureAirportCode = null;
			String arrivalAirportCode = null; 
			long departureDate = 0; 
			long arrivalDate = 0;
			short indexCount = 0;
			final List<FlightRoute> flightRoutes = new ArrayList<FlightRoute>();
			for (final Segments segment : outbound.getSegments()) {
				
				if (indexCount == 0) {
					departureAirportCode = segment.getAirlineCode();
					departureDate = segment.getDepatureTime();
				} else if (indexCount == flightRoutes.size()) {
					arrivalAirportCode = segment.getAirlineCode();
					arrivalDate = segment.getDepatureTime();
				}
				
				final FlightRoute flightRoute = new FlightRoute();
				flightRoute.setAirlineCode(segment.getAirlineCode());
				flightRoute.setAirlineName(nusatripFlightSearch.getAirlines().get(segment.getAirlineCode()));
				flightRoute.setFlightNumber(segment.getFlightNumber());
				flightRoute.setArrivalCity(nusatripFlightSearch.getAirports().get(segment.getArrivalAirportCode()));
				flightRoute.setArrivalAirportCode(segment.getArrivalAirportCode());
				flightRoute.setArrivalDate(segment.getArrivalTime());
				flightRoute.setArrivalAirportTerminal(segment.getArrivalTerminal());
				flightRoute
						.setDepartureCity(nusatripFlightSearch.getAirports().get(segment.getDepartureAirportCode()));
				flightRoute.setDepatureDate(segment.getDepatureTime());
				flightRoute.setDepatureAirportCode(segment.getDepartureAirportCode());
				flightRoute.setDepartureAirportTerminal(segment.getDepartureTerminal());
				flightRoute.setDuration(segment.getDuration());

				final FlightFacility flightFacilityRoute = new FlightFacility();
				final Baggage baggageRoute = new Baggage();
				final LoadDetails loadDetails = new LoadDetails();
				loadDetails.setWeight(segment.getBaggage());
				loadDetails.setBaggageType(BaggageType.valueOf(segment.getBaggageType()));
				baggageRoute.setCheckIn(loadDetails);
				flightFacilityRoute.setBaggage(baggageRoute);
				flightRoute.setFlightFacility(flightFacilityRoute);

				flightRoute.setAircraftType(AircraftType.valueOfString(segment.getAircraftType()));
				flightRoute.setFlightClassType(FlightClassType.valueOf(segment.getClassType()));
				flightRoute.setNoOfStop(segment.getNoOfStop());
				flightRoute.setHiddenStop(segment.isShowHiddenStop());
				flightRoutes.add(flightRoute);
				indexCount++;
			}
			flightSegment.setFlightRoutes(flightRoutes);
			
			flightSegment.setDepartureAirportCode(departureAirportCode);
			flightSegment.setDepartureDate(departureDate);
			flightSegment.setArrivalAirportCode(arrivalAirportCode);
			flightSegment.setArrivalDate(arrivalDate);
			
			outboundSegments.add(flightSegment);
		}
		flightItems.setOutboundFlights(outboundSegments);

		return flightItems;
	}

}

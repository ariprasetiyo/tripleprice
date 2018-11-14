package tripleprice.flight.traveloka;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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
import tripleprice.flight.general.FlightFacility;
import tripleprice.flight.general.LoadDetails;
import tripleprice.flight.search.FlightItems;
import tripleprice.flight.search.FlightParams;
import tripleprice.flight.search.FlightPrice;
import tripleprice.flight.search.FlightRoute;
import tripleprice.flight.search.FlightSegment;
import tripleprice.flight.search.FlightVendorSecurityLevel;
import tripleprice.flight.search.MarketingAirline;
import tripleprice.flight.service.FlightService;
import tripleprice.flight.traveloka.api.request.DataSearch;
import tripleprice.flight.traveloka.api.request.FlightDate;
import tripleprice.flight.traveloka.api.request.NumberSeats;
import tripleprice.flight.traveloka.api.request.SortFilter;
import tripleprice.flight.traveloka.api.request.TravelokaFlightParams;
import tripleprice.flight.traveloka.api.response.ConnectingFlightRoutes;
import tripleprice.flight.traveloka.api.response.SearchResults;
import tripleprice.flight.traveloka.api.response.Segments;
import tripleprice.flight.traveloka.api.response.TravelokaDate;
import tripleprice.flight.traveloka.api.response.TravelokaFlightSearchResponse;
import tripleprice.flight.traveloka.api.response.TravelokaTime;
import tripleprice.util.DateUtil;

/**
 * @author ari.prasetiyo
 */
@Service
public class TravelokaFlightService implements FlightService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TravelokaFlightService.class);
	private static final DateUtil DATE_UTIL = DateUtil.getInstanceThreadSafe();
	private static final String DESKTOP = "desktop";
	private static final String EN_ID = "en_ID";
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final ObjectReader TRAVELOKA_FLIGHT_SEARCH_RESPONSE = OBJECT_MAPPER
			.readerFor(TravelokaFlightSearchResponse.class);
	private static final short VENDOR_ID = 1;
	private static final short SEARCH_ID = 1;
	private static final Calendar CALENDAR = Calendar.getInstance();

	@Autowired
	TravelokaConnector travelokaConnector;

	@Override
	public FlightItems flightSearchItem(final FlightParams flightParams) {

		flightParams.setDepartureAirportCode("JKTA");
		final TravelokaFlightParams travelokaFlightParams = travelokaFlightParamsMapping(flightParams);
		final String responseJsonResult = travelokaConnector.getSearch(travelokaFlightParams);
		try {
			final TravelokaFlightSearchResponse travelokaFlightSearchResponse = TRAVELOKA_FLIGHT_SEARCH_RESPONSE
					.readValue(responseJsonResult);
			return flightItemsMapping(travelokaFlightSearchResponse);
		} catch (IOException e) {
			LOGGER.debug("Error Json parse TravelokaFlightSearchResponse={}", e.getMessage(), e);
		}
		return null;
	}

	private final TravelokaFlightParams travelokaFlightParamsMapping(final FlightParams flightParams) {
		final TravelokaFlightParams travelokaFlightParams = new TravelokaFlightParams();
		travelokaFlightParams.setClientInterface(DESKTOP);

		final DataSearch dataSearch = new DataSearch();
		dataSearch.setCurrency(flightParams.getCurrency());
		dataSearch.setDestionationAirportOrArea(flightParams.getArrivalAirportCode());
		dataSearch.setFlightClassType(flightParams.getFlightClassType());

		final FlightDate flightDate = new FlightDate();
		flightDate.setDay(DATE_UTIL.getDateDD(flightParams.getDepatureDate()));
		flightDate.setMonth(DATE_UTIL.getDateMM(flightParams.getDepatureDate()));
		flightDate.setYear(DATE_UTIL.getDateYYYY(flightParams.getDepatureDate()));
		dataSearch.setFlightDate(flightDate);

		dataSearch.setLocale(EN_ID);
		dataSearch.setNewResult(true);

		final NumberSeats numberSeats = new NumberSeats();
		numberSeats.setAdultsNum(String.valueOf(flightParams.getAdultsNum()));
		numberSeats.setChildrenNum(String.valueOf(flightParams.getChildrenNum()));
		numberSeats.setInfantsNum(String.valueOf(flightParams.getInfantsNum()));
		dataSearch.setNumberSeats(numberSeats);

		dataSearch.setSearchId(null);
		dataSearch.setSeqNo(null);

		final int[] zeroData = {};
		final SortFilter sortFilter = new SortFilter();
		sortFilter.setFilterAirlines(zeroData);
		sortFilter.setFilterArrive(zeroData);
		sortFilter.setFilterDepart(zeroData);
		sortFilter.setFilterTransit(zeroData);
		sortFilter.setSelectedDeparture("");
		sortFilter.setSort(null);
		dataSearch.setSortFilter(sortFilter);

		dataSearch.setSourceAirportOrArea(flightParams.getDepartureAirportCode());
		dataSearch.setUseDateFlow(false);
		dataSearch.setUsePromoFinder(false);

		travelokaFlightParams.setDataSearch(dataSearch);
		travelokaFlightParams.setFields(zeroData);

		return travelokaFlightParams;
	}

	private final FlightItems flightItemsMapping(final TravelokaFlightSearchResponse travelokaFlightSearchResponse) {
		final FlightItems flightItems = new FlightItems();
		flightItems.setFlightSearchItemId(SEARCH_ID);
		flightItems.setFlightSearchVendorId(VENDOR_ID);

		final List<FlightSegment> outboundSegments = new ArrayList<>();
		for (final SearchResults searchResults : travelokaFlightSearchResponse.getDataResponse().getSearchResults()) {
			final FlightSegment flightSegment = new FlightSegment();

			for (ConnectingFlightRoutes flightRouteTraveloka : searchResults.getConnectingFlightRoutes()) {

				long departureDate = 0;
				long arrivalDate = 0;
				short indexCount = 0;
				final List<FlightRoute> flightRoutes = new ArrayList<FlightRoute>();
				for (Segments segment : flightRouteTraveloka.getSegments()) {

					final FlightRoute flightRoute = new FlightRoute();
					flightRoute.setAirlineCode(segment.getAirlineCode());
					// flightRoute.setAirlineName(nusatripFlightSearch.getAirlines().get(segment.getAirlineCode()));
					flightRoute.setFlightNumber(segment.getFlightNumber());
					// flightRoute.setArrivalCity(nusatripFlightSearch.getAirports().get(segment.getArrivalAirportCode()));
					flightRoute.setArrivalAirportCode(segment.getArrivalAirport());
					flightRoute
							.setArrivalDate(getDateTimeTraveloka(segment.getArrivalTime(), segment.getArrivalDate()));
					// flightSegment.setArrivalAirportTerminal(segment.getArrivalTerminal());

					/*
					 * flightSegment
					 * .setDepartureCity(nusatripFlightSearch.getAirports().get(
					 * segment.getDepartureAirportCode()));
					 */
					flightRoute.setDepatureDate(
							getDateTimeTraveloka(segment.getDepartureTime(), segment.getDepartureDate()));
					flightRoute.setDepatureAirportCode(segment.getDepartureAirport());
					// flightRoute.setDepartureAirportTerminal(segment.getDepartureTerminal());
					flightRoute.setDuration(segment.getDurationMinute());

					final FlightFacility flightFacilityRoute = new FlightFacility();
					final Baggage baggageRoute = new Baggage();
					final LoadDetails loadDetails = new LoadDetails();
					loadDetails.setWeight(segment.getFacilities().getBaggage().getWeight());
					loadDetails.setUnitOfMeasure(segment.getFacilities().getBaggage().getUnitOfMeasure());
					baggageRoute.setCheckIn(loadDetails);
					// baggageRoute.setBaggageType(BaggageType.valueOf(segment.getBaggageType()));
					flightFacilityRoute.setBaggage(baggageRoute);
					flightRoute.setFlightFacility(flightFacilityRoute);

					flightRoute.setAircraftType(
							AircraftType.valueOfString(segment.getAircraftInformation().getAircraft().getModel()));
					flightRoute.setFlightClassType(
							FlightClassType.valueOf(segment.getSegmentInventories()[0].getPublishedClass()));
					flightRoute.setNoOfStop((byte) segment.getNumTransit());
					// flightRoute.setHiddenStop(segment.isShowHiddenStop());

					if (indexCount == 0) {
						departureDate = flightRoute.getDepatureDate();
					} else if (indexCount == flightRoutes.size()) {
						arrivalDate = flightRoute.getArrivalDate();
					}
					indexCount++;

					flightRoutes.add(flightRoute);
				}

				flightSegment.setFlightRoutes(flightRoutes);

				flightSegment.setDepartureAirportCode(flightRouteTraveloka.getArrivalAirport());
				flightSegment.setDepartureDate(departureDate);
				flightSegment.setArrivalAirportCode(flightRouteTraveloka.getArrivalAirport());
				flightSegment.setArrivalDate(arrivalDate);

				// flightSegment.setAvailableSeat(outbound.getAvailableSeat());
				// flightSegment.setMaximumSeat(outbound.getMaximumSeat());
				// flightSegment.setNumberOfStops(outbound.getNumberOfStops());

				final MarketingAirline marketingAirline = new MarketingAirline();
				/* Need additional mapping AirAsia */
				/*
				 * marketingAirline.setAirlineName(nusatripFlightSearch.
				 * getAirlines().get(outbound.getAirlineCode()));
				 * marketingAirline.setFlightNumber(outbound.getId());
				 * marketingAirline.setFlightClassType(FlightClassType.valueOf(
				 * outbound.getClassType()));
				 */
				marketingAirline.setAirlineCode(flightRouteTraveloka.getProviderId());
				flightSegment.setMarketingAirline(marketingAirline);

				flightRouteTraveloka.getPromoLabels();
				flightSegment.setNote(flightRouteTraveloka.getFlightRefundInfo().getRefundInfoSummary());
				outboundSegments.add(flightSegment);
			}

			flightSegment.setTotalDuration(searchResults.getTripDuration());
			flightSegment.setNumberOfStops(searchResults.getTotalNumStop());

			final FlightPrice flightPrice = new FlightPrice();
			flightPrice.setCurrency(searchResults.getDesktopPrice().getCurrency());
			/*
			 * flightPrice.setPromo(outbound.isPromo());
			 * flightPrice.setTaxFare(outbound.isTaxIncluded());
			 * flightPrice.setOneWayFare(outbound.getOneWayFare());
			 * flightPrice.setRoundtripFares( (outbound.getRoundtripFares() ==
			 * null ? 0 : Double.valueOf(outbound.getRoundtripFares())));
			 */
			flightPrice.setTotalPrice(searchResults.getDesktopPrice().getAmount());
			if (searchResults.getAirlineFareInfo().getDetailedSearchFares()[0].getFlightRouteFares()
					.getAdultAirlineFare().getCurrency() == flightPrice.getCurrency()) {
				flightPrice.setAdultPrice(searchResults.getAirlineFareInfo().getDetailedSearchFares()[0]
						.getFlightRouteFares().getAdultAirlineFare().getAmount());
			}
			flightSegment.setFlightPrice(flightPrice);

			FlightVendorSecurityLevel flightVendorSecurityLevel = new FlightVendorSecurityLevel();
			flightVendorSecurityLevel.setFlightId(searchResults.getFlightId());
			flightSegment.setFlightVendorSecurityLevel(flightVendorSecurityLevel);
		}
		flightItems.setOutboundFlights(outboundSegments);

		return flightItems;

	}

	private long getDateTimeTraveloka(final TravelokaTime arrivalTime, final TravelokaDate travelokaDate) {
		CALENDAR.set(travelokaDate.getYear(), travelokaDate.getMonth(), travelokaDate.getDay(), arrivalTime.getHour(),
				arrivalTime.getMinute());
		return CALENDAR.getTimeInMillis();
	}
}

package tripleprice.service.flight.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.search.FlightItems;
import tripleprice.flight.search.FlightParams;
import tripleprice.flight.traveloka.TravelokaFlightService;
import tripleprice.flight.traveloka.api.request.DataSearch;
import tripleprice.flight.traveloka.api.request.FlightDate;
import tripleprice.flight.traveloka.api.request.NumberSeats;
import tripleprice.flight.traveloka.api.request.SortFilter;
import tripleprice.flight.traveloka.api.request.TravelokaFlightParams;

/**
 * @author ari.prasetiyo
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "file:resources/application.properties")
public class TravelokaFlightServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TravelokaFlightServiceTest.class);

	@Autowired
	TravelokaFlightService travelokaFlightService;

	@Test
	public void TravelokaGetSearchTest() {
		FlightItems flightItems = travelokaFlightService.flightSearchItem(getFlightParams());
		System.out.println("\n\n" + flightItems.toString());
		LOGGER.debug("\n\n", flightItems.toString());
	}

	private final TravelokaFlightParams geTravelokaFlightParams() {
		final TravelokaFlightParams travelokaFlightParams = new TravelokaFlightParams();
		travelokaFlightParams.setClientInterface("desktop");

		DataSearch dataSearch = new DataSearch();
		dataSearch.setCurrency("IDR");
		dataSearch.setDestionationAirportOrArea("DPS");

		dataSearch.setFlightClassType(FlightClassType.ECONOMY);

		FlightDate flightDate = new FlightDate();
		flightDate.setDay("9");
		flightDate.setMonth("11");
		flightDate.setYear("2018");
		dataSearch.setFlightDate(flightDate);

		dataSearch.setLocale("en_ID");
		dataSearch.setNewResult(true);

		NumberSeats numberSeats = new NumberSeats();
		numberSeats.setAdultsNum("1");
		numberSeats.setChildrenNum("0");
		numberSeats.setInfantsNum("0");
		dataSearch.setNumberSeats(numberSeats);

		dataSearch.setSearchId(null);
		dataSearch.setSeqNo(null);

		int[] zeroData = {};
		SortFilter sortFilter = new SortFilter();
		sortFilter.setFilterAirlines(zeroData);
		sortFilter.setFilterArrive(zeroData);
		sortFilter.setFilterDepart(zeroData);
		sortFilter.setFilterTransit(zeroData);
		sortFilter.setSelectedDeparture("");
		sortFilter.setSort(null);
		dataSearch.setSortFilter(sortFilter);

		dataSearch.setSourceAirportOrArea("JKTA");
		dataSearch.setUseDateFlow(false);
		dataSearch.setUsePromoFinder(false);

		travelokaFlightParams.setDataSearch(dataSearch);
		travelokaFlightParams.setFields(zeroData);
		return travelokaFlightParams;
	}

	private final FlightParams getFlightParams() {
		FlightParams flightParams = new FlightParams();
		flightParams.setCurrency("IDR");
		flightParams.setDepartureAirportCode("JKTA");
		flightParams.setChildrenNum((byte) 0);
		flightParams.setInfantsNum((byte) 0);
		flightParams.setAdultsNum((byte) 1);
		flightParams.setFlightClassType(FlightClassType.ECONOMY);
		flightParams.setArrivalAirportCode("DPS");

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DATE, 30);
		flightParams.setDepatureDate(cal.getTime());

		return flightParams;
	}
}

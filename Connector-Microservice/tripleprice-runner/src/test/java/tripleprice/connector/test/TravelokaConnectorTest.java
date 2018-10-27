package tripleprice.connector.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.traveloka.TravelokaConnector;
import tripleprice.flight.traveloka.json.request.DataSearch;
import tripleprice.flight.traveloka.json.request.FlightDate;
import tripleprice.flight.traveloka.json.request.NumberSeats;
import tripleprice.flight.traveloka.json.request.SortFilter;
import tripleprice.flight.traveloka.json.request.TravelokaFlightParams;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(locations = "file:resources/application.properties")
public class TravelokaConnectorTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TravelokaConnectorTest.class);
	private static final ObjectMapper jsonObjectMapper = new ObjectMapper();
	private static final ObjectWriter jsonSearchRequest = jsonObjectMapper.writerFor(TravelokaFlightParams.class);

	@Autowired
	TravelokaConnector travelokaConnector;

	@Test
	public void connectorTest() throws JsonProcessingException {

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
		// final String responseJsonResult =
		travelokaConnector.getSearch(travelokaFlightParams);

		//LOGGER.debug("\nJson result={}", jsonSearchRequest.writeValueAsString(travelokaFlightParams));
		// LOGGER.debug("Result test={}",
		// TripepriceProperties.getUrlFlightSearchFindKey());
	}
}

package tripleprice.connector.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.enumuration.TripType;
import tripleprice.flight.tiket.com.TiketComConnector;
import tripleprice.flight.tiket.com.enumeration.ResultType;
import tripleprice.flight.tiket.com.pojo.TiketComFlightParams;

/**
 * @author ari.prasetiyo
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "file:resources/application.properties")
public class TiketComConnectorTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TiketComConnectorTest.class);

	@Autowired
	TiketComConnector tiketComConnector;

	/**
	 * /* https://www.tiket.com/ms-gateway/tix-flight-search/search?origin=DPS&
	 * destination=JKTC&departureDate=2018-12-11&adult=1&child=0&infant=0&cabinClass
	 * =ECONOMY&originType=AIRPORT&destinationType=CITY&searchType=ONE_WAY&
	 * resultType=ALL&async=true
	 */
	@Test
	public void TiketComConnectorGetSearchTest() {

		final TiketComFlightParams tiketComFlightParams = new TiketComFlightParams();
		tiketComFlightParams.setOrigin("DPS");
		tiketComFlightParams.setDestination("JKTC");
		tiketComFlightParams.setDepatureDate("2018-12-11");
		tiketComFlightParams.setAdult((byte) 1);
		tiketComFlightParams.setChild((byte) 0);
		tiketComFlightParams.setInfant((byte) 0);
		tiketComFlightParams.setFlightClassType(FlightClassType.ECONOMY);
		tiketComFlightParams.setOriginType("AIRPORT");
		tiketComFlightParams.setDestionationType("CITY");
		tiketComFlightParams.setTripType(TripType.ONE_WAY);
		tiketComFlightParams.setResultType(ResultType.ALL);
		tiketComFlightParams.setAsync(true);

		tiketComConnector.getSearch(tiketComFlightParams);
	}
}

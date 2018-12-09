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
import tripleprice.flight.enumuration.TripType;
import tripleprice.flight.search.FlightItems;
import tripleprice.flight.search.FlightParams;
import tripleprice.flight.tiket.com.TiketComFlightService;

/**
 * @author ari.prasetiyo
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "file:resources/application.properties")
public class TiketComFlightServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(TiketComFlightServiceTest.class);

	@Autowired
	TiketComFlightService tiketComFlightService;

	@Test
	public void TiketComSearchTest() {
		final FlightParams flightParams = new FlightParams();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DATE, 11);

		flightParams.setDepatureDate(cal.getTime());
		flightParams.setDepartureAirportCode("DPS");
		flightParams.setArrivalAirportCode("JKTC");
		flightParams.setAdultsNum((byte) 1);
		flightParams.setFlightClassType(FlightClassType.ECONOMY);
		flightParams.setTripType(TripType.ONE_WAY);		
		
		FlightItems flightItems = tiketComFlightService.flightSearchItem(flightParams);
		System.out.println("\n\n"+ flightItems.toString());
		LOGGER.debug("\n\n", flightItems.toString());
	}
}

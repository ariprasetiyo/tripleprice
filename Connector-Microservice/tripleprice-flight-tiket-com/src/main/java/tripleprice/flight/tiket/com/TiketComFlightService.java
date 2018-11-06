package tripleprice.flight.tiket.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleprice.flight.FlightItems;
import tripleprice.flight.FlightParams;
import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.enumuration.TripType;
import tripleprice.flight.service.FlightService;
import tripleprice.flight.tiket.com.enumeration.ResultType;
import tripleprice.flight.tiket.com.pojo.TiketComFlightParams;

/**
 * @author ari.prasetiyo
 */
@Service
public class TiketComFlightService implements FlightService {

	@Autowired
	TiketComConnector tiketComConnector;

	@Override
	public FlightItems flightSearchItem(final FlightParams flightParams) {
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
				final String responseJsonResult = tiketComConnector.getSearch(tiketComFlightParams);
		return null;
	}

}

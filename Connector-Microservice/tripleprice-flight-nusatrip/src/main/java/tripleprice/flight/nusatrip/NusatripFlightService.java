package tripleprice.flight.nusatrip;

import tripleprice.flight.service.FlightConnectorService;
import tripleprice.flight.bean.FlightSearchItem;

/**
 * 
 * @author root
 * 
 *         http://www.nusatrip.com/flights/search?departDate=20180924&lang=en&departure=DPS&adultNum=2&arrival=CGK
 */
public class NusatripFlightService implements FlightConnectorService {

	@Override
	public FlightSearchItem flightSearchItem() {
		NusatripConnector NusatripConnector = new NusatripConnector();
		return null;
	}

}

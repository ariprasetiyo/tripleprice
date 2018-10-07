package tripleprice.flight.nusatrip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleprice.flight.bean.FlightSearchItem;
import tripleprice.flight.service.FlightService;

/**
 * 
 * @author root
 * 
 *         http://www.nusatrip.com/flights/search?departDate=20180924&lang=en&departure=DPS&adultNum=2&arrival=CGK
 */
@Service
public class NusatripFlightService implements FlightService {

	@Autowired
	NusatripConnector nusatripConnector;

	NusatripFlightService(String coba) {
		System.out.println("\n\n\n" + coba);
	}

	@Override
	public FlightSearchItem flightSearchItem() {
		nusatripConnector.getSearch();
		return null;
	}

}

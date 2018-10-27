package tripleprice.flight.nusatrip;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleprice.flight.FlightItems;
import tripleprice.flight.FlightParams;
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
	public FlightItems flightSearchItem(final FlightParams flightParams) {
		NusatripFlightParams nusatripFlightParams = new NusatripFlightParams();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DATE, 30);
		
		nusatripFlightParams.setDepatureDate(cal.getTime());
		nusatripFlightParams.setDepatureAirportCode("CGK");
		nusatripFlightParams.setArrivalAirportCode("DPS");
		nusatripFlightParams.setAdultsNum((byte)1);
		nusatripConnector.getSearch(nusatripFlightParams);
		return null;
	}

}

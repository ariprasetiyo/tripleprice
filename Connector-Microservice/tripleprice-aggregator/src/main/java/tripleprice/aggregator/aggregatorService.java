package tripleprice.aggregator;

import java.util.ArrayList;
import java.util.List;

import tripleprice.flight.bean.FlightSearchItem;
import tripleprice.flight.nusatrip.NusatripConnectorService;
import tripleprice.flight.service.FlightConnectorService;
import tripleprice.flight.traveloka.TravelokaConnectorService;

public class aggregatorService {

	List<FlightConnectorService> sas = new ArrayList<>();

	public aggregatorService() {
		FlightConnectorService nusatrip = new NusatripConnectorService();
		FlightConnectorService traveloka = new TravelokaConnectorService();

		sas.add(nusatrip);
		sas.add(traveloka);
	}

	public FlightSearchItem getFlightSearch() {
		return sas.get(1).flightSearchItem();
	}
}

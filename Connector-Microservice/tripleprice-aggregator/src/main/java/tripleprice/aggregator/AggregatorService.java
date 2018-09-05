package tripleprice.aggregator;

import java.util.ArrayList;
import java.util.List;

import tripleprice.flight.bean.FlightSearchItem;
import tripleprice.flight.nusatrip.NusatripFlightService;
import tripleprice.flight.service.FlightConnectorService;
import tripleprice.flight.traveloka.TravelokaFlightService;

public class AggregatorService {

	List<FlightConnectorService> sas = new ArrayList<>();

	public AggregatorService() {
		FlightConnectorService nusatrip = new NusatripFlightService();
		FlightConnectorService traveloka = new TravelokaFlightService();

		sas.add(nusatrip);
		sas.add(traveloka);
	}

	public FlightSearchItem getFlightSearch() {
		return sas.get(0).flightSearchItem();
	}
}

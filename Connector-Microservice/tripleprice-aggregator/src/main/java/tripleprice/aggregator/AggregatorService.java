package tripleprice.aggregator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tripleprice.flight.bean.FlightSearchItem;
import tripleprice.flight.service.FlightService;

@Service
public class AggregatorService {

	List<FlightService> flightServiceList = new ArrayList<>();

	public AggregatorService(List<FlightService> flightServiceList) {
		this.flightServiceList = flightServiceList;
	}

	public FlightSearchItem getFlightSearch() {
		return flightServiceList.get(0).flightSearchItem();
	}
}

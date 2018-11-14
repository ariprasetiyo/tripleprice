package tripleprice.flight.service;

import tripleprice.flight.search.FlightItems;
import tripleprice.flight.search.FlightParams;

public interface FlightService {
	FlightItems flightSearchItem(final FlightParams flightParams);
}

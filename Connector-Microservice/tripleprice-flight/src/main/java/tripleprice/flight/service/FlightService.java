package tripleprice.flight.service;

import tripleprice.flight.FlightItems;
import tripleprice.flight.FlightParams;

public interface FlightService {
	FlightItems flightSearchItem(final FlightParams flightParams);
}

package tripleprice.flight.enumuration;

public enum FlightClassType {

	ECONOMY(0), CHEAPEST(1), BUSINESS(2);

	int intValue;

	FlightClassType(int intValue) {
		this.intValue = intValue;
	}

	FlightClassType valueOf(byte intValue) {
		switch (intValue) {
		case 0:
			return ECONOMY;
		case 1:
			return CHEAPEST;
		case 2:
			return BUSINESS;
		default:
			return null;
		}
	}
}

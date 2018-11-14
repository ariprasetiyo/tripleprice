package tripleprice.flight.enumuration;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public enum FlightClassType {

	ECONOMY(0), CHEAPEST(1), BUSINESS(2);

	int intValue;

	FlightClassType(int intValue) {
		this.intValue = intValue;
	}

	public static FlightClassType valueOf(final byte intValue) {
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
	
	public static FlightClassType valueOfString(final String stringValue) {
		
		if (stringValue == null)
			return null;

		switch (stringValue.toUpperCase()) {
		case "ECONOMY":
			return ECONOMY;
		case "CHEAPEST":
			return CHEAPEST;
		case "BUSINESS":
			return BUSINESS;
		default:
			return null;
		}
	}
}

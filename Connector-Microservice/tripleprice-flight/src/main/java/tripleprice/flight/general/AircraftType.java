package tripleprice.flight.general;

/**
 * @author ari.prasetiyo
 */
public enum AircraftType {
	Unknown(-2), Null(-1), Boeing(0), Airbus(1), Cessna(2);

	int intValue;

	AircraftType(int intValue) {
		this.intValue = intValue;
	}

	public static AircraftType valueOf(final short shortValue) {
		switch (shortValue) {
		case 0:
			return Boeing;
		case 1:
			return Airbus;
		case 2:
			return Cessna;
		default:
			return Unknown;
		}
	}

	public static AircraftType valueOfString(final String stringValue) {

		if (stringValue == null)
			return Null;

		switch (stringValue.toLowerCase()) {
		case "boeing":
			return Boeing;
		case "airbus":
			return Airbus;
		case "cessna":
			return Cessna;
		default:
			return Unknown;
		}
	}

}

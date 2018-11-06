package tripleprice.flight.tiket.com.enumeration;

/**
 * @author ari.prasetiyo
 */
public enum ResultType {
	ALL(0);
	int intValue;

	ResultType(int intValue) {
		this.intValue = intValue;
	}

	ResultType valueOf(int intValue) {
		switch (intValue) {
		case 0:
			return ALL;
		default:
			return null;
		}
	}
}

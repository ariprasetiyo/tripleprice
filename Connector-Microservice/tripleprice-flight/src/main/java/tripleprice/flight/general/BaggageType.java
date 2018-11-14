package tripleprice.flight.general;

/**
 * @author ari.prasetiyo
 *
 */
public enum BaggageType {

	GOODS(0), SPORT(1);

	int intValue;

	BaggageType(int intValue) {
		this.intValue = intValue;
	}

	public static BaggageType valueOf(short intValue) {
		switch (intValue) {
		case 0:
			return GOODS;
		case 1:
			return SPORT;
		default:
			return null;
		}
	}

}

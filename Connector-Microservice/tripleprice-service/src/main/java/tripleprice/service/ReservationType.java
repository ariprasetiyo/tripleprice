package tripleprice.service;

/**
 * @author ari.prasetiyo
 */
public enum ReservationType {

	TRAIN(0), FLIGHT(1), BUS(2), HOTEL(3);

	int intValue;

	ReservationType(int intValue) {
		this.intValue = intValue;
	}

	public static ReservationType valueOf(int intValue) {
		switch (intValue) {
		case 0:
			return TRAIN;
		case 1:
			return FLIGHT;
		case 2:
			return BUS;
		case 3:
			return HOTEL;
		default:
			return null;
		}
	}

}

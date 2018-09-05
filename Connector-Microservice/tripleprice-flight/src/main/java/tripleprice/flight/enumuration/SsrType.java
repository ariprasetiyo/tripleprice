package tripleprice.flight.enumuration;

public enum SsrType {
	SPORTS(1), MEAL(2), BAGGAGE(3);

	int intValue;

	SsrType(int intValue) {
		this.intValue = intValue;
	}

	/**
	 * 
	 * @param intValue
	 * @return
	 */
	SsrType valueOf(int intValue) {
		switch (intValue) {
		case 1:
			return SPORTS;
		case 2:
			return MEAL;
		case 3:
			return BAGGAGE;
		default:
			return null;
		}
	}
}

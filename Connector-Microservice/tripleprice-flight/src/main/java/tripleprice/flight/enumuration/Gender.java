package tripleprice.flight.enumuration;

public enum Gender {
	MALE(1), FEMALE(0);

	int intValue;

	Gender(int intValue) {
		this.intValue = intValue;
	}

	/**
	 * 
	 * @param intValue
	 * @return
	 */
	Gender valueOf(byte intValue) {
		switch (intValue) {
		case 0:
			return MALE;
		case 1:
			return FEMALE;
		default:
			return null;
		}
	}
}

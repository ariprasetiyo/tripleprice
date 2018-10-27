package tripleprice.flight.enumuration;

public enum Title {
	Mr(1), Miss(2), Mis(3);

	int intValue;

	Title(int intValue) {
		this.intValue = intValue;
	}

	/**
	 * 
	 * @param intValue
	 * @return
	 */
	Title valueOf(byte intValue) {
		switch (intValue) {
		case 1:
			return Mr;
		case 2:
			return Miss;
		case 3:
			return Mis;
		default:
			return null;
		}
	}
}

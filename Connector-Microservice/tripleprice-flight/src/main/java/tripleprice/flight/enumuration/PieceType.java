package tripleprice.flight.enumuration;

public enum PieceType {
	GRAM(1), KG(2), TON(3), CM(100), M(101), 
	KM(102), BED(200), ROOM(201), PERSON(301);

	int intValue;

	PieceType(int intValue) {
		this.intValue = intValue;
	}

	/**
	 * 
	 * @param intValue
	 * @return
	 */
	PieceType valueOf(short intValue) {
		switch (intValue) {
		case 1:
			return GRAM;
		case 2:
			return KG;
		case 3:
			return TON;
		case 100:
			return CM;
		case 101:
			return M;
		case 102:
			return KM;
		case 200:
			return BED;
		case 201:
			return ROOM;
		case 300:
			return PERSON;
		default:
			return null;
		}
	}
}

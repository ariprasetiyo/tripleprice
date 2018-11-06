package tripleprice.flight.enumuration;

/**
 * @author ari.prasetiyo
 */
public enum TripType {
	ONE_WAY(0), ROUNDTRIP(1);
	
	int intValue;
	TripType(int intValue){
		this.intValue = intValue;
	}
	
	TripType valueOf(int intValue){
		switch(intValue){
		case 0 :
			return ONE_WAY;
		case 1 :
			return ROUNDTRIP;
		default :
			return null;
		}
	}
}

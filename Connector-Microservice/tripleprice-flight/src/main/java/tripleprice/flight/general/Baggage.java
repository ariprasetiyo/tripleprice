package tripleprice.flight.general;

/**
 * @author ari.prasetiyo
 */
public class Baggage {

	private LoadDetails cabin;
	private LoadDetails checkIn;

	public LoadDetails getCabin() {
		return cabin;
	}

	public void setCabin(final LoadDetails cabin) {
		this.cabin = cabin;
	}

	public LoadDetails getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(final LoadDetails checkIn) {
		this.checkIn = checkIn;
	}

}

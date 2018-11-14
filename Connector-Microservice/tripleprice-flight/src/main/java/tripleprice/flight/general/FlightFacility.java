package tripleprice.flight.general;

/**
 * @author ari.prasetiyo
 */
public class FlightFacility {

	private Baggage baggage;
	private boolean isWifi;
	private boolean isFreeMeal;
	private boolean iseEntertainment;
	private boolean isUsbAndPower;
	private FlightFacility[] order;

	public Baggage getBaggage() {
		return baggage;
	}

	public void setBaggage(Baggage baggage) {
		this.baggage = baggage;
	}

	public boolean isWifi() {
		return isWifi;
	}

	public void setWifi(boolean isWifi) {
		this.isWifi = isWifi;
	}

	public boolean isFreeMeal() {
		return isFreeMeal;
	}

	public void setFreeMeal(boolean isFreeMeal) {
		this.isFreeMeal = isFreeMeal;
	}

	public boolean isIseEntertainment() {
		return iseEntertainment;
	}

	public void setIseEntertainment(boolean iseEntertainment) {
		this.iseEntertainment = iseEntertainment;
	}

	public boolean isUsbAndPower() {
		return isUsbAndPower;
	}

	public void setUsbAndPower(boolean isUsbAndPower) {
		this.isUsbAndPower = isUsbAndPower;
	}

	public FlightFacility[] getOrder() {
		return order;
	}

	public void setOrder(FlightFacility[] order) {
		this.order = order;
	}

}

package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = ANY,
        getterVisibility = NONE,
        isGetterVisibility = NONE,
        setterVisibility = NONE)
public class Facilities {
	
	private Baggage baggage;

	private Wifi wifi;

	private FreeMeal freeMeal;
	private Entertainment entertainment;
	private UsbAndPower usbAndPower;
	private String[] order;

	public Baggage getBaggage() {
		return baggage;
	}

	public void setBaggage(final Baggage baggage) {
		this.baggage = baggage;
	}

	public Wifi getWifi() {
		return wifi;
	}

	public void setWifi(final Wifi wifi) {
		this.wifi = wifi;
	}

	public FreeMeal getFreeMeal() {
		return freeMeal;
	}

	public void setFreeMeal(final FreeMeal freeMeal) {
		this.freeMeal = freeMeal;
	}

	public Entertainment getEntertainment() {
		return entertainment;
	}

	public void setEntertainment(final Entertainment entertainment) {
		this.entertainment = entertainment;
	}

	public UsbAndPower getUsbAndPower() {
		return usbAndPower;
	}

	public void setUsbAndPower(final UsbAndPower usbAndPower) {
		this.usbAndPower = usbAndPower;
	}

	public String[] getOrder() {
		return order;
	}

	public void setOrder(final String[] order) {
		this.order = order;
	}

}

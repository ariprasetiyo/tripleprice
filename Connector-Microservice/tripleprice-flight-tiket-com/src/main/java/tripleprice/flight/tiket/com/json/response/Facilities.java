package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
// @JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Facilities {
	private FacilitiesAvailable meal;
	private FacilitiesAvailable wifi;
	private FacilitiesAvailable usb;
	private FacilitiesAvailable entertainment;

	public FacilitiesAvailable getMeal() {
		return meal;
	}

	public void setMeal(final FacilitiesAvailable meal) {
		this.meal = meal;
	}

	public FacilitiesAvailable getWifi() {
		return wifi;
	}

	public void setWifi(final FacilitiesAvailable wifi) {
		this.wifi = wifi;
	}

	public FacilitiesAvailable getUsb() {
		return usb;
	}

	public void setUsb(final FacilitiesAvailable usb) {
		this.usb = usb;
	}

	public FacilitiesAvailable getEntertainment() {
		return entertainment;
	}

	public void setEntertainment(final FacilitiesAvailable entertainment) {
		this.entertainment = entertainment;
	}

}

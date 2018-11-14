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
public class UsbAndPower {
	private boolean usb;
	private boolean power;
	private String chance;

	public boolean isUsb() {
		return usb;
	}

	public void setUsb(final boolean usb) {
		this.usb = usb;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(final boolean power) {
		this.power = power;
	}

	public String getChance() {
		return chance;
	}

	public void setChance(final String chance) {
		this.chance = chance;
	}

}

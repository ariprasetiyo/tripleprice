package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Luggage {
	private short unit;
	private String measurement;

	@JsonProperty("qty")
	private short quantity;

	public short getUnit() {
		return unit;
	}

	public void setUnit(final short unit) {
		this.unit = unit;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(final String measurement) {
		this.measurement = measurement;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(final short quantity) {
		this.quantity = quantity;
	}

}

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
public class Baggage {
	private String unitOfMeasure;
	private short weight;
	private short quantity;
	private boolean availableToBuy;

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(final String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public short getWeight() {
		return weight;
	}

	public void setWeight(final short weight) {
		this.weight = weight;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(final short quantity) {
		this.quantity = quantity;
	}

	public boolean isAvailableToBuy() {
		return availableToBuy;
	}

	public void setAvailableToBuy(final boolean availableToBuy) {
		this.availableToBuy = availableToBuy;
	}

}

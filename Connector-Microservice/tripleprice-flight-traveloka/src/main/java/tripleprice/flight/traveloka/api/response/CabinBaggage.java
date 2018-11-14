package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author ari.prasetiyo
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = ANY,
        getterVisibility = NONE,
        isGetterVisibility = NONE,
        setterVisibility = NONE)
public class CabinBaggage {
	private String unitOfMeasure;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short weight;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short quantity;

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
    
}

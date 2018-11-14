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
public class SubclassInfo {
	private String seatBrandName;
	
	@JsonSerialize(using = ToStringSerializer.class)
    private short mileagePercentage;

	public String getSeatBrandName() {
		return seatBrandName;
	}

	public void setSeatBrandName(String seatBrandName) {
		this.seatBrandName = seatBrandName;
	}

	public short getMileagePercentage() {
		return mileagePercentage;
	}

	public void setMileagePercentage(short mileagePercentage) {
		this.mileagePercentage = mileagePercentage;
	}

}

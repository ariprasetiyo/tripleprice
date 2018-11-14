package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 * 
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
		fieldVisibility = ANY,
		getterVisibility =NONE, 
		setterVisibility = NONE, 
		isGetterVisibility = NONE
		)
public class AdditionalInfo {
	String seatClassLabel;

	public String getSeatClassLabel() {
		return seatClassLabel;
	}

	public void setSeatClassLabel(final String seatClassLabel) {
		this.seatClassLabel = seatClassLabel;
	}

}

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
		getterVisibility =NONE, 
		setterVisibility = NONE, 
		isGetterVisibility = NONE
		)
public class AncillaryFare {
	private String addOnFares[];
	private String serviceFares[];

	public String[] getAddOnFares() {
		return addOnFares;
	}

	public void setAddOnFares(final String[] addOnFares) {
		this.addOnFares = addOnFares;
	}

	public String[] getServiceFares() {
		return serviceFares;
	}

	public void setServiceFares(final String[] serviceFares) {
		this.serviceFares = serviceFares;
	}
}

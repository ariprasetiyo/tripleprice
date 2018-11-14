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
public class FlightRefundInfo {
	 
	private String refundableStatus;
	private String refundInfoSummary;
	private String[] policyDetails;

	public String getRefundableStatus() {
		return refundableStatus;
	}

	public void setRefundableStatus(final String refundableStatus) {
		this.refundableStatus = refundableStatus;
	}

	public String getRefundInfoSummary() {
		return refundInfoSummary;
	}

	public void setRefundInfoSummary(final String refundInfoSummary) {
		this.refundInfoSummary = refundInfoSummary;
	}

	public String[] getPolicyDetails() {
		return policyDetails;
	}

	public void setPolicyDetails(final String[] policyDetails) {
		this.policyDetails = policyDetails;
	}

}

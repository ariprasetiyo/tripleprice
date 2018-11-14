package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
		fieldVisibility = ANY,
		getterVisibility =NONE, 
		setterVisibility = NONE, 
		isGetterVisibility = NONE
		)
public class FlightRescheduleInfo {
	String rescheduleStatus;
	String rescheduleInfoSummary;
	String[] policyDetails;

	public String getRescheduleStatus() {
		return rescheduleStatus;
	}

	public void setRescheduleStatus(final String rescheduleStatus) {
		this.rescheduleStatus = rescheduleStatus;
	}

	public String getRescheduleInfoSummary() {
		return rescheduleInfoSummary;
	}

	public void setRescheduleInfoSummary(final String rescheduleInfoSummary) {
		this.rescheduleInfoSummary = rescheduleInfoSummary;
	}

	public String[] getPolicyDetails() {
		return policyDetails;
	}

	public void setPolicyDetails(final String[] policyDetails) {
		this.policyDetails = policyDetails;
	}

}

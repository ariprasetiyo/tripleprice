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
public class AgentFareInfo {
	
	private AirlineFare totalSearchFare;
	private AirlineFare totalAdditionalFare;
	private DetailedSearchFares[] detailedSearchFares;

	public AirlineFare getTotalSearchFare() {
		return totalSearchFare;
	}

	public void setTotalSearchFare(final AirlineFare totalSearchFare) {
		this.totalSearchFare = totalSearchFare;
	}

	public AirlineFare getTotalAdditionalFare() {
		return totalAdditionalFare;
	}

	public void setTotalAdditionalFare(final AirlineFare totalAdditionalFare) {
		this.totalAdditionalFare = totalAdditionalFare;
	}

	public DetailedSearchFares[] getDetailedSearchFares() {
		return detailedSearchFares;
	}

	public void setDetailedSearchFares(final DetailedSearchFares[] detailedSearchFares) {
		this.detailedSearchFares = detailedSearchFares;
	}

}

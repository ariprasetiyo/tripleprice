package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ari.prasetiyo
 *
 */
@JsonInclude(NON_EMPTY)
@JsonAutoDetect(
        fieldVisibility = ANY,
        getterVisibility = NONE,
        isGetterVisibility = NONE,
        setterVisibility = NONE)
public class TravelokaFlightSearchResponse {
	
	@JsonProperty("data")
	DataResponse dataResponse;
	String userContext;

	public DataResponse getDataResponse() {
		return dataResponse;
	}

	public void setDataResponse(final DataResponse dataResponse) {
		this.dataResponse = dataResponse;
	}

	public String getUserContext() {
		return userContext;
	}

	public void setUserContext(final String userContext) {
		this.userContext = userContext;
	}
	
}

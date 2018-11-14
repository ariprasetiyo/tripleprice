package tripleprice.flight.nusatrip.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author ari.prasetiyo
 */
@JsonInclude(NON_EMPTY)
@JsonAutoDetect(
        fieldVisibility = ANY,
        getterVisibility = NONE,
        isGetterVisibility = NONE,
        setterVisibility = NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LowestFare {

	String outbound;

	public String getOutbound() {
		return outbound;
	}

	public void setOutbound(String outbound) {
		this.outbound = outbound;
	}
	
}

package tripleprice.flight.traveloka.json.request;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ari.prasetiyo
 */
@JsonInclude(NON_EMPTY)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class NumberSeats {

	@JsonProperty("numChildren")
	private String childrenNum;

	@JsonProperty("numAdults")
	private String adultsNum;

	@JsonProperty("numInfants")
	private String infantsNum;

	public String getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(String childrenNum) {
		this.childrenNum = childrenNum;
	}

	public String getAdultsNum() {
		return adultsNum;
	}

	public void setAdultsNum(String adultsNum) {
		this.adultsNum = adultsNum;
	}

	public String getInfantsNum() {
		return infantsNum;
	}

	public void setInfantsNum(String infantsNum) {
		this.infantsNum = infantsNum;
	}

}

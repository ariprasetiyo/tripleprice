package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * @author ari.prasetiyo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_EMPTY)
@JsonAutoDetect(
		fieldVisibility = ANY,
		setterVisibility = NONE,
		getterVisibility = NONE,isGetterVisibility = NONE
		)
public class AirlineData {
	private String airlineId;
	private String name;
	private String shortName;
	private String iconUrl;

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(final String airlineId) {
		this.airlineId = airlineId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(final String shortName) {
		this.shortName = shortName;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(final String iconUrl) {
		this.iconUrl = iconUrl;
	}
     
}

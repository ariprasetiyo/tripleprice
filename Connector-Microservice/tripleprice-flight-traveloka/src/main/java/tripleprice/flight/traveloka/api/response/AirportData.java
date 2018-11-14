package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

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
public class AirportData {
	private String airportId;
	private String localName;
	private String city;
	private String country;

	public String getAirportId() {
		return airportId;
	}

	public void setAirportId(final String airportId) {
		this.airportId = airportId;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(final String localName) {
		this.localName = localName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

}

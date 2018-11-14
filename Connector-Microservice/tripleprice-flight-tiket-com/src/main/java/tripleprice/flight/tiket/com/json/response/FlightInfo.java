package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class FlightInfo {
	private String date;
	private String time;
	private String timezone;
	private String airportCode;
	private String airportName;
	private String cityCode;
	private String cityName;
	private String terminal;
	private String countryCode;

	public String getDate() {
		return date;
	}

	public void setDate(final String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(final String time) {
		this.time = time;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(final String timezone) {
		this.timezone = timezone;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(final String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(final String airportName) {
		this.airportName = airportName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(final String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(final String cityName) {
		this.cityName = cityName;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(final String terminal) {
		this.terminal = terminal;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

}

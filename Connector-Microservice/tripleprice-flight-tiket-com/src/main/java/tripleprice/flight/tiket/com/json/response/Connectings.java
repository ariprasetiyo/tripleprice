package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Connectings {
	private String arrivalTime;
	private String departureTime;
	double timezone;
	private String airportName;
	private String airportCode;
	private String cityCode;
	private String cityName;
	private String departureTerminal;
	private String arrivalTerminal;
	private TiketComTime totalTime;
	private short connectingTime;

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(final String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(final String departureTime) {
		this.departureTime = departureTime;
	}

	public double getTimezone() {
		return timezone;
	}

	public void setTimezone(final double timezone) {
		this.timezone = timezone;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(final String airportName) {
		this.airportName = airportName;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(final String airportCode) {
		this.airportCode = airportCode;
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

	public String getDepartureTerminal() {
		return departureTerminal;
	}

	public void setDepartureTerminal(final String departureTerminal) {
		this.departureTerminal = departureTerminal;
	}

	public String getArrivalTerminal() {
		return arrivalTerminal;
	}

	public void setArrivalTerminal(final String arrivalTerminal) {
		this.arrivalTerminal = arrivalTerminal;
	}

	public TiketComTime getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(final TiketComTime totalTime) {
		this.totalTime = totalTime;
	}

	public short getConnectingTime() {
		return connectingTime;
	}

	public void setConnectingTime(final short connectingTime) {
		this.connectingTime = connectingTime;
	}

}

package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

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
public class FlightLegInfoList {
	private String departureAirport;
	private String arrivalAirport;
	private TravelokaDate departureDate;
	private TravelokaDate arrivalDate;
	private TravelokaTime departureTime;
	private TravelokaTime arrivalTime;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short transitDurationMinute;

	@JsonSerialize(using = ToStringSerializer.class)
	private short flightDurationMinute;

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(final String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(final String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public TravelokaDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(final TravelokaDate departureDate) {
		this.departureDate = departureDate;
	}

	public TravelokaDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(final TravelokaDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public TravelokaTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(final TravelokaTime departureTime) {
		this.departureTime = departureTime;
	}

	public TravelokaTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(final TravelokaTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public short getTransitDurationMinute() {
		return transitDurationMinute;
	}

	public void setTransitDurationMinute(final short transitDurationMinute) {
		this.transitDurationMinute = transitDurationMinute;
	}

	public short getFlightDurationMinute() {
		return flightDurationMinute;
	}

	public void setFlightDurationMinute(final short flightDurationMinute) {
		this.flightDurationMinute = flightDurationMinute;
	}

}

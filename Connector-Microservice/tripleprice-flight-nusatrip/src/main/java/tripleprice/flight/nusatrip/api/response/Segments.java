package tripleprice.flight.nusatrip.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ari.prasetiyo
 */
@JsonInclude(NON_EMPTY)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Segments {

	@JsonProperty("departure_airport_code")
	String departureAirportCode;

	@JsonProperty("arrival_airport_code")
	String arrivalAirportCode;

	@JsonProperty("airline_code")
	String airlineCode;

	@JsonProperty("flight_number")
	String flightNumber;

	@JsonProperty("departure_time")
	long depatureTime;

	@JsonProperty("arrival_time")
	long arrivalTime;
	
	short duration;

	@JsonProperty("class_type")
	byte classType;

	short baggage;

	@JsonProperty("baggage_type")
	short baggageType;

	@JsonProperty("departure_terminal")
	String departureTerminal;
	
	@JsonProperty("arrival_terminal")
	String arrivalTerminal;
	
	@JsonProperty("aircraft_type")
	String aircraftType;
	
	@JsonProperty("no_of_stop")
	byte noOfStop;
	
	@JsonProperty("show_hidden_stop")
	boolean showHiddenStop;
	
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(final String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(final String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(final String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(final String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public long getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(final long depatureTime) {
		this.depatureTime = depatureTime;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(final long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(final short duration) {
		this.duration = duration;
	}

	public byte getClassType() {
		return classType;
	}

	public void setClassType(final byte classType) {
		this.classType = classType;
	}

	public short getBaggage() {
		return baggage;
	}

	public void setBaggage(final short baggage) {
		this.baggage = baggage;
	}

	public short getBaggageType() {
		return baggageType;
	}

	public void setBaggageType(final short baggageType) {
		this.baggageType = baggageType;
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

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(final String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public byte getNoOfStop() {
		return noOfStop;
	}

	public void setNoOfStop(final byte noOfStop) {
		this.noOfStop = noOfStop;
	}

	public boolean isShowHiddenStop() {
		return showHiddenStop;
	}

	public void setShowHiddenStop(final boolean showHiddenStop) {
		this.showHiddenStop = showHiddenStop;
	}

}

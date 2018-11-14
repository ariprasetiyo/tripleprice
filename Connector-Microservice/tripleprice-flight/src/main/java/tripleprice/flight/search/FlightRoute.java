package tripleprice.flight.search;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.general.AircraftType;
import tripleprice.flight.general.FlightFacility;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public class FlightRoute {
	private String airlineCode;
	private String airlineId;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String flightNumber;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String airlineName;

	private String arrivalCity;

	@NotNull
	@NotEmpty
	@NotBlank
	private String arrivalAirportCode;
	private String arrivalAirportTerminal;
	
	@Min(value=0)
	private long arrivalDate;

	private String departureCity;
	private String departureAirportTerminal;
	
	@NotNull
	@NotEmpty
	@NotBlank
	private String depatureAirportCode;
	
	@Min(value=0)
	private long depatureDate;
	
	@Min(value=0)
	private short duration;
	private short transitTime;
	private boolean hiddenStop;
	byte noOfStop;
	private FlightPrice Flightprice;
	private String airlineLogoUrl;
	private FlightFacility flightFacility;
	private FlightClassType flightClassType;
	private AircraftType aircraftType;

	public AircraftType getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(AircraftType aircraftType) {
		this.aircraftType = aircraftType;
	}

	public FlightClassType getFlightClassType() {
		return flightClassType;
	}

	public void setFlightClassType(final FlightClassType flightClassType) {
		this.flightClassType = flightClassType;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(final String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(final String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(final String airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(final String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(final String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(final String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	public String getArrivalAirportTerminal() {
		return arrivalAirportTerminal;
	}

	public void setArrivalAirportTerminal(String arrivalAirportTerminal) {
		this.arrivalAirportTerminal = arrivalAirportTerminal;
	}

	public String getDepartureAirportTerminal() {
		return departureAirportTerminal;
	}

	public void setDepartureAirportTerminal(String departureAirportTerminal) {
		this.departureAirportTerminal = departureAirportTerminal;
	}

	public String getDepatureAirportCode() {
		return depatureAirportCode;
	}

	public void setDepatureAirportCode(String depatureAirportCode) {
		this.depatureAirportCode = depatureAirportCode;
	}

	public long getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(final long depatureDate) {
		this.depatureDate = depatureDate;
	}

	public long getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(final long arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(final short duration) {
		this.duration = duration;
	}

	public short getTransitTime() {
		return transitTime;
	}

	public void setTransitTime(final short transitTime) {
		this.transitTime = transitTime;
	}

	public boolean isHiddenStop() {
		return hiddenStop;
	}

	public void setHiddenStop(final boolean hiddenStop) {
		this.hiddenStop = hiddenStop;
	}

	public byte getNoOfStop() {
		return noOfStop;
	}

	public void setNoOfStop(final byte noOfStop) {
		this.noOfStop = noOfStop;
	}

	public FlightPrice getFlightprice() {
		return Flightprice;
	}

	public void setFlightprice(final FlightPrice flightprice) {
		Flightprice = flightprice;
	}

	public String getAirlineLogoUrl() {
		return airlineLogoUrl;
	}

	public void setAirlineLogoUrl(final String airlineLogoUrl) {
		this.airlineLogoUrl = airlineLogoUrl;
	}

	public FlightFacility getFlightFacility() {
		return flightFacility;
	}

	public void setFlightFacility(final FlightFacility flightFacility) {
		this.flightFacility = flightFacility;
	}

}

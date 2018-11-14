package tripleprice.flight.search;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import tripleprice.flight.general.FlightFacility;

/**
 * 
 * @author ari-prasetiyo. common item
 */
public class FlightSegment {

	private MarketingAirline marketingAirline;
	
	@NotNull
	@NotBlank
	private String departureAirportCode;
	
	@NotNull
	@NotBlank
	private String arrivalAirportCode;

	@NotNull
	@NotBlank
	@Min(value = 100)	
	private long departureDate;
	
	@NotNull
	@NotBlank
	@Min(value = 100)
	private long arrivalDate;
	
	@NotNull
	@NotBlank
	@Min(value = 0)
	private short totalDuration;
	private int oneWayFare;
	private String roundtripFares;
	private String param;
	private short availableSeat;
	private short maximumSeat;
	private byte numberOfStops;
	private List<FlightRoute> flightRoutes;
	
	@NotNull
	@NotBlank
	private FlightPrice flightPrice;
	private FlightFacility flightFacility;
	private String[] note;
	
	private FlightVendorSecurityLevel flightVendorSecurityLevel;
    
    public FlightVendorSecurityLevel getFlightVendorSecurityLevel() {
		return flightVendorSecurityLevel;
	}

	public void setFlightVendorSecurityLevel(final FlightVendorSecurityLevel flightVendorSecurityLevel) {
		this.flightVendorSecurityLevel = flightVendorSecurityLevel;
	}

	public long getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(long departureDate) {
		this.departureDate = departureDate;
	}

	public MarketingAirline getMarketingAirline() {
		return marketingAirline;
	}

	public void setMarketingAirline(final MarketingAirline marketingAirline) {
		this.marketingAirline = marketingAirline;
	}

	public String[] getNote() {
		return note;
	}

	public void setNote(final String... note) {
		this.note = note;
	}

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

	public long getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(final long arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public short getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(final short totalDuration) {
		this.totalDuration = totalDuration;
	}

	public FlightPrice getFlightPrice() {
		return flightPrice;
	}

	public void setFlightPrice(final FlightPrice flightPrice) {
		this.flightPrice = flightPrice;
	}

	public int getOneWayFare() {
		return oneWayFare;
	}

	public void setOneWayFare(final int oneWayFare) {
		this.oneWayFare = oneWayFare;
	}

	public String getRoundtripFares() {
		return roundtripFares;
	}

	public void setRoundtripFares(final String roundtripFares) {
		this.roundtripFares = roundtripFares;
	}

	public String getParam() {
		return param;
	}

	public void setParam(final String param) {
		this.param = param;
	}

	public short getAvailableSeat() {
		return availableSeat;
	}

	public void setAvailableSeat(final short availableSeat) {
		this.availableSeat = availableSeat;
	}

	public short getMaximumSeat() {
		return maximumSeat;
	}

	public void setMaximumSeat(final short maximumSeat) {
		this.maximumSeat = maximumSeat;
	}

	public byte getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(final byte numberOfStops) {
		this.numberOfStops = numberOfStops;
	}
	
	public List<FlightRoute> getFlightRoutes() {
		return flightRoutes;
	}

	public void setFlightRoutes(List<FlightRoute> flightRoutes) {
		this.flightRoutes = flightRoutes;
	}

	public FlightFacility getFlightFacility() {
		return flightFacility;
	}

	public void setFlightFacility(final FlightFacility flightFacility) {
		this.flightFacility = flightFacility;
	}

}

package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Schedules {
	private String fareClass;
	private AirlineData airline;
	private String flightNumber;
	private Aircraft aircraft;
	private String cabinClass;
	private FlightDetail departureDetail;
	private FlightDetail arrivalDetail;
	private short totalTravelTimeInMinutes;
	private short totalTransitTimeInMinutes;
	private TiketComTime travelTime;
	private TiketComTime transitTime;
	private Baggage baggage;
	private String[] connectings;
	private Facilities facilities;
	private AirlineData operatingAirline;
	private String operatingFlightNumber;
	private boolean bundlingMeal;
	private boolean bundlingBaggage;

	public String getFareClass() {
		return fareClass;
	}

	public void setFareClass(final String fareClass) {
		this.fareClass = fareClass;
	}

	public AirlineData getAirline() {
		return airline;
	}

	public void setAirline(final AirlineData airline) {
		this.airline = airline;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(final String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(final Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public String getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(final String cabinClass) {
		this.cabinClass = cabinClass;
	}

	public FlightDetail getDepartureDetail() {
		return departureDetail;
	}

	public void setDepartureDetail(final FlightDetail departureDetail) {
		this.departureDetail = departureDetail;
	}

	public FlightDetail getArrivalDetail() {
		return arrivalDetail;
	}

	public void setArrivalDetail(final FlightDetail arrivalDetail) {
		this.arrivalDetail = arrivalDetail;
	}

	public short getTotalTravelTimeInMinutes() {
		return totalTravelTimeInMinutes;
	}

	public void setTotalTravelTimeInMinutes(short totalTravelTimeInMinutes) {
		this.totalTravelTimeInMinutes = totalTravelTimeInMinutes;
	}

	public short getTotalTransitTimeInMinutes() {
		return totalTransitTimeInMinutes;
	}

	public void setTotalTransitTimeInMinutes(short totalTransitTimeInMinutes) {
		this.totalTransitTimeInMinutes = totalTransitTimeInMinutes;
	}

	public TiketComTime getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(final TiketComTime travelTime) {
		this.travelTime = travelTime;
	}

	public TiketComTime getTransitTime() {
		return transitTime;
	}

	public void setTransitTime(final TiketComTime transitTime) {
		this.transitTime = transitTime;
	}

	public Baggage getBaggage() {
		return baggage;
	}

	public void setBaggage(Baggage baggage) {
		this.baggage = baggage;
	}

	public String[] getConnectings() {
		return connectings;
	}

	public void setConnectings(final String[] connectings) {
		this.connectings = connectings;
	}

	public Facilities getFacilities() {
		return facilities;
	}

	public void setFacilities(final Facilities facilities) {
		this.facilities = facilities;
	}

	public AirlineData getOperatingAirline() {
		return operatingAirline;
	}

	public void setOperatingAirline(final AirlineData operatingAirline) {
		this.operatingAirline = operatingAirline;
	}

	public String getOperatingFlightNumber() {
		return operatingFlightNumber;
	}

	public void setOperatingFlightNumber(final String operatingFlightNumber) {
		this.operatingFlightNumber = operatingFlightNumber;
	}

	public boolean isBundlingMeal() {
		return bundlingMeal;
	}

	public void setBundlingMeal(final boolean bundlingMeal) {
		this.bundlingMeal = bundlingMeal;
	}

	public boolean isBundlingBaggage() {
		return bundlingBaggage;
	}

	public void setBundlingBaggage(final boolean bundlingBaggage) {
		this.bundlingBaggage = bundlingBaggage;
	}

}

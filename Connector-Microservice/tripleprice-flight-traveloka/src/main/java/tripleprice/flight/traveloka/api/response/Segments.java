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
        getterVisibility = NONE,
        isGetterVisibility = NONE,
        setterVisibility = NONE)
public class Segments {
	private String departureAirport;
	private String arrivalAirport;
	private String flightNumber;
	private String airlineCode;
	private String brandCode;
	private String operatingAirlineCode;
	private String fareBasisCode;
	private SegmentInventories[] segmentInventories;
	private String aircraftType;
	private boolean hasMeal;
	private FreeBaggageInfo freeBaggageInfo;
	private Facilities facilities;
	private AircraftInformation aircraftInformation;
	private FlightLegInfoList[] flightLegInfoList;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short numTransit;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short durationMinute;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short routeNumDaysOffset;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short tzDepartureMinuteOffset;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short tzArrivalMinuteOffset;
	private TravelokaDate departureDate;
	private TravelokaDate arrivalDate;
	private TravelokaTime departureTime;
	private TravelokaTime arrivalTime;
	private boolean visaRequired;

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

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(final String brandCode) {
		this.brandCode = brandCode;
	}

	public String getOperatingAirlineCode() {
		return operatingAirlineCode;
	}

	public void setOperatingAirlineCode(final String operatingAirlineCode) {
		this.operatingAirlineCode = operatingAirlineCode;
	}

	public String getFareBasisCode() {
		return fareBasisCode;
	}

	public void setFareBasisCode(final String fareBasisCode) {
		this.fareBasisCode = fareBasisCode;
	}

	public SegmentInventories[] getSegmentInventories() {
		return segmentInventories;
	}

	public void setSegmentInventories(final SegmentInventories[] segmentInventories) {
		this.segmentInventories = segmentInventories;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(final String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public boolean isHasMeal() {
		return hasMeal;
	}

	public void setHasMeal(final boolean hasMeal) {
		this.hasMeal = hasMeal;
	}

	public FreeBaggageInfo getFreeBaggageInfo() {
		return freeBaggageInfo;
	}

	public void setFreeBaggageInfo(final FreeBaggageInfo freeBaggageInfo) {
		this.freeBaggageInfo = freeBaggageInfo;
	}

	public Facilities getFacilities() {
		return facilities;
	}

	public void setFacilities(final Facilities facilities) {
		this.facilities = facilities;
	}

	public AircraftInformation getAircraftInformation() {
		return aircraftInformation;
	}

	public void setAircraftInformation(final AircraftInformation aircraftInformation) {
		this.aircraftInformation = aircraftInformation;
	}

	public FlightLegInfoList[] getFlightLegInfoList() {
		return flightLegInfoList;
	}

	public void setFlightLegInfoList(final FlightLegInfoList[] flightLegInfoList) {
		this.flightLegInfoList = flightLegInfoList;
	}

	public short getNumTransit() {
		return numTransit;
	}

	public void setNumTransit(final short numTransit) {
		this.numTransit = numTransit;
	}

	public short getDurationMinute() {
		return durationMinute;
	}

	public void setDurationMinute(final short durationMinute) {
		this.durationMinute = durationMinute;
	}

	public short getRouteNumDaysOffset() {
		return routeNumDaysOffset;
	}

	public void setRouteNumDaysOffset(final short routeNumDaysOffset) {
		this.routeNumDaysOffset = routeNumDaysOffset;
	}

	public short getTzDepartureMinuteOffset() {
		return tzDepartureMinuteOffset;
	}

	public void setTzDepartureMinuteOffset(final short tzDepartureMinuteOffset) {
		this.tzDepartureMinuteOffset = tzDepartureMinuteOffset;
	}

	public short getTzArrivalMinuteOffset() {
		return tzArrivalMinuteOffset;
	}

	public void setTzArrivalMinuteOffset(final short tzArrivalMinuteOffset) {
		this.tzArrivalMinuteOffset = tzArrivalMinuteOffset;
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

	public boolean isVisaRequired() {
		return visaRequired;
	}

	public void setVisaRequired(boolean visaRequired) {
		this.visaRequired = visaRequired;
	}

}

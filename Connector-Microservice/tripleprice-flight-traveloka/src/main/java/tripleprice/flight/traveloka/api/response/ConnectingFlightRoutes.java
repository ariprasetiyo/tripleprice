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
public class ConnectingFlightRoutes {
	private String departureAirport;
	private String arrivalAirport;
	private String providerId;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private long dateTimeStamp;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short numDayOffset;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private byte totalNumStop;
	
	private FlightRefundInfo flightRefundInfo;
	
	private FlightRescheduleInfo flightRescheduleInfo;
	private RouteInventories[] routeInventories;
	private Segments[] segments;
	private String[] promoLabels;

	@JsonSerialize(using = ToStringSerializer.class)
	private short loyaltyPoint;

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

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(final String providerId) {
		this.providerId = providerId;
	}

	public long getDateTimeStamp() {
		return dateTimeStamp;
	}

	public void setDateTimeStamp(final long dateTimeStamp) {
		this.dateTimeStamp = dateTimeStamp;
	}

	public short getNumDayOffset() {
		return numDayOffset;
	}

	public void setNumDayOffset(final short numDayOffset) {
		this.numDayOffset = numDayOffset;
	}

	public byte getTotalNumStop() {
		return totalNumStop;
	}

	public void setTotalNumStop(final byte totalNumStop) {
		this.totalNumStop = totalNumStop;
	}

	public FlightRefundInfo getFlightRefundInfo() {
		return flightRefundInfo;
	}

	public void setFlightRefundInfo(final FlightRefundInfo flightRefundInfo) {
		this.flightRefundInfo = flightRefundInfo;
	}

	public FlightRescheduleInfo getFlightRescheduleInfo() {
		return flightRescheduleInfo;
	}

	public void setFlightRescheduleInfo(final FlightRescheduleInfo flightRescheduleInfo) {
		this.flightRescheduleInfo = flightRescheduleInfo;
	}

	public RouteInventories[] getRouteInventories() {
		return routeInventories;
	}

	public void setRouteInventories(final RouteInventories[] routeInventories) {
		this.routeInventories = routeInventories;
	}

	public Segments[] getSegments() {
		return segments;
	}

	public void setSegments(final  Segments[] segments) {
		this.segments = segments;
	}

	public String[] getPromoLabels() {
		return promoLabels;
	}

	public void setPromoLabels(final String[] promoLabels) {
		this.promoLabels = promoLabels;
	}

	public short getLoyaltyPoint() {
		return loyaltyPoint;
	}

	public void setLoyaltyPoint(final short loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}
}

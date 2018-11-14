package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class DepartureFlight {
	private String flightId;
	private String flightSelect;
	private String currency;
	private AirlineData marketingAirline;
	private FlightInfo depature;
	private FlightInfo arrival;
	private FareDetail fareDetail;
	private short totalTravelTimeInMinutes;
	private short totalTransitTimeInMinutes;
	private byte totalTransit;
	private short seatAvailability;
	private Schedules[] schedules;
	private String[] facilitiesPriority;
	private boolean crossFare;
	private boolean holdable;
	private boolean upgradable;
	private boolean refundable;
	private String journeySellKey;
	private String fareSellKey;
	private String marriageGroup;
	private boolean roundTrip;
	private String cabinClass;
	private boolean international;

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(final String flightId) {
		this.flightId = flightId;
	}

	public String getFlightSelect() {
		return flightSelect;
	}

	public void setFlightSelect(final String flightSelect) {
		this.flightSelect = flightSelect;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public AirlineData getMarketingAirline() {
		return marketingAirline;
	}

	public void setMarketingAirline(final AirlineData marketingAirline) {
		this.marketingAirline = marketingAirline;
	}

	public FlightInfo getDepature() {
		return depature;
	}

	public void setDepature(final FlightInfo depature) {
		this.depature = depature;
	}

	public FlightInfo getArrival() {
		return arrival;
	}

	public void setArrival(final FlightInfo arrival) {
		this.arrival = arrival;
	}

	public FareDetail getFareDetail() {
		return fareDetail;
	}

	public void setFareDetail(final FareDetail fareDetail) {
		this.fareDetail = fareDetail;
	}

	public short getTotalTravelTimeInMinutes() {
		return totalTravelTimeInMinutes;
	}

	public void setTotalTravelTimeInMinutes(final short totalTravelTimeInMinutes) {
		this.totalTravelTimeInMinutes = totalTravelTimeInMinutes;
	}

	public short getTotalTransitTimeInMinutes() {
		return totalTransitTimeInMinutes;
	}

	public void setTotalTransitTimeInMinutes(final short totalTransitTimeInMinutes) {
		this.totalTransitTimeInMinutes = totalTransitTimeInMinutes;
	}

	public byte getTotalTransit() {
		return totalTransit;
	}

	public void setTotalTransit(final byte totalTransit) {
		this.totalTransit = totalTransit;
	}

	public short getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(final short seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public Schedules[] getSchedules() {
		return schedules;
	}

	public void setSchedules(final Schedules[] schedules) {
		this.schedules = schedules;
	}

	public String[] getFacilitiesPriority() {
		return facilitiesPriority;
	}

	public void setFacilitiesPriority(final String[] facilitiesPriority) {
		this.facilitiesPriority = facilitiesPriority;
	}

	public boolean isCrossFare() {
		return crossFare;
	}

	public void setCrossFare(final boolean crossFare) {
		this.crossFare = crossFare;
	}

	public boolean isHoldable() {
		return holdable;
	}

	public void setHoldable(final boolean holdable) {
		this.holdable = holdable;
	}

	public boolean isUpgradable() {
		return upgradable;
	}

	public void setUpgradable(final boolean upgradable) {
		this.upgradable = upgradable;
	}

	public boolean isRefundable() {
		return refundable;
	}

	public void setRefundable(final boolean refundable) {
		this.refundable = refundable;
	}

	public String getJourneySellKey() {
		return journeySellKey;
	}

	public void setJourneySellKey(final String journeySellKey) {
		this.journeySellKey = journeySellKey;
	}

	public String getFareSellKey() {
		return fareSellKey;
	}

	public void setFareSellKey(final String fareSellKey) {
		this.fareSellKey = fareSellKey;
	}

	public String getMarriageGroup() {
		return marriageGroup;
	}

	public void setMarriageGroup(final String marriageGroup) {
		this.marriageGroup = marriageGroup;
	}

	public boolean isRoundTrip() {
		return roundTrip;
	}

	public void setRoundTrip(final boolean roundTrip) {
		this.roundTrip = roundTrip;
	}

	public String getCabinClass() {
		return cabinClass;
	}

	public void setCabinClass(final String cabinClass) {
		this.cabinClass = cabinClass;
	}

	public boolean isInternational() {
		return international;
	}

	public void setInternational(final boolean international) {
		this.international = international;
	}

}

package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import tripleprice.flight.search.FlightVendorSecurityLevel;

/**
 * @author ari.prasetiyo
 * 
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
		fieldVisibility = ANY,
		getterVisibility =NONE, 
		setterVisibility = NONE, 
		isGetterVisibility = NONE
		)
public class SearchResults {
	
	private ConnectingFlightRoutes[] connectingFlightRoutes;
	private FlightMetadata[] flightMetadata;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private byte totalNumStop;
	
	private boolean mobileAppDeal;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short tripDuration;
	
	private AdditionalInfo additionalInfo;
	private boolean flexibleTicket;
	
	private AirlineFareInfo airlineFareInfo;
	private AgentFareInfo agentFareInfo;
	private String flightId;
	private AirlineFare desktopPrice;
	private AirlineFare mAppsPrice;
	private String deltaPrice;
	private String bundleFareInfo;

	@JsonSerialize(using = ToStringSerializer.class)
    private int loyaltyPoint;

	public ConnectingFlightRoutes[] getConnectingFlightRoutes() {
		return connectingFlightRoutes;
	}

	public void setConnectingFlightRoutes(final ConnectingFlightRoutes[] connectingFlightRoutes) {
		this.connectingFlightRoutes = connectingFlightRoutes;
	}

	public FlightMetadata[] getFlightMetadata() {
		return flightMetadata;
	}

	public void setFlightMetadata(final FlightMetadata[] flightMetadata) {
		this.flightMetadata = flightMetadata;
	}

	public byte getTotalNumStop() {
		return totalNumStop;
	}

	public void setTotalNumStop(final byte totalNumStop) {
		this.totalNumStop = totalNumStop;
	}

	public boolean isMobileAppDeal() {
		return mobileAppDeal;
	}

	public void setMobileAppDeal(final boolean mobileAppDeal) {
		this.mobileAppDeal = mobileAppDeal;
	}

	public short getTripDuration() {
		return tripDuration;
	}

	public void setTripDuration(final short tripDuration) {
		this.tripDuration = tripDuration;
	}

	public AdditionalInfo getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(final AdditionalInfo additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public boolean isFlexibleTicket() {
		return flexibleTicket;
	}

	public void setFlexibleTicket(final boolean flexibleTicket) {
		this.flexibleTicket = flexibleTicket;
	}

	public AirlineFareInfo getAirlineFareInfo() {
		return airlineFareInfo;
	}

	public void setAirlineFareInfo(final AirlineFareInfo airlineFareInfo) {
		this.airlineFareInfo = airlineFareInfo;
	}

	public AgentFareInfo getAgentFareInfo() {
		return agentFareInfo;
	}

	public void setAgentFareInfo(final AgentFareInfo agentFareInfo) {
		this.agentFareInfo = agentFareInfo;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(final String flightId) {
		this.flightId = flightId;
	}

	public AirlineFare getDesktopPrice() {
		return desktopPrice;
	}

	public void setDesktopPrice(final AirlineFare desktopPrice) {
		this.desktopPrice = desktopPrice;
	}

	public AirlineFare getmAppsPrice() {
		return mAppsPrice;
	}

	public void setmAppsPrice(final AirlineFare mAppsPrice) {
		this.mAppsPrice = mAppsPrice;
	}

	public String getDeltaPrice() {
		return deltaPrice;
	}

	public void setDeltaPrice(final String deltaPrice) {
		this.deltaPrice = deltaPrice;
	}

	public String getBundleFareInfo() {
		return bundleFareInfo;
	}

	public void setBundleFareInfo(final String bundleFareInfo) {
		this.bundleFareInfo = bundleFareInfo;
	}

	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}

	public void setLoyaltyPoint(final int loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}
     
}

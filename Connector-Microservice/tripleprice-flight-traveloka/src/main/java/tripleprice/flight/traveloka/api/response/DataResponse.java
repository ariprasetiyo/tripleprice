package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

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
public class DataResponse {
	private boolean searchCompleted;
	private Integer seqNo;

	@JsonSerialize(using = ToStringSerializer.class)
	private long searchId;
	private String currency;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private byte currencyDecimalPlaces;
	private Map<String, AirlineData> airlineDataMap;
	private Map<String, AirportData> airportDataMap;
	private FlightSeoInfo flightSeoInfo;
	private String loyaltyPointEligibility;
	private String searchResponseMessage;
	private SearchResults[] searchResults;

	public boolean isSearchCompleted() {
		return searchCompleted;
	}

	public void setSearchCompleted(final boolean searchCompleted) {
		this.searchCompleted = searchCompleted;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(final Integer seqNo) {
		this.seqNo = seqNo;
	}

	public long getSearchId() {
		return searchId;
	}

	public void setSearchId(final long searchId) {
		this.searchId = searchId;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public byte getCurrencyDecimalPlaces() {
		return currencyDecimalPlaces;
	}

	public void setCurrencyDecimalPlaces(final byte currencyDecimalPlaces) {
		this.currencyDecimalPlaces = currencyDecimalPlaces;
	}

	public Map<String, AirlineData> getAirlineDataMap() {
		return airlineDataMap;
	}

	public void setAirlineDataMap(final Map<String, AirlineData> airlineDataMap) {
		this.airlineDataMap = airlineDataMap;
	}

	public Map<String, AirportData> getAirportDataMap() {
		return airportDataMap;
	}

	public void setAirportDataMap(final Map<String, AirportData> airportDataMap) {
		this.airportDataMap = airportDataMap;
	}

	public FlightSeoInfo getFlightSeoInfo() {
		return flightSeoInfo;
	}

	public void setFlightSeoInfo(final FlightSeoInfo flightSeoInfo) {
		this.flightSeoInfo = flightSeoInfo;
	}

	public String getLoyaltyPointEligibility() {
		return loyaltyPointEligibility;
	}

	public void setLoyaltyPointEligibility(final String loyaltyPointEligibility) {
		this.loyaltyPointEligibility = loyaltyPointEligibility;
	}

	public String getSearchResponseMessage() {
		return searchResponseMessage;
	}

	public void setSearchResponseMessage(final String searchResponseMessage) {
		this.searchResponseMessage = searchResponseMessage;
	}

	public SearchResults[] getSearchResults() {
		return searchResults;
	}

	public void setSearchResults(final SearchResults[] searchResults) {
		this.searchResults = searchResults;
	}
	
}

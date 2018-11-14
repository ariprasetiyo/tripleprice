package tripleprice.flight.traveloka.api.request;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import tripleprice.flight.enumuration.FlightClassType;

/**
 * @author ari.prasetiyo
 */
//@JsonInclude(NON_EMPTY)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class DataSearch {

	private String currency;

	@JsonProperty("destinationAirportOrArea")
	private String destionationAirportOrArea;

	private FlightDate flightDate;

	private String locale;

	@JsonProperty("newResult")
	private boolean isNewResult;

	@JsonProperty("numSeats")
	private NumberSeats numberSeats;

	@JsonProperty("seatPublishedClass")
	private FlightClassType flightClassType;
	private Integer seqNo;

	@JsonProperty("sortFilter")
	private SortFilter sortFilter;

	private String sourceAirportOrArea;

	private Integer searchId;

	private boolean usePromoFinder;

	private boolean useDateFlow;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDestionationAirportOrArea() {
		return destionationAirportOrArea;
	}

	public void setDestionationAirportOrArea(String destionationAirportOrArea) {
		this.destionationAirportOrArea = destionationAirportOrArea;
	}

	public FlightDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(FlightDate flightDate) {
		this.flightDate = flightDate;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public boolean isNewResult() {
		return isNewResult;
	}

	public void setNewResult(boolean isNewResult) {
		this.isNewResult = isNewResult;
	}

	public NumberSeats getNumberSeats() {
		return numberSeats;
	}

	public void setNumberSeats(NumberSeats numberSeats) {
		this.numberSeats = numberSeats;
	}

	public FlightClassType getFlightClassType() {
		return flightClassType;
	}

	public void setFlightClassType(FlightClassType flightClassType) {
		this.flightClassType = flightClassType;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	public SortFilter getSortFilter() {
		return sortFilter;
	}

	public void setSortFilter(SortFilter sortFilter) {
		this.sortFilter = sortFilter;
	}

	public String getSourceAirportOrArea() {
		return sourceAirportOrArea;
	}

	public void setSourceAirportOrArea(String sourceAirportOrArea) {
		this.sourceAirportOrArea = sourceAirportOrArea;
	}

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public boolean isUsePromoFinder() {
		return usePromoFinder;
	}

	public void setUsePromoFinder(boolean usePromoFinder) {
		this.usePromoFinder = usePromoFinder;
	}

	public boolean isUseDateFlow() {
		return useDateFlow;
	}

	public void setUseDateFlow(boolean useDateFlow) {
		this.useDateFlow = useDateFlow;
	}

}

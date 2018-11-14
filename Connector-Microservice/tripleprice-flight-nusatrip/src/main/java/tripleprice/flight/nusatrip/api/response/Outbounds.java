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
public class Outbounds {
	String id;

	@JsonProperty("airline_code")
	String airlineCode;

	String currency;

	@JsonProperty("lowest_total_fare")
	int lowestTotaFare;

	@JsonProperty("one_way_fare")
	int oneWayFare;

	@JsonProperty("roundtrip_fares")
	String roundtripFares;

	short duration;

	Segments[] segments;

	String param;

	@JsonProperty("default_luggage")
	short defaultLuggage;

	boolean promo;

	@JsonProperty("class_type")
	byte classType;

	@JsonProperty("tax_included")
	boolean taxIncluded;

	@JsonProperty("food_onboard")
	boolean foodOnboard;

	@JsonProperty("available_seat")

	short availableSeat;
	@JsonProperty("maximum_seat")
	short maximumSeat;

	short baggage;
	@JsonProperty("baggage_type")

	byte baggageType;

	byte numberOfStops;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(final String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public int getLowestTotaFare() {
		return lowestTotaFare;
	}

	public void setLowestTotaFare(int lowestTotaFare) {
		this.lowestTotaFare = lowestTotaFare;
	}

	public int getOneWayFare() {
		return oneWayFare;
	}

	public void setOneWayFare(int oneWayFare) {
		this.oneWayFare = oneWayFare;
	}

	public String getRoundtripFares() {
		return roundtripFares;
	}

	public void setRoundtripFares(final String roundtripFares) {
		this.roundtripFares = roundtripFares;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(final short duration) {
		this.duration = duration;
	}

	public Segments[] getSegments() {
		return segments;
	}

	public void setSegments(final Segments[] segments) {
		this.segments = segments;
	}

	public String getParam() {
		return param;
	}

	public void setParam(final String param) {
		this.param = param;
	}

	public short getDefaultLuggage() {
		return defaultLuggage;
	}

	public void setDefaultLuggage(final short defaultLuggage) {
		this.defaultLuggage = defaultLuggage;
	}

	public boolean isPromo() {
		return promo;
	}

	public void setPromo(final boolean promo) {
		this.promo = promo;
	}

	public byte getClassType() {
		return classType;
	}

	public void setClassType(final byte classType) {
		this.classType = classType;
	}

	public boolean isTaxIncluded() {
		return taxIncluded;
	}

	public void setTaxIncluded(final boolean taxIncluded) {
		this.taxIncluded = taxIncluded;
	}

	public boolean isFoodOnboard() {
		return foodOnboard;
	}

	public void setFoodOnboard(final boolean foodOnboard) {
		this.foodOnboard = foodOnboard;
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

	public short getBaggage() {
		return baggage;
	}

	public void setBaggage(final short baggage) {
		this.baggage = baggage;
	}

	public byte getBaggageType() {
		return baggageType;
	}

	public void setBaggageType(final byte baggageType) {
		this.baggageType = baggageType;
	}

	public byte getNumberOfStops() {
		return numberOfStops;
	}

	public void setNumberOfStops(final byte numberOfStops) {
		this.numberOfStops = numberOfStops;
	}

}

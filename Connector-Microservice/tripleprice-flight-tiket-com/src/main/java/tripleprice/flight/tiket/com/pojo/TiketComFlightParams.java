package tripleprice.flight.tiket.com.pojo;

import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.enumuration.TripType;
import tripleprice.flight.tiket.com.enumeration.ResultType;

/**
 * @author ari.prasetiyo
 */
/*
 * https://www.tiket.com/ms-gateway/tix-flight-search/search?origin=DPS&
 * destination=JKTC&departureDate=2018-12-11&adult=1&child=0&infant=0&cabinClass
 * =ECONOMY&originType=AIRPORT&destinationType=CITY&searchType=ONE_WAY&
 * resultType=ALL&async=true
 */
public class TiketComFlightParams {
	String origin;
	String destination;
	String depatureDate;
	byte adult;
	byte child;
	byte infant;

	// cabinClass
	FlightClassType flightClassType;
	String originType;
	String destionationType;
	TripType tripType;
	ResultType resultType;
	boolean isAsync;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(String depatureDate) {
		this.depatureDate = depatureDate;
	}

	public byte getAdult() {
		return adult;
	}

	public void setAdult(byte adult) {
		this.adult = adult;
	}

	public byte getChild() {
		return child;
	}

	public void setChild(byte child) {
		this.child = child;
	}

	public byte getInfant() {
		return infant;
	}

	public void setInfant(byte infant) {
		this.infant = infant;
	}

	public FlightClassType getFlightClassType() {
		return flightClassType;
	}

	public void setFlightClassType(FlightClassType flightClassType) {
		this.flightClassType = flightClassType;
	}

	public String getOriginType() {
		return originType;
	}

	public void setOriginType(String originType) {
		this.originType = originType;
	}

	public String getDestionationType() {
		return destionationType;
	}

	public void setDestionationType(String destionationType) {
		this.destionationType = destionationType;
	}

	public TripType getTripType() {
		return tripType;
	}

	public void setTripType(TripType tripType) {
		this.tripType = tripType;
	}

	public ResultType getResultType() {
		return resultType;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public boolean isAsync() {
		return isAsync;
	}

	public void setAsync(boolean isAsync) {
		this.isAsync = isAsync;
	}

}

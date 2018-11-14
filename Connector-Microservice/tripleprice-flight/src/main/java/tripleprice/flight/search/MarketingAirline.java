package tripleprice.flight.search;

import tripleprice.flight.enumuration.FlightClassType;

public class MarketingAirline {
	private short flightId;
	private String flightNumber;
	private String airlineId;
	private String airlineCode;
	private String airlineName;
	private FlightClassType flightClassType;
	
	public FlightClassType getFlightClassType() {
		return flightClassType;
	}

	public void setFlightClassType(final FlightClassType flightClassType) {
		this.flightClassType = flightClassType;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(final String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(final String airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(final String airlineName) {
		this.airlineName = airlineName;
	}

	public short getFlightId() {
		return flightId;
	}

	public void setFlightId(final short flightId) {
		this.flightId = flightId;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(final String airlineCode) {
		this.airlineCode = airlineCode;
	}

}

package tripleprice.flight.search;

import java.util.Date;

import tripleprice.flight.enumuration.FlightClassType;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public class FlightParams {
	private Date depatureDate;
	private Date returnDate;
	private byte childrenNum;
	private byte adultsNum;
	private byte infantsNum;
	private boolean isOneWay;
	private short depatureAirportId;
	private String departureAirportCode;
	private String arrivalAirportCode;
	private short arrivalAirportId;
	private FlightClassType flightClassType;
	private String currency;

	public final String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public final String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(final String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public final String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(final String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	public final Date getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(final Date depatureDate) {
		this.depatureDate = depatureDate;
	}

	public final Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(final Date returnDate) {
		this.returnDate = returnDate;
	}

	public final byte getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(final byte childrenNum) {
		this.childrenNum = childrenNum;
	}

	public final byte getAdultsNum() {
		return adultsNum;
	}

	public void setAdultsNum(final byte adultsNum) {
		this.adultsNum = adultsNum;
	}

	public final byte getInfantsNum() {
		return infantsNum;
	}

	public void setInfantsNum(final byte infantsNum) {
		this.infantsNum = infantsNum;
	}

	public final boolean isOneWay() {
		return isOneWay;
	}

	public void setOneWay(final boolean isOneWay) {
		this.isOneWay = isOneWay;
	}

	public final short getDepatureAirportId() {
		return depatureAirportId;
	}

	public void setDepatureAirportId(final short depatureAirportId) {
		this.depatureAirportId = depatureAirportId;
	}

	public final short getArrivalAirportId() {
		return arrivalAirportId;
	}

	public void setArrivalAirportId(final short arrivalAirportId) {
		this.arrivalAirportId = arrivalAirportId;
	}

	public final FlightClassType getFlightClassType() {
		return flightClassType;
	}

	public void setFlightClassType(final FlightClassType flightClassType) {
		this.flightClassType = flightClassType;
	}

	@Override
	public String toString() {
		return "FlightParams [depatureDate=" + depatureDate + ", returnDate=" + returnDate + ", childrenNum="
				+ childrenNum + ", adultsNum=" + adultsNum + ", infantsNum=" + infantsNum + ", isOneWay=" + isOneWay
				+ ", depatureAirportId=" + depatureAirportId + ", departureAirportCode=" + departureAirportCode
				+ ", arrivalAirportCode=" + arrivalAirportCode + ", arrivalAirportId=" + arrivalAirportId
				+ ", flightClassType=" + flightClassType + ", currency=" + currency + "]";
	}
}

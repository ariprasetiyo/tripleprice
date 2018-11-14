package tripleprice.flight.nusatrip;

import java.util.Date;

import tripleprice.flight.enumuration.FlightClassType;

/**
 * @author ari.prasetiyo
 */
public class NusatripFlightParams {
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

	public Date getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(Date depatureDate) {
		this.depatureDate = depatureDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public byte getChildrenNum() {
		return childrenNum;
	}

	public void setChildrenNum(byte childrenNum) {
		this.childrenNum = childrenNum;
	}

	public byte getAdultsNum() {
		return adultsNum;
	}

	public void setAdultsNum(byte adultsNum) {
		this.adultsNum = adultsNum;
	}

	public byte getInfantsNum() {
		return infantsNum;
	}

	public void setInfantsNum(byte infantsNum) {
		this.infantsNum = infantsNum;
	}

	public boolean isOneWay() {
		return isOneWay;
	}

	public void setOneWay(boolean isOneWay) {
		this.isOneWay = isOneWay;
	}

	public short getDepatureAirportId() {
		return depatureAirportId;
	}

	public void setDepatureAirportId(short depatureAirportId) {
		this.depatureAirportId = depatureAirportId;
	}

	public short getArrivalAirportId() {
		return arrivalAirportId;
	}

	public void setArrivalAirportId(short arrivalAirportId) {
		this.arrivalAirportId = arrivalAirportId;
	}

	public FlightClassType getFlightClassType() {
		return flightClassType;
	}

	public void setFlightClassType(FlightClassType flightClassType) {
		this.flightClassType = flightClassType;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getArrivalAirportCode() {
		return arrivalAirportCode;
	}

	public void setArrivalAirportCode(String arrivalAirportCode) {
		this.arrivalAirportCode = arrivalAirportCode;
	}

	@Override
	public String toString() {
		return "NusatripFlightParams [depatureDate=" + depatureDate + ", returnDate=" + returnDate + ", childrenNum="
				+ childrenNum + ", adultsNum=" + adultsNum + ", infantsNum=" + infantsNum + ", isOneWay=" + isOneWay
				+ ", depatureAirportId=" + depatureAirportId + ", departureAirportCode=" + departureAirportCode
				+ ", arrivalAirportCode=" + arrivalAirportCode + ", arrivalAirportId=" + arrivalAirportId
				+ ", flightClassType=" + flightClassType + "]";
	}

}

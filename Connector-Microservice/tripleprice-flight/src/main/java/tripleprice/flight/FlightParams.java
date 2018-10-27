package tripleprice.flight;

import java.util.Date;

import tripleprice.flight.enumuration.FlightClassType;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public abstract class FlightParams {
	protected Date depatureDate;
	protected Date returnDate;
	protected byte childrenNum;
	protected byte adultsNum;
	protected byte infantsNum;
	protected boolean isOneWay;
	protected short depatureAirportId;
	protected short arrivalAirportId;
	protected FlightClassType flightClassType;

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

	@Override
	public String toString() {
		return "FlightParams [depatureDate=" + depatureDate + ", returnDate=" + returnDate + ", childrenNum="
				+ childrenNum + ", adultsNum=" + adultsNum + ", infantsNum=" + infantsNum + ", isOneWay=" + isOneWay
				+ ", depatureAirportId=" + depatureAirportId + ", arrivalAirportId=" + arrivalAirportId
				+ ", flightClassType=" + flightClassType + "]";
	}

}

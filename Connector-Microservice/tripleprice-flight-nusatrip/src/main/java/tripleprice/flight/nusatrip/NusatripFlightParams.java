package tripleprice.flight.nusatrip;

import java.util.Date;

import tripleprice.flight.FlightParams;
import tripleprice.flight.enumuration.FlightClassType;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public class NusatripFlightParams extends FlightParams {
	private String depatureAirportCode;
	private String arrivalAirportCode;

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

	public String getDepatureAirportCode() {
		return depatureAirportCode;
	}

	public void setDepatureAirportCode(String depatureAirportCode) {
		this.depatureAirportCode = depatureAirportCode;
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
				+ ", depatureAirportId=" + depatureAirportId + ", arrivalAirportId=" + arrivalAirportId
				+ ", flightClassType=" + flightClassType + ", depatureAirportCode=" + depatureAirportCode
				+ ", arrivalAirportCode=" + arrivalAirportCode + "]";
	}

}

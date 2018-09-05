package tripleprice.flight.bean;

import java.util.Date;

public class FlightItem {
	String airlineCode;
	String airlineId;
	String airlineName;
	String departureCity;
	String arrivalCity;
	String depatureCode;
	String arrivalCode;
	Date depatureDate;
	Date arrivalDate;
	int duration;
	int transit;
	boolean hiddenStop;
	double price;
	String airlineLogoUrl;

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getDepatureCode() {
		return depatureCode;
	}

	public void setDepatureCode(String depatureCode) {
		this.depatureCode = depatureCode;
	}

	public String getArrivalCode() {
		return arrivalCode;
	}

	public void setArrivalCode(String arrivalCode) {
		this.arrivalCode = arrivalCode;
	}

	public Date getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(Date depatureDate) {
		this.depatureDate = depatureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getTransit() {
		return transit;
	}

	public void setTransit(int transit) {
		this.transit = transit;
	}

	public boolean isHiddenStop() {
		return hiddenStop;
	}

	public void setHiddenStop(boolean hiddenStop) {
		this.hiddenStop = hiddenStop;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAirlineLogoUrl() {
		return airlineLogoUrl;
	}

	public void setAirlineLogoUrl(String airlineLogoUrl) {
		this.airlineLogoUrl = airlineLogoUrl;
	}

	@Override
	public String toString() {
		return "FlightItem [airlineCode=" + airlineCode + ", airlineId=" + airlineId + ", airlineName=" + airlineName
				+ ", departureCity=" + departureCity + ", arrivalCity=" + arrivalCity + ", depatureCode=" + depatureCode
				+ ", arrivalCode=" + arrivalCode + ", depatureDate=" + depatureDate + ", arrivalDate=" + arrivalDate
				+ ", duration=" + duration + ", transit=" + transit + ", hiddenStop=" + hiddenStop + ", price=" + price
				+ ", airlineLogoUrl=" + airlineLogoUrl + "]";
	}
}

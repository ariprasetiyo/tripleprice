package tripleprice.flight.bean;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author ari-prasetiyo. common item
 */
public class Segment {
	int segmentId;
	Date depatureDate;
	Date arrivalDate;
	int totalDuration;
	double totalPrice;
	double discount;
	String promo;
	List<FlightItem> flightItems;
	List<Ssr> ssrs;

	public int getSegmentId() {
		return segmentId;
	}

	public void setSegmentId(int segmentId) {
		this.segmentId = segmentId;
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

	public int getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public List<FlightItem> getFlightItems() {
		return flightItems;
	}

	public void setFlightItems(List<FlightItem> flightItems) {
		this.flightItems = flightItems;
	}

	public List<Ssr> getSsrs() {
		return ssrs;
	}

	public void setSsrs(List<Ssr> ssrs) {
		this.ssrs = ssrs;
	}

	@Override
	public String toString() {
		return "Segment [segmentId=" + segmentId + ", depatureDate=" + depatureDate + ", arrivalDate=" + arrivalDate
				+ ", totalDuration=" + totalDuration + ", totalPrice=" + totalPrice + ", discount=" + discount
				+ ", promo=" + promo + ", flightItems=" + flightItems + ", ssrs=" + ssrs + "]";
	}

}

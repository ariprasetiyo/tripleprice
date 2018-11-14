package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Fare {
	private double total;
	private double totalWithoutAdjustment;
	private double totalWithMarkupWithoutDiscount;
	private double base;
	private double iwjr;
	private double tax;
	private double discount;
	private double loyaltyPoint;
	private double seatAvailables;
	
	public double getTotal() {
		return total;
	}
	public void setTotal(final double total) {
		this.total = total;
	}
	public double getTotalWithoutAdjustment() {
		return totalWithoutAdjustment;
	}
	public void setTotalWithoutAdjustment(final double totalWithoutAdjustment) {
		this.totalWithoutAdjustment = totalWithoutAdjustment;
	}
	public double getTotalWithMarkupWithoutDiscount() {
		return totalWithMarkupWithoutDiscount;
	}
	public void setTotalWithMarkupWithoutDiscount(final double totalWithMarkupWithoutDiscount) {
		this.totalWithMarkupWithoutDiscount = totalWithMarkupWithoutDiscount;
	}
	public double getBase() {
		return base;
	}
	public void setBase(final double base) {
		this.base = base;
	}
	public double getIwjr() {
		return iwjr;
	}
	public void setIwjr(final double iwjr) {
		this.iwjr = iwjr;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(final double tax) {
		this.tax = tax;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(final double discount) {
		this.discount = discount;
	}
	public double getLoyaltyPoint() {
		return loyaltyPoint;
	}
	public void setLoyaltyPoint(final double loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}
	public double getSeatAvailables() {
		return seatAvailables;
	}
	public void setSeatAvailables(final double seatAvailables) {
		this.seatAvailables = seatAvailables;
	}
	
	
}

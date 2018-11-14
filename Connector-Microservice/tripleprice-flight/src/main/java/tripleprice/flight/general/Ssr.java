package tripleprice.flight.general;

import tripleprice.flight.enumuration.SsrType;

/**
 * @author ari.prasetiyo
 */
public class Ssr {
	private String ssrName;
	private SsrType ssrType;
	private short luggageWeight;
	private double price;
	private double discount;

	public String getSsrName() {
		return ssrName;
	}

	public void setSsrName(String ssrName) {
		this.ssrName = ssrName;
	}

	public SsrType getSsrType() {
		return ssrType;
	}

	public void setSsrType(SsrType ssrType) {
		this.ssrType = ssrType;
	}

	public short getLuggageWeight() {
		return luggageWeight;
	}

	public void setLuggageWeight(short luggageWeight) {
		this.luggageWeight = luggageWeight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Ssr [ssrName=" + ssrName + ", ssrType=" + ssrType + ", luggageWeight=" + luggageWeight + ", price="
				+ price + ", discount=" + discount + "]";
	}

}

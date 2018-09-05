package tripleprice.flight.bean;

import tripleprice.flight.enumuration.SsrType;

public class Ssr {
	String ssrName;
	SsrType ssrType;
	int luggageWeight;
	double price;
	double discount;

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

	public int getLuggageWeight() {
		return luggageWeight;
	}

	public void setLuggageWeight(int luggageWeight) {
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

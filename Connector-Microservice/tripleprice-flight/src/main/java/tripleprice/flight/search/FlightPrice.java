package tripleprice.flight.search;

/**
 * @author ari.prasetiyo
 */
public class FlightPrice {
	
	private String currency;
	private double totalPrice;
	private double infantPrice;
	private double adultPrice;
	private double childPrice;
	private int lowestTotaFare;
	private boolean taxIncluded;
	private double taxFare;
	private double discount;

	private boolean promo;
	/**
	 * Treatment be like label discount 
	 */
	private String bannerPromo;
	private String urlPromo;
	private double oneWayFare;
	private double roundtripFares;
	
	public double getInfantPrice() {
		return infantPrice;
	}

	public void setInfantPrice(final double infantPrice) {
		this.infantPrice = infantPrice;
	}

	public double getAdultPrice() {
		return adultPrice;
	}

	public void setAdultPrice(final  double adultPrice) {
		this.adultPrice = adultPrice;
	}

	public double getChildPrice() {
		return childPrice;
	}

	public void setChildPrice(final  double childPrice) {
		this.childPrice = childPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public double getOneWayFare() {
		return oneWayFare;
	}

	public void setOneWayFare(final double oneWayFare) {
		this.oneWayFare = oneWayFare;
	}

	public double getRoundtripFares() {
		return roundtripFares;
	}

	public void setRoundtripFares(final double roundtripFares) {
		this.roundtripFares = roundtripFares;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(final double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getLowestTotaFare() {
		return lowestTotaFare;
	}

	public void setLowestTotaFare(final int lowestTotaFare) {
		this.lowestTotaFare = lowestTotaFare;
	}

	public boolean isTaxIncluded() {
		if (this.taxFare > 0.0) {
			return true;
		}
		return taxIncluded;
	}

	public void setTaxIncluded(final boolean taxIncluded) {
		this.taxIncluded = taxIncluded;
	}

	public double getTaxFare() {
		return taxFare;
	}

	public void setTaxFare(double taxFare) {
		this.taxFare = taxFare;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(final double discount) {
		this.discount = discount;
	}

	public boolean isPromo() {
		return promo;
	}

	public void setPromo(final boolean promo) {
		this.promo = promo;
	}

	public String getBannerPromo() {
		return bannerPromo;
	}

	public void setBannerPromo(final String bannerPromo) {
		this.bannerPromo = bannerPromo;
	}

	public String getUrlPromo() {
		return urlPromo;
	}

	public void setUrlPromo(final String urlPromo) {
		this.urlPromo = urlPromo;
	}

	@Override
	public String toString() {
		return "FlightPrice [currency=" + currency + ", totalPrice=" + totalPrice + ", infantPrice=" + infantPrice
				+ ", adultPrice=" + adultPrice + ", childPrice=" + childPrice + ", lowestTotaFare=" + lowestTotaFare
				+ ", taxIncluded=" + taxIncluded + ", taxFare=" + taxFare + ", discount=" + discount + ", promo="
				+ promo + ", bannerPromo=" + bannerPromo + ", urlPromo=" + urlPromo + ", oneWayFare=" + oneWayFare
				+ ", roundtripFares=" + roundtripFares + "]";
	}

}

package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Fares {
	private String supplierId;
	private String distributionType;
	private String currency;
	private double cheapestFare;
	private Fare totalFare;
	private Fare adultFare;
	private Fare childFare;
	private Fare infantFare;
	private String discountLabels;
	
	public Fare getAdultFare() {
		return adultFare;
	}

	public void setAdultFare(Fare adultFare) {
		this.adultFare = adultFare;
	}

	public Fare getChildFare() {
		return childFare;
	}

	public void setChildFare(Fare childFare) {
		this.childFare = childFare;
	}

	public Fare getInfantFare() {
		return infantFare;
	}

	public void setInfantFare(Fare infantFare) {
		this.infantFare = infantFare;
	}

	public String getDiscountLabels() {
		return discountLabels;
	}

	public void setDiscountLabels(String discountLabels) {
		this.discountLabels = discountLabels;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(final String supplierId) {
		this.supplierId = supplierId;
	}

	public String getDistributionType() {
		return distributionType;
	}

	public void setDistributionType(final String distributionType) {
		this.distributionType = distributionType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(final String currency) {
		this.currency = currency;
	}

	public double getCheapestFare() {
		return cheapestFare;
	}

	public void setCheapestFare(final double cheapestFare) {
		this.cheapestFare = cheapestFare;
	}

	public Fare getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(final Fare totalFare) {
		this.totalFare = totalFare;
	}

}

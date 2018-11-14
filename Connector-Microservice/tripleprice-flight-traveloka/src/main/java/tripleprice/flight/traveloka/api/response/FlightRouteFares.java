package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
// @JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE, isGetterVisibility = NONE)
public class FlightRouteFares {
	
	private AirlineFare adultAirlineFare;
	private AirlineFare compulsoryInsuranceTotal;
	private AirlineFare pscTotal;
	private AirlineFare infantBaseFare;
	private AirlineFare fuelSurchargeTotal;
	private AirlineFare adultBaseFare;
	private AirlineFare totalAirlineFare;
	private AirlineFare childBaseFare;
	private AirlineFare baseFareTotal;
	private AirlineFare vatTotal;
	private AirlineFare adminFeeTotal;
	private AirlineFare totalAdditionalFare;
	private AirlineFare adultAgentFare;
	private AirlineFare childAgentFare;
	private AirlineFare infantAgentFare;
	private AirlineFare totalFare;
	
	public AirlineFare getAdultAgentFare() {
		return adultAgentFare;
	}

	public void setAdultAgentFare(final AirlineFare adultAgentFare) {
		this.adultAgentFare = adultAgentFare;
	}

	public AirlineFare getChildAgentFare() {
		return childAgentFare;
	}

	public void setChildAgentFare(final AirlineFare childAgentFare) {
		this.childAgentFare = childAgentFare;
	}

	public AirlineFare getInfantAgentFare() {
		return infantAgentFare;
	}

	public void setInfantAgentFare(final AirlineFare infantAgentFare) {
		this.infantAgentFare = infantAgentFare;
	}

	public AirlineFare getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(final AirlineFare totalFare) {
		this.totalFare = totalFare;
	}

	public AirlineFare getAdultAirlineFare() {
		return adultAirlineFare;
	}

	public void setAdultAirlineFare(final AirlineFare adultAirlineFare) {
		this.adultAirlineFare = adultAirlineFare;
	}

	public AirlineFare getAdultBaseFare() {
		return adultBaseFare;
	}

	public void setAdultBaseFare(final AirlineFare adultBaseFare) {
		this.adultBaseFare = adultBaseFare;
	}

	public AirlineFare getChildBaseFare() {
		return childBaseFare;
	}

	public void setChildBaseFare(final AirlineFare childBaseFare) {
		this.childBaseFare = childBaseFare;
	}

	public AirlineFare getInfantBaseFare() {
		return infantBaseFare;
	}

	public void setInfantBaseFare(final AirlineFare infantBaseFare) {
		this.infantBaseFare = infantBaseFare;
	}

	public AirlineFare getBaseFareTotal() {
		return baseFareTotal;
	}

	public void setBaseFareTotal(final AirlineFare baseFareTotal) {
		this.baseFareTotal = baseFareTotal;
	}

	public AirlineFare getVatTotal() {
		return vatTotal;
	}

	public void setVatTotal(final AirlineFare vatTotal) {
		this.vatTotal = vatTotal;
	}

	public AirlineFare getCompulsoryInsuranceTotal() {
		return compulsoryInsuranceTotal;
	}

	public void setCompulsoryInsuranceTotal(final AirlineFare compulsoryInsuranceTotal) {
		this.compulsoryInsuranceTotal = compulsoryInsuranceTotal;
	}

	public AirlineFare getPscTotal() {
		return pscTotal;
	}

	public void setPscTotal(final AirlineFare pscTotal) {
		this.pscTotal = pscTotal;
	}

	public AirlineFare getFuelSurchargeTotal() {
		return fuelSurchargeTotal;
	}

	public void setFuelSurchargeTotal(final AirlineFare fuelSurchargeTotal) {
		this.fuelSurchargeTotal = fuelSurchargeTotal;
	}

	public AirlineFare getAdminFeeTotal() {
		return adminFeeTotal;
	}

	public void setAdminFeeTotal(final AirlineFare adminFeeTotal) {
		this.adminFeeTotal = adminFeeTotal;
	}

	public AirlineFare getTotalAirlineFare() {
		return totalAirlineFare;
	}

	public void setTotalAirlineFare(final AirlineFare totalAirlineFare) {
		this.totalAirlineFare = totalAirlineFare;
	}

	public AirlineFare getTotalAdditionalFare() {
		return totalAdditionalFare;
	}

	public void setTotalAdditionalFare(final AirlineFare totalAdditionalFare) {
		this.totalAdditionalFare = totalAdditionalFare;
	}

}

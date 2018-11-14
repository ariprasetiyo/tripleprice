package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class FareDetail {
	private String fareBasisCode;
	private String fareClass;
	private double cheapestFare;
	private Fares[] fares;

	public String getFareBasisCode() {
		return fareBasisCode;
	}

	public void setFareBasisCode(final String fareBasisCode) {
		this.fareBasisCode = fareBasisCode;
	}

	public String getFareClass() {
		return fareClass;
	}

	public void setFareClass(final String fareClass) {
		this.fareClass = fareClass;
	}

	public double getCheapestFare() {
		return cheapestFare;
	}

	public void setCheapestFare(final double cheapestFare) {
		this.cheapestFare = cheapestFare;
	}

	public Fares[] getFares() {
		return fares;
	}

	public void setFares(final Fares[] fares) {
		this.fares = fares;
	}

}

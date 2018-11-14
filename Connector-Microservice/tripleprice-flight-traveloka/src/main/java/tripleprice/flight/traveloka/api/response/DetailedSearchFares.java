package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
		fieldVisibility = ANY,
		getterVisibility =NONE, 
		setterVisibility = NONE, 
		isGetterVisibility = NONE
		)
public class DetailedSearchFares {
	private AncillaryFare ancillaryFare;
	private FlightRouteFares flightRouteFares;

	public AncillaryFare getAncillaryFare() {
		return ancillaryFare;
	}

	public void setAncillaryFare(final AncillaryFare ancillaryFare) {
		this.ancillaryFare = ancillaryFare;
	}

	public FlightRouteFares getFlightRouteFares() {
		return flightRouteFares;
	}

	public void setFlightRouteFares(final FlightRouteFares flightRouteFares) {
		this.flightRouteFares = flightRouteFares;
	}
	
}

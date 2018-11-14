package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class SearchList {
	private DepartureFlight[] departureFlights;

	public DepartureFlight[] getDepartureFlights() {
		return departureFlights;
	}

	public void setDepartureFlights(final DepartureFlight[] departureFlights) {
		this.departureFlights = departureFlights;
	}
}

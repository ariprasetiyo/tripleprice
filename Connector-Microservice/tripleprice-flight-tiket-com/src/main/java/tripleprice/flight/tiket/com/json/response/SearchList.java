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

	/**
	 * TODO not yet support at tiket.com
	 */
	private Object[] returnFlights;
	private Object[] srtReturnFlights;
	private Object[] roundTrips;
	private Object[] rtsRoundTrips;

	public DepartureFlight[] getDepartureFlights() {
		return departureFlights;
	}

	public void setDepartureFlights(final DepartureFlight[] departureFlights) {
		this.departureFlights = departureFlights;
	}

	public Object getReturnFlights() {
		return returnFlights;
	}

	public void setReturnFlights(final Object[] returnFlights) {
		this.returnFlights = returnFlights;
	}

	public Object getSrtReturnFlights() {
		return srtReturnFlights;
	}

	public void setSrtReturnFlights(final Object[] srtReturnFlights) {
		this.srtReturnFlights = srtReturnFlights;
	}

	public Object getRoundTrips() {
		return roundTrips;
	}

	public void setRoundTrips(final Object[] roundTrips) {
		this.roundTrips = roundTrips;
	}

	public Object getRtsRoundTrips() {
		return rtsRoundTrips;
	}

	public void setRtsRoundTrips(final Object[] rtsRoundTrips) {
		this.rtsRoundTrips = rtsRoundTrips;
	}
}

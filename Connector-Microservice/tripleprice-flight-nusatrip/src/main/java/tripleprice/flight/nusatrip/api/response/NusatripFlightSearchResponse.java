package tripleprice.flight.nusatrip.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ari.prasetiyo
 *
 */
@JsonInclude(NON_EMPTY)
@JsonAutoDetect(
        fieldVisibility = ANY,
        getterVisibility = NONE,
        isGetterVisibility = NONE,
        setterVisibility = NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class NusatripFlightSearchResponse {

	private Outbounds[] outbounds;

	private Map<String, String> rates;

	private Map<String, Integer> markup;
	
	@JsonProperty("lowest_fare")
	private LowestFare lowestFare;
	
	private Map<String, String> airlines;

	@JsonProperty("airlines_operating")
	private Map<String, String> airlinesOperating;

	private Map<String, String> airports;

	private List<Area> cities;

	public Map<String, String> getAirlines() {
		return airlines;
	}

	public void setAirlines(final Map<String, String> airlines) {
		this.airlines = airlines;
	}

	public Map<String, String> getAirlinesOperating() {
		return airlinesOperating;
	}

	public void setAirlinesOperating(final Map<String, String> airlinesOperating) {
		this.airlinesOperating = airlinesOperating;
	}

	public Map<String, String> getAirports() {
		return airports;
	}

	public void setAirports(final Map<String, String> airports) {
		this.airports = airports;
	}

	public List<Area> getCities() {
		return cities;
	}

	public void setCities(final List<Area> cities) {
		this.cities = cities;
	}

	public Outbounds[] getOutbounds() {
		return outbounds;
	}

	public void setOutbounds(final Outbounds[] outbounds) {
		this.outbounds = outbounds;
	}

	public Map<String, String> getRates() {
		return rates;
	}

	public void setRates(final Map<String, String> rates) {
		this.rates = rates;
	}

	public Map<String, Integer> getMarkup() {
		return markup;
	}

	public void setMarkup(final Map<String, Integer> markup) {
		this.markup = markup;
	}

	public LowestFare getLowestFare() {
		return lowestFare;
	}

	public void setLowestFare(final LowestFare lowestFare) {
		this.lowestFare = lowestFare;
	}
}

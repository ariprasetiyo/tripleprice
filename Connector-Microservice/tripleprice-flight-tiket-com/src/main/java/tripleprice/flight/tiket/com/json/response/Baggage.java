package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Baggage {
	private Luggage cabin;
	private Luggage checkIn;
	private boolean additionalBaggage;
	private String urlIcon;

	public Luggage getCabin() {
		return cabin;
	}

	public void setCabin(final Luggage cabin) {
		this.cabin = cabin;
	}

	public Luggage getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(final Luggage checkIn) {
		this.checkIn = checkIn;
	}

	public boolean isAdditionalBaggage() {
		return additionalBaggage;
	}

	public void setAdditionalBaggage(final boolean additionalBaggage) {
		this.additionalBaggage = additionalBaggage;
	}

	public String getUrlIcon() {
		return urlIcon;
	}

	public void setUrlIcon(final String urlIcon) {
		this.urlIcon = urlIcon;
	}

}

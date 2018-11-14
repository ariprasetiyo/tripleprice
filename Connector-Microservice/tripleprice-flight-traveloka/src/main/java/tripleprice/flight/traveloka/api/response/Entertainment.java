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
        getterVisibility = NONE,
        isGetterVisibility = NONE,
        setterVisibility = NONE)
public class Entertainment {
	private boolean available;

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(final boolean available) {
		this.available = available;
	}
}

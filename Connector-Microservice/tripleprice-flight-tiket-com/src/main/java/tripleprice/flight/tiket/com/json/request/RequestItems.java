package tripleprice.flight.tiket.com.json.request;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class RequestItems {
	String requestItems;

	public String getRequestItems() {
		return requestItems;
	}

	public void setRequestItems(String requestItems) {
		this.requestItems = requestItems;
	}

}

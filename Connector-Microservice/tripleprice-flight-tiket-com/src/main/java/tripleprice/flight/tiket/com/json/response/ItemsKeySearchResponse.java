package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class ItemsKeySearchResponse {
	private String code;
	private String message;
	private String errors;
	private ItemsKeySearchDataResponse data;
	private long serverTime;

	public String getCode() {
		return code;
	}

	public void setCode(final String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(final String errors) {
		this.errors = errors;
	}

	public ItemsKeySearchDataResponse getData() {
		return data;
	}

	public void setData(final ItemsKeySearchDataResponse data) {
		this.data = data;
	}

	public long getServerTime() {
		return serverTime;
	}

	public void setServerTime(final long serverTime) {
		this.serverTime = serverTime;
	}

}

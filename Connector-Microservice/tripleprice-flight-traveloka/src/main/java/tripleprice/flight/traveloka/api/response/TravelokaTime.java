package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author ari.prasetiyo
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = ANY,
        getterVisibility = NONE,
        isGetterVisibility = NONE,
        setterVisibility = NONE)
public class TravelokaTime {
	@JsonSerialize(using = ToStringSerializer.class)
	byte hour;

	@JsonSerialize(using = ToStringSerializer.class)
	byte minute;

	public byte getHour() {
		return hour;
	}

	public void setHour(final byte hour) {
		this.hour = hour;
	}

	public byte getMinute() {
		return minute;
	}

	public void setMinute(final byte minute) {
		this.minute = minute;
	}
}

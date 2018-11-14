package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class TiketComTime {
	private byte day;
	private byte hour;
	private byte minute;
	public byte getDay() {
		return day;
	}
	public void setDay(final byte day) {
		this.day = day;
	}
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

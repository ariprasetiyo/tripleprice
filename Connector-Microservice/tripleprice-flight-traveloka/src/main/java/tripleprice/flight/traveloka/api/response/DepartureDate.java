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
public class DepartureDate {
	
	@JsonSerialize(using = ToStringSerializer.class)
	private byte month;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private byte day;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private short year;

	public byte getMonth() {
		return month;
	}

	public void setMonth(final byte month) {
		this.month = month;
	}

	public byte getDay() {
		return day;
	}

	public void setDay(final byte day) {
		this.day = day;
	}

	public short getYear() {
		return year;
	}

	public void setYear(final short year) {
		this.year = year;
	}
}

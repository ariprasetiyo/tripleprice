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
public class SeatInformation {
	private String layout;
	
	@JsonSerialize(using = ToStringSerializer.class)
    private int pitch;
	
	private String type;

	public String getLayout() {
		return layout;
	}

	public void setLayout(final String layout) {
		this.layout = layout;
	}

	public int getPitch() {
		return pitch;
	}

	public void setPitch(final int pitch) {
		this.pitch = pitch;
	}

	public String getType() {
		return type;
	}

	public void setType(final String type) {
		this.type = type;
	}

}

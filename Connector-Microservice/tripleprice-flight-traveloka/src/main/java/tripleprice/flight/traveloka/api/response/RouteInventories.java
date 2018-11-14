package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
		fieldVisibility = ANY,
		getterVisibility =NONE, 
		setterVisibility = NONE, 
		isGetterVisibility = NONE
		)

public class RouteInventories {
	String seatPublishedClass;
    String seatClass;
    
	@JsonSerialize(using = ToStringSerializer.class)
    byte numSeatLeft;

	public String getSeatPublishedClass() {
		return seatPublishedClass;
	}

	public void setSeatPublishedClass(final String seatPublishedClass) {
		this.seatPublishedClass = seatPublishedClass;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(final String seatClass) {
		this.seatClass = seatClass;
	}

	public byte getNumSeatLeft() {
		return numSeatLeft;
	}

	public void setNumSeatLeft(final byte numSeatLeft) {
		this.numSeatLeft = numSeatLeft;
	}
}

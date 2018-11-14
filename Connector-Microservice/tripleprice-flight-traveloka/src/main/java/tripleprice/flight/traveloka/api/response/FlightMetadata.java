package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author ari.prasetiyo
 * 
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
		fieldVisibility = ANY,
		getterVisibility =NONE, 
		setterVisibility = NONE, 
		isGetterVisibility = NONE
		)
public class FlightMetadata {
	private String currency;
	private String airlineId;
	private String sourceAirport;
	private String destinationAirport;

	@JsonSerialize(using = ToStringSerializer.class)
	private byte numAdult;
	@JsonSerialize(using = ToStringSerializer.class)
	private byte numChild;
	@JsonSerialize(using = ToStringSerializer.class)
	private byte numInfant;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(final String currency) {
		this.currency = currency;
	}
	public String getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(final String airlineId) {
		this.airlineId = airlineId;
	}
	public String getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(final String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public String getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(final String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public byte getNumAdult() {
		return numAdult;
	}
	public void setNumAdult(final byte numAdult) {
		this.numAdult = numAdult;
	}
	public byte getNumChild() {
		return numChild;
	}
	public void setNumChild(final byte numChild) {
		this.numChild = numChild;
	}
	public byte getNumInfant() {
		return numInfant;
	}
	public void setNumInfant(final byte numInfant) {
		this.numInfant = numInfant;
	}
	
}

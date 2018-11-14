package tripleprice.flight.search;

import java.util.List;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public class FlightItems {

	private long flightSearchItemId;
	private short flightSearchVendorId;
	private List<FlightSegment> outboundFlights;
	private List<FlightSegment> inboundFlights;
	
	/**
	 * Security level
	 */
	private FlightVendorSecurityLevel flightVendorSecurityLevel;

	public FlightVendorSecurityLevel getFlightId() {
		return flightVendorSecurityLevel;
	}

	public void setFlightId(FlightVendorSecurityLevel flightVendorSecurityLevel) {
		this.flightVendorSecurityLevel = flightVendorSecurityLevel;
	}

	public long getFlightSearchItemId() {
		return flightSearchItemId;
	}

	public void setFlightSearchItemId(long flightSearchItemId) {
		this.flightSearchItemId = flightSearchItemId;
	}

	public short getFlightSearchVendorId() {
		return flightSearchVendorId;
	}

	public void setFlightSearchVendorId(short flightSearchVendorId) {
		this.flightSearchVendorId = flightSearchVendorId;
	}

	public List<FlightSegment> getOutboundFlights() {
		return outboundFlights;
	}

	public void setOutboundFlights(List<FlightSegment> outboundFlights) {
		this.outboundFlights = outboundFlights;
	}

	public List<FlightSegment> getInboundFlights() {
		return inboundFlights;
	}

	public void setInboundFlights(List<FlightSegment> inboundFlights) {
		this.inboundFlights = inboundFlights;
	}

	@Override
	public String toString() {
		return "FlightItems [flightSearchItemId=" + flightSearchItemId + ", flightSearchVendorId="
				+ flightSearchVendorId + ", outboundFlights=" + outboundFlights + ", inboundFlights=" + inboundFlights
				+ "]";
	}

}

package tripleprice.flight;

import java.util.List;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public class FlightItems {

	private long flightSearchItemId;
	private short flightSearchVendorId;
	private List<Segment> outboundSegments;
	private List<Segment> inboundSegments;

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

	public List<Segment> getOutboundSegments() {
		return outboundSegments;
	}

	public void setOutboundSegments(List<Segment> outboundSegments) {
		this.outboundSegments = outboundSegments;
	}

	public List<Segment> getInboundSegments() {
		return inboundSegments;
	}

	public void setInboundSegments(List<Segment> inboundSegments) {
		this.inboundSegments = inboundSegments;
	}

	@Override
	public String toString() {
		return "FlightItemList [flightSearchItemId=" + flightSearchItemId + ", flightSearchVendorId="
				+ flightSearchVendorId + ", outboundSegments=" + outboundSegments + ", inboundSegments="
				+ inboundSegments + "]";
	}

}

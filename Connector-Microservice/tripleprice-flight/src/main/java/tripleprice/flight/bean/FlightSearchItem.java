package tripleprice.flight.bean;

import java.util.List;

public class FlightSearchItem {
	String flightSearchItemId;
	String flightSearchVendorId;
	List<Segment> outboundSegments;
	List<Segment> inboundSegments;

	public String getFlightSearchItemId() {
		return flightSearchItemId;
	}

	public void setFlightSearchItemId(String flightSearchItemId) {
		this.flightSearchItemId = flightSearchItemId;
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

	public String getFlightSearchVendorId() {
		return flightSearchVendorId;
	}

	public void setFlightSearchVendorId(String flightSearchVendorId) {
		this.flightSearchVendorId = flightSearchVendorId;
	}

	@Override
	public String toString() {
		return "FlightSearchItem [flightSearchItemId=" + flightSearchItemId + ", flightSearchVendorId="
				+ flightSearchVendorId + ", outboundSegments=" + outboundSegments + ", inboundSegments="
				+ inboundSegments + "]";
	}

}

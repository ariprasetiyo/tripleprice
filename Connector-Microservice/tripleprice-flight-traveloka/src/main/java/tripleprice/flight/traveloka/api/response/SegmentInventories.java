package tripleprice.flight.traveloka.api.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(
        fieldVisibility = ANY,
        getterVisibility = NONE,
        isGetterVisibility = NONE,
        setterVisibility = NONE)
public class SegmentInventories {
	
    private String seatClass;
	private String numSeatsLeft;
	private String publishedClass;
	private String fareBasis;
	private String refundable;
	private SubclassInfo subclassInfo;
	
	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(final String seatClass) {
		this.seatClass = seatClass;
	}

	public String getNumSeatsLeft() {
		return numSeatsLeft;
	}

	public void setNumSeatsLeft(final String numSeatsLeft) {
		this.numSeatsLeft = numSeatsLeft;
	}

	public String getPublishedClass() {
		return publishedClass;
	}

	public void setPublishedClass(final String publishedClass) {
		this.publishedClass = publishedClass;
	}

	public String getFareBasis() {
		return fareBasis;
	}

	public void setFareBasis(final String fareBasis) {
		this.fareBasis = fareBasis;
	}

	public String getRefundable() {
		return refundable;
	}

	public void setRefundable(final String refundable) {
		this.refundable = refundable;
	}

	public SubclassInfo getSubclassInfo() {
		return subclassInfo;
	}

	public void setSubclassInfo(final SubclassInfo subclassInfo) {
		this.subclassInfo = subclassInfo;
	}
	
}

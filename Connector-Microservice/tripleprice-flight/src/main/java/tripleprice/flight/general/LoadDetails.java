package tripleprice.flight.general;

import tripleprice.service.PieceType;

/**
 * @author ari.prasetiyo
 */
public class LoadDetails {
	private String unitOfMeasure;
	private short weight;
	private boolean availableToBuy;
	private BaggageType baggageType;
	private short defaultLuggage;
	private PieceType meansurement;

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(final String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public short getWeight() {
		return weight;
	}

	public void setWeight(final short weight) {
		this.weight = weight;
	}

	public boolean isAvailableToBuy() {
		return availableToBuy;
	}

	public void setAvailableToBuy(final boolean availableToBuy) {
		this.availableToBuy = availableToBuy;
	}

	public BaggageType getBaggageType() {
		return baggageType;
	}

	public void setBaggageType(final BaggageType baggageType) {
		this.baggageType = baggageType;
	}

	public short getDefaultLuggage() {
		return defaultLuggage;
	}

	public void setDefaultLuggage(final short defaultLuggage) {
		this.defaultLuggage = defaultLuggage;
	}

	public PieceType getMeansurement() {
		return meansurement;
	}

	public void setMeansurement(final PieceType meansurement) {
		this.meansurement = meansurement;
	}

}

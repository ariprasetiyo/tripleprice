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
public class AircraftInformation {
	private Aircraft aircraft;
	private CabinBaggage cabinBaggage;

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(final Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public CabinBaggage getCabinBaggage() {
		return cabinBaggage;
	}

	public void setCabinBaggage(final CabinBaggage cabinBaggage) {
		this.cabinBaggage = cabinBaggage;
	}
	
}

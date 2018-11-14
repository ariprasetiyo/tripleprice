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
public class Wifi {
	private String cost;
	private String chance;

	public String getCost() {
		return cost;
	}

	public void setCost(final String cost) {
		this.cost = cost;
	}

	public String getChance() {
		return chance;
	}

	public void setChance(final String chance) {
		this.chance = chance;
	}
}

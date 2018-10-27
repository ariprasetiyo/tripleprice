package tripleprice.flight.traveloka.json.request;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
// @JsonInclude(NON_EMPTY)
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE, isGetterVisibility = NONE)
public class SortFilter {
	private int[] filterAirlines;
	private int[] filterArrive;
	private int[] filterDepart;
	private int[] filterTransit;
	private String selectedDeparture;
	private Integer sort;

	public int[] getFilterAirlines() {
		return filterAirlines;
	}

	public void setFilterAirlines(int[] filterAirlines) {
		this.filterAirlines = filterAirlines;
	}

	public int[] getFilterArrive() {
		return filterArrive;
	}

	public void setFilterArrive(int[] filterArrive) {
		this.filterArrive = filterArrive;
	}

	public int[] getFilterDepart() {
		return filterDepart;
	}

	public void setFilterDepart(int[] filterDepart) {
		this.filterDepart = filterDepart;
	}

	public int[] getFilterTransit() {
		return filterTransit;
	}

	public void setFilterTransit(int[] filterTransit) {
		this.filterTransit = filterTransit;
	}

	public String getSelectedDeparture() {
		return selectedDeparture;
	}

	public void setSelectedDeparture(String selectedDeparture) {
		this.selectedDeparture = selectedDeparture;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}

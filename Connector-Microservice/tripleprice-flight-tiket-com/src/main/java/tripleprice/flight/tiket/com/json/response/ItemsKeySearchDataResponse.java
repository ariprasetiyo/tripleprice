package tripleprice.flight.tiket.com.json.response;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author ari.prasetiyo
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class ItemsKeySearchDataResponse {
	boolean searchCompleted;
	String[] requestItems;
	String searchList;
	List<SpecialFareAirlines> specialFareAirlines;

	public boolean isSearchCompleted() {
		return searchCompleted;
	}

	public void setSearchCompleted(boolean searchCompleted) {
		this.searchCompleted = searchCompleted;
	}

	public String[] getRequestItems() {
		return requestItems;
	}

	public void setRequestItems(String[] requestItems) {
		this.requestItems = requestItems;
	}

	public String getSearchList() {
		return searchList;
	}

	public void setSearchList(String searchList) {
		this.searchList = searchList;
	}

	public List<SpecialFareAirlines> getSpecialFareAirlines() {
		return specialFareAirlines;
	}

	public void setSpecialFareAirlines(List<SpecialFareAirlines> specialFareAirlines) {
		this.specialFareAirlines = specialFareAirlines;
	}

}

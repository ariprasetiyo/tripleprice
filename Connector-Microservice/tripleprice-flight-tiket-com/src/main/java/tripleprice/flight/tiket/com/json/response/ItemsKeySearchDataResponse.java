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
	private boolean searchCompleted;
	private String[] requestItems;
	private SearchList searchList;
	private List<SpecialFareAirlines> specialFareAirlines;

	public boolean isSearchCompleted() {
		return searchCompleted;
	}

	public void setSearchCompleted(final boolean searchCompleted) {
		this.searchCompleted = searchCompleted;
	}

	public String[] getRequestItems() {
		return requestItems;
	}

	public void setRequestItems(final String[] requestItems) {
		this.requestItems = requestItems;
	}
	
	public SearchList getSearchList() {
		return searchList;
	}

	public void setSearchList(final SearchList searchList) {
		this.searchList = searchList;
	}

	public List<SpecialFareAirlines> getSpecialFareAirlines() {
		return specialFareAirlines;
	}

	public void setSpecialFareAirlines(final List<SpecialFareAirlines> specialFareAirlines) {
		this.specialFareAirlines = specialFareAirlines;
	}

}

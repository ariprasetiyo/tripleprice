package tripleprice.flight.traveloka.api.request;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ari.prasetiyo
 */

/*
 * { "clientInterface": "desktop", "data": { "currency": "IDR",
 * "destinationAirportOrArea": "DPS", "flightDate": { "day": "09", "month":
 * "09", "year": "2018" }, "locale": "en_ID", "newResult": true, "numSeats": {
 * "numAdults": "1", "numChildren": "0", "numInfants": "0" },
 * "seatPublishedClass": "ECONOMY", "seqNo": null, "sortFilter": {
 * "filterAirlines": [], "filterArrive": [], "filterDepart": [],
 * "filterTransit": [], "selectedDeparture": "", "sort": null },
 * "sourceAirportOrArea": "JKTA", "searchId": null, "usePromoFinder": false,
 * "useDateFlow": false }, "fields": [] }
 */
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class TravelokaFlightParams {

	private String clientInterface;

	@JsonProperty("data")
	private DataSearch DataSearch;

	private int[] fields;

	public String getClientInterface() {
		return clientInterface;
	}

	public void setClientInterface(final String clientInterface) {
		this.clientInterface = clientInterface;
	}

	public DataSearch getDataSearch() {
		return DataSearch;
	}

	public void setDataSearch(final DataSearch dataSearch) {
		DataSearch = dataSearch;
	}

	public int[] getFields() {
		return fields;
	}

	public void setFields(int[] fields) {
		this.fields = fields;
	}
}

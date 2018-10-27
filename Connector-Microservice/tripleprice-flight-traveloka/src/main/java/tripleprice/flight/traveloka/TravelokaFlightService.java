package tripleprice.flight.traveloka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tripleprice.flight.FlightItems;
import tripleprice.flight.FlightParams;
import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.service.FlightService;
import tripleprice.flight.traveloka.json.request.DataSearch;
import tripleprice.flight.traveloka.json.request.FlightDate;
import tripleprice.flight.traveloka.json.request.NumberSeats;
import tripleprice.flight.traveloka.json.request.SortFilter;
import tripleprice.flight.traveloka.json.request.TravelokaFlightParams;

/**
 * @author ari.prasetiyo
 */
@Service
public class TravelokaFlightService implements FlightService {

	@Autowired
	TravelokaConnector travelokaConnector;

	@Override
	public FlightItems flightSearchItem(final FlightParams flightParams) {
		final TravelokaFlightParams travelokaFlightParams = new TravelokaFlightParams();
		travelokaFlightParams.setClientInterface("desktop");

		DataSearch dataSearch = new DataSearch();
		dataSearch.setCurrency("IDR");
		dataSearch.setDestionationAirportOrArea("DPS");

		dataSearch.setFlightClassType(FlightClassType.ECONOMY);

		FlightDate flightDate = new FlightDate();
		flightDate.setDay("9");
		flightDate.setMonth("11");
		flightDate.setYear("2018");
		dataSearch.setFlightDate(flightDate);

		dataSearch.setLocale("en_ID");
		dataSearch.setNewResult(true);

		NumberSeats numberSeats = new NumberSeats();
		numberSeats.setAdultsNum("1");
		numberSeats.setChildrenNum("0");
		numberSeats.setInfantsNum("0");
		dataSearch.setNumberSeats(numberSeats);

		dataSearch.setSearchId(null);
		dataSearch.setSeqNo(null);

		int[] zeroData = {};
		SortFilter sortFilter = new SortFilter();
		sortFilter.setFilterAirlines(zeroData);
		sortFilter.setFilterArrive(zeroData);
		sortFilter.setFilterDepart(zeroData);
		sortFilter.setFilterTransit(zeroData);
		sortFilter.setSelectedDeparture("");
		sortFilter.setSort(null);
		dataSearch.setSortFilter(sortFilter);

		dataSearch.setSourceAirportOrArea("JKTA");
		dataSearch.setUseDateFlow(false);
		dataSearch.setUsePromoFinder(false);

		travelokaFlightParams.setDataSearch(dataSearch);
		travelokaFlightParams.setFields(zeroData);
		final String responseJsonResult = travelokaConnector.getSearch(travelokaFlightParams);
		return null;
	}

}

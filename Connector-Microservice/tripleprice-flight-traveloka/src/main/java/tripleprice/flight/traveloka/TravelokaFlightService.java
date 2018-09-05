package tripleprice.flight.traveloka;

import tripleprice.flight.service.FlightConnectorService;
import tripleprice.flight.bean.FlightSearchItem;

public class TravelokaFlightService implements FlightConnectorService {

	/**
	 * https://www.traveloka.com/api/v2/flight/search/oneway
	 * 
	 * method post request body
	 * {"clientInterface":"desktop","data":{"currency":"IDR","destinationAirportOrArea":"DPS","flightDate":{"day":"07","month":"09","year":"2018"},"locale":"en_ID","newResult":true,"numSeats":{"numAdults":"1","numChildren":"0","numInfants":"0"},"seatPublishedClass":"ECONOMY","seqNo":null,"sortFilter":{"filterAirlines":[],"filterArrive":[],"filterDepart":[],"filterTransit":[],"selectedDeparture":"","sort":null},"sourceAirportOrArea":"JKTA","searchId":null,"usePromoFinder":false,"useDateFlow":false},"fields":[]}
	 */
	@Override
	public FlightSearchItem flightSearchItem() {
		// TODO Auto-generated method stub
		return null;
	}

}

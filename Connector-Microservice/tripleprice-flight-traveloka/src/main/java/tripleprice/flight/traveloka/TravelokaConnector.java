package tripleprice.flight.traveloka;

public class TravelokaConnector {
	
	/**
	 * https://www.traveloka.com/api/v2/flight/search/oneway
	 * 
	 *1. method post request body
	 * {"clientInterface":"desktop","data":{"currency":"IDR","destinationAirportOrArea":"DPS","flightDate":{"day":"07","month":"09","year":"2018"},"locale":"en_ID","newResult":true,"numSeats":{"numAdults":"1","numChildren":"0","numInfants":"0"},"seatPublishedClass":"ECONOMY","seqNo":null,"sortFilter":{"filterAirlines":[],"filterArrive":[],"filterDepart":[],"filterTransit":[],"selectedDeparture":"","sort":null},"sourceAirportOrArea":"JKTA","searchId":null,"usePromoFinder":false,"useDateFlow":false},"fields":[]}
	 *
	 *2. https://clientstate.traveloka.com/getAuthToken
	 *	Response : auth-ecf46fb3-d08b-426b-a0c1-405e40e76b61
	 *3. https://clientstate.traveloka.com/setCrossSellingToken
	 *	Response : x-sasalkkkhdskjkdskdkjkdsjk
	 *4. Will redirect
	 */
	TravelokaConnector(){
		
	}
}

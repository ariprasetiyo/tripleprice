package tripleprice.flight.traveloka;

import org.apache.http.HttpHeaders;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import tripleprice.flight.service.FlightConnector;
import tripleprice.flight.traveloka.json.request.TravelokaFlightParams;

/**
* @author ari.prasetiyo
*/

/**
 * https://www.traveloka.com/api/v2/flight/search/oneway
 * 
 * 1. method post request body
 * {"clientInterface":"desktop","data":{"currency":"IDR","destinationAirportOrArea":"DPS","flightDate":{"day":"07","month":"09","year":"2018"},"locale":"en_ID","newResult":true,"numSeats":{"numAdults":"1","numChildren":"0","numInfants":"0"},"seatPublishedClass":"ECONOMY","seqNo":null,"sortFilter":{"filterAirlines":[],"filterArrive":[],"filterDepart":[],"filterTransit":[],"selectedDeparture":"","sort":null},"sourceAirportOrArea":"JKTA","searchId":null,"usePromoFinder":false,"useDateFlow":false},"fields":[]}
 *
 * 2. https://clientstate.traveloka.com/getAuthToken Response :
 * auth-ecf46fb3-d08b-426b-a0c1-405e40e76b61 3.
 * https://clientstate.traveloka.com/setCrossSellingToken Response :
 * x-sasalkkkhdskjkdskdkjkdsjk 4. Will redirect
 */
@Service
public class TravelokaConnector implements FlightConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(TravelokaConnector.class);
	private static final String ACCECPT = "Accept";
	// private static final String ACCECPT_HTML_XML =
	// "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
	private static final String ACCEPT_ENCODING = "Accept-Encoding";
	private static final String ACCEPT_ENCODING_GZIP = "gzip, deflate, br";
	private static final String USER_AGENT = "User-Agent";
	private static final String USER_AGENT_HEADER_VALUE = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0";
	private static final String CONNECTION = "Connection";
	private static final String KEEP_ALIVE = "keep-alive";
	private static final String HOST = "Host";
	private static final String TRAVELOKA = "www.traveloka.com";
	private static final String COOKIE = "Cookie";
	private static final String COOKIE_VALUE = "tvl=h8lPe2A5rIMX3qJeMdT+GLKY80T3fMleXmjzJsRHUPla7FLretKPtdyBvh+PjyEGoQ9RRAjATsalLNN15smbzxRJcYim5+19/er1Wd/RLHuhPuylMcP5u6VR9qX5cl8/15Q1oTaZEH0m01m+wrfeHxDtgfYOtdNtQcNVD2XUHuXvlyHfFnPptZUxAgMVwRNS7+hvPMp2RiJXs5rzcYJxY2k4pY16Mmj2gsuuuHP4W/tpbkMNIfYtd92Qw79iTCSobyx8nbWsVx0690Q9vsZr0EVVsDDTikdJc+B3m2Dw560=; __utma=130213834.918425490.1521131683.1521131683.1524916225.2; __utmz=130213834.1524916225.2.2.utmgclid=EAIaIQobChMIp6P4y_Pc2gIVWI6PCh0f2wkZEAAYAiAAEgIVxfD_BwE|utmccn=(not%20set)|utmcmd=(not%20set)|utmctr=(not%20provided); _ga=GA1.2.918425490.1521131683; G_ENABLED_IDPS=google; ajs_user_id=null; ajs_group_id=null; ajs_anonymous_id=%22e9f8f998-138b-4b56-a805-9e8bc2ba0934%22; __ssid=e95df06d-f9cc-47ce-9344-df462a2630d1; __flash={}; cto_lwid=b18de052-6e1b-4c73-bd9a-269794f69a00; _ceg.s=peq8gx; _ceg.u=peq8gx; tv-repeat-visit=true; tvs=Ze3HJeEQ9yKlnvwl83HfnFil4vlxw5shRIj+yPwKKMSJu6sDGPzXE/SZBB1NUGxhr5PeRYQ459nisNHTBXtoLBws3r5fKxPj62n1bJ+Nck2q8W5NcUFDHWHJgTJoLeOefCkxj3UBgXMnqHzNr+9KuV64FP+yIMPAFcawIG6+b25asn/fbcAWTALLLcOJq96pD35EQ13gFJbUKyld+1V9Hw==; isFirst10DomesticSearch=2; useDateFlow=false; usePromoFinder=null; flightSourceAirport=JKTA; flightDestinationAirport=DPS; flightDepartureDate=09-09-2018; flightFlightType=ONE_WAY; flightNumOfAdults=1; flightNumChildren=0; flightNumInfants=0; flightSeatClassType=ECONOMY; flexibility=0; _gid=GA1.2.43800042.1536393042; _gat_UA-29776811-1=1; lux_uid=153639304302581688; browserupdateorg=pause; _gat_UA-29776811-8=1; _gat_UA-29776811-11=1";
	private static final String ACCEPT_LANGUANGE = "Accept-Language";
	private static final String ACCEPT_LANGUANGE_VALUE = "en-US,en;q=0.5";
	// private static final String UPGRADE_INSECURE_REQUEST =
	// "Upgrade-Insecure-Requests";
	// private static final String UPGRADE_INSECURE_REQUEST_VALUE = "1";
	private static final String X_DOMAIN_HEADER = "x-domain";
	private static final String FLIGHT_HTTP_HEADER_VALUE = "flight";
	private static RestTemplate restTemplate;
	private static final ObjectMapper jsonObjectMapper = new ObjectMapper();
	private static final ObjectWriter jsonSearchRequest = jsonObjectMapper.writerFor(TravelokaFlightParams.class);
	private static final MultiValueMap<String, String> flightSearchHeader = new LinkedMultiValueMap<String, String>();

	private final String travelokaFlightSearchOneWayUrl;

	TravelokaConnector(final String travelokaFlightSearchOneWayUrl) {
		this.travelokaFlightSearchOneWayUrl = travelokaFlightSearchOneWayUrl;
		LOGGER.debug("\ntravelokaFlightSearchOneWayUrl={}", travelokaFlightSearchOneWayUrl);
	}

	public void start() {
		// RestTemplate add configuration decode GZIP automatically
		final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		restTemplate = new RestTemplate(clientHttpRequestFactory);

		/**
		 * Set Header
		 */
		flightSearchHeader.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		flightSearchHeader.add(X_DOMAIN_HEADER, FLIGHT_HTTP_HEADER_VALUE);
		flightSearchHeader.add(USER_AGENT, USER_AGENT_HEADER_VALUE);
		flightSearchHeader.add(HOST, TRAVELOKA);
		flightSearchHeader.add(ACCECPT, MediaType.APPLICATION_JSON_VALUE);
		flightSearchHeader.add(ACCEPT_ENCODING, ACCEPT_ENCODING_GZIP);
		flightSearchHeader.add(CONNECTION, KEEP_ALIVE);
		flightSearchHeader.add(COOKIE, COOKIE_VALUE);
		flightSearchHeader.add(ACCEPT_LANGUANGE, ACCEPT_LANGUANGE_VALUE);

		LOGGER.debug("TravelokaConnector connector start");
	}

	public void close() {
		LOGGER.debug("TravelokaConnector connector closed");
	}

	@Override
	public String getSearch(final Object flightParams) {
		/**
		 * Benchmark casting instanceOf versus class
		 * http://www.theeggeadventure.com/wikimedia/index.php/InstanceOf_Performance
		 */
		final TravelokaFlightParams travelokaFlightParams = (flightParams.getClass() == TravelokaFlightParams.class)
				? (TravelokaFlightParams) flightParams : null;

		if (travelokaFlightParams == null) {
			LOGGER.debug("Request travelokaFlightParams null");
			return null;
		}

		try {
			final String jsonRequest = jsonSearchRequest.writeValueAsString(travelokaFlightParams);

			final HttpEntity<String> flightSearchHttpEntity = new HttpEntity<>(jsonRequest, flightSearchHeader);
			LOGGER.info("\nRequest url=\"{}\",\nrequest header={}\nrequest body={}", travelokaFlightSearchOneWayUrl,
					flightSearchHttpEntity.getHeaders(), flightSearchHttpEntity.getBody());

			final ResponseEntity<String> responseFlightSearch = restTemplate.exchange(
					this.travelokaFlightSearchOneWayUrl, HttpMethod.POST, flightSearchHttpEntity, String.class);
			LOGGER.info("Response={}", responseFlightSearch);

			return responseFlightSearch.getBody();
		} catch (Exception e) {
			LOGGER.debug("Error traveloka connector", e);
			return null;
		}
	}
}

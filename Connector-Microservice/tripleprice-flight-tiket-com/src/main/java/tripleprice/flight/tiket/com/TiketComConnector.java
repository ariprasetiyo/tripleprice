package tripleprice.flight.tiket.com;

import java.util.HashMap;
import java.util.Map;

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

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;

import tripleprice.flight.service.FlightConnector;
import tripleprice.flight.tiket.com.json.response.ItemsKeySearchResponse;
import tripleprice.flight.tiket.com.pojo.TiketComFlightParams;

/**
* @author ari.prasetiyo
*/

/**
 * https://www.tiketCom.com/api/v2/flight/search/oneway
 */
@Service
public class TiketComConnector implements FlightConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(TiketComConnector.class);
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
	private static final String HOST_TIKET_COM = "www.tiket.com";
	private static final String COOKIE = "Cookie";
	private static final String COOKIE_VALUE = "device[type]=x; PHPSESSID=k0nm6pobccsskjm97elboks7ukjmmfst; tsct=6a8fa5d88fa93a4627a365cde997d6ea; userlang=id; usercurrency=IDR; partner=%28default%29; _vwo_uuid_v2=D302D2F55465AE2DDAEDD43B53AE8CF5C|a0909eee25e4b13eed14deae794072cf; scarab.visitor=%2272BDE2E7CD2EECA4%22; mp_0c9321f761e6801a5b23d3cda0855f9a_mixpanel=%7B%22distinct_id%22%3A%20%221662fa1728f449-09a926b122fbbe-75276752-1fa400-1662fa172909dd%22%2C%22%24initial_referrer%22%3A%20%22%24direct%22%2C%22%24initial_referring_domain%22%3A%20%22%24direct%22%7D; _ga=GA1.2.2132747304.1538397402; _gid=GA1.2.1445041897.1538397402; _gcl_au=1.1.1668205089.1538397402; AMP_TOKEN=%24NOT_FOUND; __asc=8905d43b1662fa17312c2f98c58; __auc=8905d43b1662fa17312c2f98c58; cto_lwid=70fef4d1-ba6c-45de-ba7d-67f78674b6b8; holidays=%257B%2522title%2522%253A%257B%2522en%2522%253A%2522Holidays%2522%252C%2522id%2522%253A%2522Hari%2520Libur%2522%257D%252C%252220%252F11%252F2018%2522%253A%257B%2522id%2522%253A%2522Maulid%2520Nabi%2520Muhammad%2520SAW%2522%252C%2522en%2522%253A%2522Birth%2520of%2520the%2520Prophet%2520Muhammad%2520SAW%2522%257D%252C%252224%252F12%252F2018%2522%253A%257B%2522id%2522%253A%2522Cuti%2520Bersama%2522%252C%2522en%2522%253A%2522Mass%2520Leave%2522%257D%252C%252225%252F12%252F2018%2522%253A%257B%2522id%2522%253A%2522Hari%2520Raya%2520Natal%2522%252C%2522en%2522%253A%2522Christmas%2520Day%2520%2522%257D%252C%252201%252F01%252F2019%2522%253A%257B%2522id%2522%253A%2522Tahun%2520Baru%2520%2522%252C%2522en%2522%253A%2522New%2520Year%2522%257D%257D; lc_sso1082127=1538397432162; __lc.visitor_id.1082127=S1538397431.cbf2601d4f";
	private static final String ACCEPT_LANGUANGE = "Accept-Language";
	private static final String ACCEPT_LANGUANGE_VALUE = "en-US,en;q=0.5";
	private static final String ORIGIN_HEADER = "origin";
	private static final String ORIGIN_VALUE = "https://www.tiket.com";

	private static final String CURRENCY_HEADER = "currency";
	private static final String CURRENCY_VALUE = "IDR";
	private static final String CONTENT_LENGHT_HEADER = "Content-Length";
	private static final String CONTENT_LENGHT_VALUE = "1798";

	private static final String REQUEST_ITEMS_KEY = "requestItems";
	private static RestTemplate restTemplate;
	private static final ObjectMapper jsonObjectMapper = new ObjectMapper();
	private static final ObjectReader jsonItemSeachKeyResponse = jsonObjectMapper
			.readerFor(ItemsKeySearchResponse.class);
	private static final TypeReference<Map<String, String[]>> typeReferenceStringArray = new TypeReference<Map<String, String[]>>() {
	};
	private static final ObjectWriter REQUEST_ITEMS_JSON = jsonObjectMapper.writerFor(typeReferenceStringArray);
	private static final MultiValueMap<String, String> FLIGHT_SEARCH_KEY_HEADER = new LinkedMultiValueMap<String, String>();
	private static final MultiValueMap<String, String> FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER = new LinkedMultiValueMap<String, String>();

	private final String tiketSearchKeyUrl;
	private final String tiketSearchStreamingUrl;

	TiketComConnector(final String tiketSearchKeyUrl, final String tiketSearchStreamingUrl) {
		this.tiketSearchKeyUrl = tiketSearchKeyUrl;
		this.tiketSearchStreamingUrl = tiketSearchStreamingUrl;
		LOGGER.debug("\ntiketSearchKeyUrl={}", tiketSearchKeyUrl);
	}

	public void start() {
		// RestTemplate add configuration decode GZIP automatically
		final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		restTemplate = new RestTemplate(clientHttpRequestFactory);

		setHeaderSearchKeyStringUrl();
		setHeaderSearchFlightStreaming();

		LOGGER.debug("TiketComConnector connector start");
	}

	public void close() {
		LOGGER.debug("TiketComConnector connector closed");
	}

	/**
	 * Set header http get/post
	 */
	private void setHeaderSearchKeyStringUrl() {
		FLIGHT_SEARCH_KEY_HEADER.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		FLIGHT_SEARCH_KEY_HEADER.add(USER_AGENT, USER_AGENT_HEADER_VALUE);
		FLIGHT_SEARCH_KEY_HEADER.add(HOST, HOST_TIKET_COM);
		FLIGHT_SEARCH_KEY_HEADER.add(ACCECPT, MediaType.APPLICATION_JSON_VALUE);
		FLIGHT_SEARCH_KEY_HEADER.add(ACCEPT_ENCODING, ACCEPT_ENCODING_GZIP);
		FLIGHT_SEARCH_KEY_HEADER.add(CONNECTION, KEEP_ALIVE);
		FLIGHT_SEARCH_KEY_HEADER.add(COOKIE, COOKIE_VALUE);
		FLIGHT_SEARCH_KEY_HEADER.add(ACCEPT_LANGUANGE, ACCEPT_LANGUANGE_VALUE);
		FLIGHT_SEARCH_KEY_HEADER.add(ORIGIN_HEADER, ORIGIN_VALUE);
	}

	private void setHeaderSearchFlightStreaming() {

		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(USER_AGENT, USER_AGENT_HEADER_VALUE);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(HOST, HOST_TIKET_COM);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(ACCECPT, MediaType.APPLICATION_JSON_VALUE);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(ACCEPT_ENCODING, ACCEPT_ENCODING_GZIP);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(CONNECTION, KEEP_ALIVE);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(COOKIE, COOKIE_VALUE);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(ACCEPT_LANGUANGE, ACCEPT_LANGUANGE_VALUE);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(ORIGIN_HEADER, ORIGIN_VALUE);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(CURRENCY_HEADER, CURRENCY_VALUE);
		FLIGHT_SEARCH_FLIGHT_STREAMING_HEADER.add(CONTENT_LENGHT_HEADER, CONTENT_LENGHT_VALUE);
	}

	@Override
	public final String getSearch(final Object flightParams) {

		final TiketComFlightParams tiketComFlightParams = (flightParams.getClass() == TiketComFlightParams.class)
				? (TiketComFlightParams) flightParams : null;

		if (tiketComFlightParams == null) {
			LOGGER.debug("Request tiketComFlightParams null");
			return null;
		}
		final String requestItemsJson = getItemStreamSearch(tiketComFlightParams);
		return getFlightSearch(requestItemsJson);
	}

	private final String getFlightSearch(final String requestItemsJson) {

		try {
			final HttpEntity<?> flightSearchHttpEntity = new HttpEntity<>(requestItemsJson, FLIGHT_SEARCH_KEY_HEADER);
			LOGGER.info("\nRequest url=\"{}\",\nrequest header={}\nrequest body={}", this.tiketSearchStreamingUrl,
					flightSearchHttpEntity.getHeaders(), flightSearchHttpEntity.getBody());
			final ResponseEntity<String> responseFlightSearch = restTemplate.exchange(this.tiketSearchStreamingUrl,
					HttpMethod.POST, flightSearchHttpEntity, String.class);
			LOGGER.info("Response={}", responseFlightSearch);
			return responseFlightSearch.getBody();
		} catch (Exception e) {
			LOGGER.debug("Error tiketCom connector", e);
			return null;
		}
	}

	private final String getItemStreamSearch(final TiketComFlightParams tiketComFlightParams) {

		try {
			final String urlStringSearch = getUrlStringSearch(tiketComFlightParams);
			final HttpEntity<String> flightSearchHttpEntity = new HttpEntity<>(FLIGHT_SEARCH_KEY_HEADER);
			LOGGER.info("\nRequest url=\"{}\",\nrequest header={}\nrequest body={}", urlStringSearch,
					flightSearchHttpEntity.getHeaders(), flightSearchHttpEntity.getBody());
			final ResponseEntity<String> responseFlightSearch = restTemplate.exchange(urlStringSearch, HttpMethod.GET,
					flightSearchHttpEntity, String.class);
			LOGGER.info("Response={}", responseFlightSearch);
			ItemsKeySearchResponse itemsKeySearchResponse = jsonItemSeachKeyResponse
					.readValue(responseFlightSearch.getBody());

			final Map<String, String[]> requestItemsMap = new HashMap<>();
			requestItemsMap.put(REQUEST_ITEMS_KEY, itemsKeySearchResponse.getData().getRequestItems());
			return REQUEST_ITEMS_JSON.writeValueAsString(requestItemsMap);
		} catch (Exception e) {
			LOGGER.debug("Error tiketCom connector", e);
			return null;
		}
	}

	private final String getUrlStringSearch(final TiketComFlightParams tiketComFlightParams) {
		final StringBuilder stringUrlSearch = new StringBuilder();
		stringUrlSearch.append(this.tiketSearchKeyUrl);
		stringUrlSearch.append("origin=");
		stringUrlSearch.append(tiketComFlightParams.getOrigin());
		stringUrlSearch.append("&destination=");
		stringUrlSearch.append(tiketComFlightParams.getDestination());
		stringUrlSearch.append("&departureDate=");
		stringUrlSearch.append(tiketComFlightParams.getDepatureDate());
		stringUrlSearch.append("&adult=");
		stringUrlSearch.append(tiketComFlightParams.getAdult());
		stringUrlSearch.append("&child=");
		stringUrlSearch.append(tiketComFlightParams.getChild());
		stringUrlSearch.append("&infant=");
		stringUrlSearch.append(tiketComFlightParams.getInfant());
		stringUrlSearch.append("&cabinClass=");
		stringUrlSearch.append(tiketComFlightParams.getFlightClassType().toString());
		stringUrlSearch.append("&originType=");
		stringUrlSearch.append(tiketComFlightParams.getOriginType());
		stringUrlSearch.append("&destinationType=");
		stringUrlSearch.append(tiketComFlightParams.getDestionationType());
		stringUrlSearch.append("&searchType=");
		stringUrlSearch.append(tiketComFlightParams.getTripType().toString());
		stringUrlSearch.append("&resultType=");
		stringUrlSearch.append(tiketComFlightParams.getResultType()).toString();
		stringUrlSearch.append("&async=");
		stringUrlSearch.append(tiketComFlightParams.isAsync());
		return stringUrlSearch.toString();
	}

}

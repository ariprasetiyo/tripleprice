package tripleprice.flight.nusatrip;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import tripleprice.cache.CacheChannel;
import tripleprice.flight.service.FlightConnector;

/**
 * @author ari.prasetiyo
 */
@Service
public class NusatripConnector implements FlightConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(NusatripConnector.class);

	private static final String HOST_NUSATRIP = "www.nusatrip.com";
	private static final String HOST = "Host";
	private static final String ACCECPT = "Accept";
	private static final String ACCECPT_HTML_XML = "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8";
	private static final String ACCEPT_ENCODING = "Accept-Encoding";
	private static final String ACCEPT_ENCODING_GZIP = "gzip, deflate";
	private static final String USER_AGENT = "User-Agent";
	private static final String USER_AGENT_NUSATRIP = "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0";
	private static final String CONNECTION = "Connection";
	private static final String KEEP_ALIVE = "keep-alive";
	private static final String UPGRADE_INSECURE_REQUEST = "Upgrade-Insecure-Requests";
	private static final String UPGRADE_INSECURE_REQUEST_VALUE = "1";
	private static final String COOKIE = "Cookie";
	private static final String COOKIE_VALUE = "nslang=en; curCode=IDR; __utma=121037335.1558514899.1524916676.1539513270.1539520099.13; __utmz=121037335.1534075353.2.2.utmgclid=EAIaIQobChMIjv_bgrzn3AIVlIloCh1XBw85EAEYASAAEgLKPPD_BwE|utmccn=(not%20set)|utmcmd=(not%20set); nssearchhistory=1%3A%3A%7C%3A%3ADPS%5E%5EBali%2C+Ngurah+Rai+Intl.%5E%5EDenpasar%5E%5EBali%5E%5EIndonesia%7CCGK%5E%5ESoekarno+Hatta%5E%5EJakarta%5E%5EIndonesia%3A%3A20181124%3A%3A%3A%3A2%7C0%3A%3A0%3B1%3A%3A%7C%3A%3A_JKT%5E%5EAll+Airports%5E%5EJakarta%5E%5EIndonesia%7CSOC%5E%5EAdi+Sumarmo%5E%5ESolo+%7C+Surakarta%5E%5EJawa+Tengah%5E%5EIndonesia%3A%3A20180906%3A%3A%3A%3A1%7C0%3A%3A-1; nsdevice=d; fromcoo=UPSE:mail*:1536159937||; _gac_UA-33251722-1=1.1534075353.EAIaIQobChMIjv_bgrzn3AIVlIloCh1XBw85EAEYASAAEgLKPPD_BwE; __utmb=121037335.3.10.1539520099; __utmt=1; __utmc=121037335";
	private static final String NUSATRIP_KEY_SEARCH_CACHE = "key:search";
	private static final SimpleDateFormat YYYYMMDD_FORMATE = new SimpleDateFormat("YYYYMMdd");
	private static RestTemplate restTemplate;
	private static HttpEntity<?> flightSearchHttpEntity;

	private final String urlSearchGetToken;
	private final String urlSearchGetFlightListJson;

	@Autowired
	@Qualifier("nusatripKeySearchCache")
	private CacheChannel cacheChannelNusatrip;

	/*
	 * @Autowired TripepriceProperties tripepriceProperties;
	 */
	NusatripConnector(final String urlSearchGetToken, final String urlSearchGetFlightListJson) {

		this.urlSearchGetToken = urlSearchGetToken;
		this.urlSearchGetFlightListJson = urlSearchGetFlightListJson;

		System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		LOGGER.debug("\nurlSearchGetToken={}\nurlSearchGetFlightListJson={}", urlSearchGetToken,
				urlSearchGetFlightListJson);
	}

	public void start() {
		/**
		 * Set Header
		 */
		final MultiValueMap<String, String> flightSearchHeader = new LinkedMultiValueMap<String, String>();
		flightSearchHeader.add(HOST, HOST_NUSATRIP);
		flightSearchHeader.add(USER_AGENT, USER_AGENT_NUSATRIP);
		flightSearchHeader.add(ACCECPT, ACCECPT_HTML_XML);
		flightSearchHeader.add(ACCEPT_ENCODING, ACCEPT_ENCODING_GZIP);
		flightSearchHeader.add(CONNECTION, KEEP_ALIVE);
		flightSearchHeader.add(UPGRADE_INSECURE_REQUEST, UPGRADE_INSECURE_REQUEST_VALUE);
		flightSearchHttpEntity = new HttpEntity<Object>(flightSearchHeader);

		// RestTemplate add configuration decode GZIP automatically
		final HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		restTemplate = new RestTemplate(clientHttpRequestFactory);
		LOGGER.debug("NusatripConnector connector start");
	}

	public void close() {
		LOGGER.debug("NusatripConnector connector closed");
	}
	
	private void headerSearchFlight(){
		
	}

	public String getSearch(final Object flightParams) {

		/**
		 * Benchmark casting instanceOf versus class
		 * http://www.theeggeadventure.com/wikimedia/index.php/InstanceOf_Performance
		 */
		final NusatripFlightParams nusatripFlightParams = (flightParams.getClass() == NusatripFlightParams.class)
				? (NusatripFlightParams) flightParams : null;

		if (nusatripFlightParams == null) {
			LOGGER.debug("Couldn't casting object to NusatripFlightParams");
			return null;
		}

		try {
			final StringBuilder keySearchCache = new StringBuilder();
			keySearchCache.append(NUSATRIP_KEY_SEARCH_CACHE);
			keySearchCache.append(":");
			keySearchCache.append(YYYYMMDD_FORMATE.format(nusatripFlightParams.getDepatureDate()));

			String resultKeyFlightSearch = this.cacheChannelNusatrip.lookup(keySearchCache.toString());
			if (resultKeyFlightSearch == null) {
				resultKeyFlightSearch = getKeySearchFlight(nusatripFlightParams);
				if (resultKeyFlightSearch == null) {
					LOGGER.warn("Key search not found. FlightParams={}", nusatripFlightParams);
					return null;
				}
				this.cacheChannelNusatrip.load(keySearchCache.toString(), resultKeyFlightSearch);
			}

			return getResponseFlightSearch(resultKeyFlightSearch);
		} catch (Exception ex) {
			LOGGER.debug("{}", ex);
		}
		return null;
	}

	private String getKeySearchFlight(final NusatripFlightParams nusatripFlightParams) {
		/**
		 * Handle customize header
		 * 
		 * @link{https://github.com/jhy/jsoup/issues/541}
		 */
		final StringBuilder urlSearchGetTokenFinal = new StringBuilder();
		urlSearchGetTokenFinal.append(this.urlSearchGetToken);
		urlSearchGetTokenFinal.append("departDate=");
		urlSearchGetTokenFinal.append(YYYYMMDD_FORMATE.format(nusatripFlightParams.getDepatureDate()));
		urlSearchGetTokenFinal.append("&lang=");
		urlSearchGetTokenFinal.append("en");
		urlSearchGetTokenFinal.append("&departure=");
		urlSearchGetTokenFinal.append(nusatripFlightParams.getDepatureAirportCode());
		urlSearchGetTokenFinal.append("&adultNum=");
		urlSearchGetTokenFinal.append(nusatripFlightParams.getAdultsNum());
		urlSearchGetTokenFinal.append("&arrival=");
		urlSearchGetTokenFinal.append(nusatripFlightParams.getArrivalAirportCode());

		LOGGER.debug("Request : key flight search={}", urlSearchGetTokenFinal.toString());
		final Connection connectionStageOne = Jsoup.connect(urlSearchGetTokenFinal.toString());
		connectionStageOne.header(HOST, HOST_NUSATRIP);
		connectionStageOne.header(USER_AGENT, USER_AGENT_NUSATRIP);
		connectionStageOne.header(COOKIE, COOKIE_VALUE);
		connectionStageOne.header(CONNECTION, KEEP_ALIVE);
		connectionStageOne.header(UPGRADE_INSECURE_REQUEST_VALUE, UPGRADE_INSECURE_REQUEST_VALUE);
		connectionStageOne.header(ACCEPT_ENCODING, ACCEPT_ENCODING_GZIP);
		connectionStageOne.header(ACCECPT, ACCECPT_HTML_XML);
		final Document doc;
		try {
			doc = connectionStageOne.get();
		} catch (IOException e) {
			LOGGER.error("{}", e);
			return null;
		}

		final Pattern p = Pattern.compile("rkey=*.*");
		final Matcher m = p.matcher(doc.select("script").html());
		String resultKey = null;
		while (m.find()) {
			resultKey = m.group().replace("rkey=", "").split("\',")[0];
		}

		LOGGER.debug("Response : key flight search={}", resultKey);
		return resultKey;
	}

	private String getResponseFlightSearch(String keyFlightSearch) {

		final StringBuilder urlGetFlightSearch = new StringBuilder();
		urlGetFlightSearch.append(this.urlSearchGetFlightListJson);
		urlGetFlightSearch.append(keyFlightSearch);

		LOGGER.debug("Request={}", urlGetFlightSearch.toString());
		final ResponseEntity<String> responseFlightSearch = restTemplate.exchange(urlGetFlightSearch.toString(),
				HttpMethod.POST, flightSearchHttpEntity, String.class);

		LOGGER.debug("Response={}", responseFlightSearch);
		return responseFlightSearch.getBody();
	}

	private void getCheckoutConfirm() {
		// http://www.nusatrip.com/checkout/booking
		// create form parameters as a MultiValueMap
		final MultiValueMap<String, String> formVars = new LinkedMultiValueMap<>();
		formVars.add("bookingType", "FLIGHT");
		formVars.add("cabinType", "-1");
		formVars.add("flightType", "oneway");
		formVars.add("searchParam",
				"{\"departureLabel\":\"Denpasar+(DPS+:+Bali,+Ngurah+Rai+Intl.)+Bali+Indonesia\",\"arrivalLabel\":\"Jakarta+(CGK+:+Soekarno+Hatta)+Indonesia\",\"adultNum\":\"1\",\"childNum\":\"0\",\"infantNum\":\"0\",\"departure\":\"DPS\",\"arrival\":\"CGK\",\"departDate\":\"20181024\",\"roundTrip\":0,\"cabinType\":-1,\"departureCode\":\"ID-Denpasar-DPS\",\"arrivalCode\":\"ID-Jakarta-CGK\"}");
		formVars.add("round-ti", "");
		formVars.add("outboundParam",
				"91XXiAjKepCMq4lKq4lKq4lKq4lKq4lKwoiXqAjMq4lKwATMq4lKwADM0cDM0IDMxgTMwIjKepCMwADM3ADNyATM4EDMyoiXqs0RDpiXqMFUEpiXqETMgQlSq4lKUpkIbpjIzVGd19mciwiIxgzN00iKepCMq4lKwoiXqADMykjN1oiXqEjKepCM2MjKepiKepiNq4lKwoiXqADMxoiXqEjKepCMq4lKq4lKq4lKq4lKq4lKq4lK5EjNzMTMxoiXqADMwQzNwQjMwEDOxAjMq4lKwADMwcDM0IDMxgTMwIjKepySHNkKepyUQRkKepCMq4lKq4lKUpkKepSMxQlSUpkI6ISbhJXYwJye6IiYvJye");
		formVars.add("outboundFare", "");
		formVars.add("outboundOriginFare", "");
		formVars.add("outboundTrip", "");
		formVars.add("outbound-dtl", "{}");
		formVars.add("inboundParam", "");
		formVars.add("inboundFare", "");
		formVars.add("inboundOriginFare", "");
		formVars.add("inboundTrip", "");
		formVars.add("inbound-dtl", "");

		// send the request -- our service returns a String in the body
		/*
		 * final String result = restTemplate.postForObject(
		 * "http://nusatrip.com/checkout/booking", formVars, String.class);
		 */

		// Note the body object as first parameter!

		MultiValueMap<String, String> headerParam = new LinkedMultiValueMap<String, String>();
		headerParam.add("Host", "www.nusatrip.com");
		headerParam.add("Cookie",
				"nslang=en; curCode=IDR; __utma=121037335.1558514899.1524916676.1536166458.1536247442.5; __utmz=121037335.1534075353.2.2.utmgclid=EAIaIQobChMIjv_bgrzn3AIVlIloCh1XBw85EAEYASAAEgLKPPD_BwE|utmccn=(not%20set)|utmcmd=(not%20set); nssearchhistory=1%3A%3A%7C%3A%3ADPS%5E%5EBali%2C+Ngurah+Rai+Intl.%5E%5EDenpasar%5E%5EBali%5E%5EIndonesia%7CCGK%5E%5ESoekarno+Hatta%5E%5EJakarta%5E%5EIndonesia%3A%3A20180924%3A%3A%3A%3A1%7C0%3A%3A-1%3B1%3A%3A%7C%3A%3A_JKT%5E%5EAll+Airports%5E%5EJakarta%5E%5EIndonesia%7CSOC%5E%5EAdi+Sumarmo%5E%5ESolo+%7C+Surakarta%5E%5EJawa+Tengah%5E%5EIndonesia%3A%3A20180906%3A%3A%3A%3A1%7C0%3A%3A-1; nsdevice=d; fromcoo=UPSE:mail*:1536159937||; _gac_UA-33251722-1=1.1534075353.EAIaIQobChMIjv_bgrzn3AIVlIloCh1XBw85EAEYASAAEgLKPPD_BwE; __utmc=121037335; __utmb=121037335.13.8.1536249343874; nscartsess=d66c3fc21dbbb6acf17487f6aa66ce81; __utmt=1");
		headerParam.add("Upgrade-Insecure-Requests", "1");
		headerParam.add("Referer", "http://www.nusatrip.com/flights/search");
		headerParam.add("Content-Length", "1146");
		headerParam.add("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0");
		headerParam.add("Content-Type", "application/x-www-form-urlencoded");
		headerParam.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		headerParam.add("Accept-Language", "en-US,en;q=0.5");
		headerParam.add("Accept-Encoding", "gzip, deflate");
		headerParam.add("Connection", "keep-alive");

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClientBuilder.create().build());
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		HttpEntity<?> httpEntity = new HttpEntity<Object>(formVars, headerParam);
		ResponseEntity<String> response = restTemplate.exchange("http://nusatrip.com/checkout/booking", HttpMethod.POST,
				httpEntity, String.class);

		String resultString = response.getBody();
		HttpHeaders headers = response.getHeaders();

		// System.out.println(resultString.toString());
		// System.out.println(headers.toString());
	}
}

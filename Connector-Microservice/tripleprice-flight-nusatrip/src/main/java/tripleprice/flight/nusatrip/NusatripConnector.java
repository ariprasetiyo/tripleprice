package tripleprice.flight.nusatrip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import tripleprice.flight.bean.FlightSearchItem;

public class NusatripConnector {

	public NusatripConnector() {
		try {

			/**
			 * Handle customize header
			 * 
			 * @link{https://github.com/jhy/jsoup/issues/541}
			 */
			System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
			Connection connectionStageOne = Jsoup.connect(
					"http://www.nusatrip.com/flights/search?departDate=20181124&lang=en&departure=DPS&adultNum=2&arrival=CGK");
			connectionStageOne.header("Host", "www.nusatrip.com");
			Document doc = connectionStageOne.get();

			Pattern p = Pattern.compile("key=*.*");
			Matcher m = p.matcher(doc.select("script").html());
			String resultKey = null;
			while (m.find()) {
				System.out.println(m.group());
				resultKey = m.group().replace("key=", "").split("\',")[0];
			}

			RestTemplate restTemplate = new RestTemplate();
			String finalResultKey = restTemplate
					.getForObject("http://nusatrip.com/mobile/flights/result?key=" + resultKey, String.class);

			// System.out.println("finalResultKey : "+finalResultKey);
			System.out.println("resultKey : " + resultKey);

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
			headerParam.add("Host", "nusatrip.com");
			headerParam.add("Cookie",
					"nslang=en; curCode=IDR; __utma=121037335.1558514899.1524916676.1536166458.1536247442.5; __utmz=121037335.1534075353.2.2.utmgclid=EAIaIQobChMIjv_bgrzn3AIVlIloCh1XBw85EAEYASAAEgLKPPD_BwE|utmccn=(not%20set)|utmcmd=(not%20set); nssearchhistory=1%3A%3A%7C%3A%3ADPS%5E%5EBali%2C+Ngurah+Rai+Intl.%5E%5EDenpasar%5E%5EBali%5E%5EIndonesia%7CCGK%5E%5ESoekarno+Hatta%5E%5EJakarta%5E%5EIndonesia%3A%3A20180924%3A%3A%3A%3A1%7C0%3A%3A-1%3B1%3A%3A%7C%3A%3A_JKT%5E%5EAll+Airports%5E%5EJakarta%5E%5EIndonesia%7CSOC%5E%5EAdi+Sumarmo%5E%5ESolo+%7C+Surakarta%5E%5EJawa+Tengah%5E%5EIndonesia%3A%3A20180906%3A%3A%3A%3A1%7C0%3A%3A-1; nsdevice=d; fromcoo=UPSE:mail*:1536159937||; _gac_UA-33251722-1=1.1534075353.EAIaIQobChMIjv_bgrzn3AIVlIloCh1XBw85EAEYASAAEgLKPPD_BwE; __utmc=121037335; __utmb=121037335.13.8.1536249343874; nscartsess=d66c3fc21dbbb6acf17487f6aa66ce81; __utmt=1");
			headerParam.add("Upgrade-Insecure-Requests", "1");
			headerParam.add("Referer", "http://www.nusatrip.com/flights/search");
			headerParam.add("Content-Length", "1146");
			headerParam.add("User-Agent",
					"Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:56.0) Gecko/20100101 Firefox/56.0");
			headerParam.add("Content-Type", "application/x-www-form-urlencoded");
			headerParam.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			headerParam.add("Accept-Language", "en-US,en;q=0.5");
			headerParam.add("Accept-Encoding", "gzip, deflate");
			headerParam.add("Connection", "keep-alive");

			HttpEntity<?> httpEntity = new HttpEntity<Object>(formVars, headerParam);

			ResponseEntity<String> response = restTemplate.exchange("http://nusatrip.com/checkout/booking",
					HttpMethod.POST, httpEntity, String.class);

			String resultString = response.getBody();
			HttpHeaders headers = response.getHeaders();

			// System.out.println(resultString.toString());
			// System.out.println(headers.toString());

		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	private FlightSearchItem getFlighSearchItem() {
		FlightSearchItem flightSearchItem = new FlightSearchItem();
		return flightSearchItem;
	}
}

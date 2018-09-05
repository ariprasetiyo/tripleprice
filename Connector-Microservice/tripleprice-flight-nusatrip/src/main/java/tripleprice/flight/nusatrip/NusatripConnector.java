package tripleprice.flight.nusatrip;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.client.RestTemplate;

public class NusatripConnector {

	/**
	 * http://www.nusatrip.com/flights/search?departDate=20180924&lang=en&departure=DPS&adultNum=2&arrival=CGK
	 * 
	 * http://phptest1.nusadev.com/mobile/flights/result?key=5e892d743b052a9fa6e74aea3b3438f14088ebc5721ee2ec41e350d19f861363ea0742385222dbf04a7da59d1ca712fa
	 */
	public NusatripConnector() {
		try {
			Document doc = Jsoup
					.connect(
							"http://phptest1.nusadev.com/flights/search?departDate=20180924&lang=en&departure=DPS&adultNum=2&arrival=CGK")
					.get();
			Pattern p = Pattern.compile("key=*.*(\',\\s+//feed_url)");
			Matcher m = p.matcher(doc.select("script").html());
			String resultKey = null;
			while (m.find()) {
				resultKey = m.group().replace("key=", "").split("\',")[0];
			}
			
			RestTemplate restTemplate = new RestTemplate();
	        String quote = restTemplate.getForObject("http://phptest1.nusadev.com/mobile/flights/result?key="+resultKey, String.class);
	        
	        System.out.println(quote);

		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}

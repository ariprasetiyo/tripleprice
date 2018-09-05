package scrapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class scrappingTest {

	// @Test
	public void getElementByClassTest() {

		String html = "<html><head><title>Sample Title</title></head>" + "<body>" + "<p>Sample Content</p>"
				+ "<div id='sampleDiv'><a href='www.google.com'>Google</a>" + "<h3><a>Sample</a><h3>" + "</div>"
				+ "<div id='imageDiv' class='header coba hallo'><img name='google' src='google.png' />"
				+ "<img name='yahoo' src='yahoo.jpg' />" + "</div>"
				+ "<div id='imageDiv' class='header coba hallo sasa'><img name='google' src='google.png' />"
				+ "<img name='yahoo' src='yahoo.jpg' />" + "</div>" + "</body></html>";
		Document document = Jsoup.parse(html);

		// a with href
		Elements links = document.select("a[href]");
		System.out.println(links.toString());

		Elements linkss = document.getElementsByClass("coba");
		System.out.println(linkss.toString());

		for (Element link : links) {
			System.out.println("Href: " + link.attr("href"));
			System.out.println("Text: " + link.text());
		}

		// img with src ending .png
		Elements pngs = document.select("img[src$=.png]");

		for (Element png : pngs) {
			System.out.println("Name: " + png.attr("name"));
		}

		// div with class=header
		Element headerDiv = document.select("div.header").first();
		System.out.println("Id: " + headerDiv.id());

		// direct a after h3
		Elements sampleLinks = document.select("h3 > a");

		for (Element link : sampleLinks) {
			System.out.println("Text: " + link.text());
		}
	}

	@Test
	public void javascriptTest() {

		/**
		 * http://phptest1.nusadev.com/mobile/flights/result?key=5e892d743b052a9fa6e74aea3b3438f14088ebc5721ee2ec41e350d19f861363ea0742385222dbf04a7da59d1ca712fa
		 */
		String html = "window.flight_engine = $.viewEngine({ feed_url: 'http://phptest1.nusadev.com' + '/mobile/flights/result?key=5e892d743b052a9fa6e74aea3b3438f14088ebc5721ee2ec41e350d19f861363ea0742385222dbf04a7da59d1ca712fa',     //feed_url: 'http://phptest1.nusadev.com' + '/dummy.json', text_transit: 'Stop', text_transits: 'Stops', partial_load: 'flightWaitList', airline_icon_url: 'http://static1.nusadev.com/static/img/front/V2/icon-flight/', text_direct_flight: 'Direct', item_display : '9999', no_data_selector : '#flight-no-data', currency: currency, uncached_variables:";
		Document document = Jsoup.parse(html);
		Pattern p = Pattern.compile("key=*.*(\',\\s+//feed_url)");
		
		Matcher m = p.matcher(document.html());
		
		String resultKey = null;
		while (m.find()) {
			resultKey = m.group().replace("key=", "").split("\',")[0]; // the whole key ('key = value')
			// System.out.println(m.group(1)); // value only
		}
		System.out.println(resultKey);
	}
}
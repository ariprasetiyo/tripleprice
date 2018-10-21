package tripleprice.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestProperties {

	@Value("${nusatrip.url.flight.search.findkey}")
	String urlFlightSearchFindKey;

	public String getUrlFlightSearchFindKey() {
		// return env.getProperty("mongodb.url");
		return urlFlightSearchFindKey;
	}

	public void setUrlFlightSearchFindKey(String urlFlightSearchFindKey) {
		this.urlFlightSearchFindKey = urlFlightSearchFindKey;
	}

}

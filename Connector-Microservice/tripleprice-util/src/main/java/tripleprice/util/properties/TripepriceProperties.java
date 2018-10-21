package tripleprice.util.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TripepriceProperties {

	@Value("${nusatrip.url.flight.search.get.token}")
	String nusatripUrlFlightSeachGetToken;

	@Value("${nusatrip.url.flight.search.get.list}")
	String nusatripUrlFlightSeachGetList;

	public String getNusatripUrlFlightSeachGetToken() {
		return nusatripUrlFlightSeachGetToken;
	}

	public void setNusatripUrlFlightSeachGetToken(String nusatripUrlFlightSeachGetToken) {
		this.nusatripUrlFlightSeachGetToken = nusatripUrlFlightSeachGetToken;
	}

	public String getNusatripUrlFlightSeachGetList() {
		return nusatripUrlFlightSeachGetList;
	}

	public void setNusatripUrlFlightSeachGetList(String nusatripUrlFlightSeachGetList) {
		this.nusatripUrlFlightSeachGetList = nusatripUrlFlightSeachGetList;
	}

}

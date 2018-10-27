package tripleprice.flight.service;

/**
 * 
 * @author ari.prasetiyo
 *
 */
public interface FlightConnector {
	
	public void start();
	
	public void close();
	
	public String getSearch(Object flightParams);
}

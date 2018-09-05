package tripleprice.flight.bean;

import java.util.Date;
import java.util.List;

public class Segments {
	Date depatureDate;
	Date arrivalDate;
	int totalDuration;
	double totalPrice;
	double discount;
	String promo;
	List<FlightItem> flightItems;
	List<Ssr> ssrs;
}

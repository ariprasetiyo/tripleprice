package tripleprice.aggregator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import tripleprice.flight.enumuration.FlightClassType;
import tripleprice.flight.search.FlightItems;
import tripleprice.flight.search.FlightParams;
import tripleprice.flight.service.FlightService;

@Service
public class AggregatorService {

	private List<FlightService> flightServiceList = new ArrayList<>();
	private final ExecutorService executorService;

	public AggregatorService(ExecutorService executorService, List<FlightService> flightServiceList) {
		this.executorService = executorService;
		this.flightServiceList = flightServiceList;
	}

	/*
	 * final Future<FlightSearchResult> future = completionService .poll(timeout
	 * - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
	 * 
	 */
	public FlightItems getFlightSearch() {

		final FlightParams flightParams = new FlightParams();
		flightParams.setCurrency("IDR");
		flightParams.setDepartureAirportCode("CGK");
		flightParams.setChildrenNum((byte) 0);
		flightParams.setInfantsNum((byte) 0);
		flightParams.setAdultsNum((byte) 1);
		flightParams.setFlightClassType(FlightClassType.ECONOMY);
		flightParams.setArrivalAirportCode("DPS");

		final Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DATE, 30);
		flightParams.setDepatureDate(cal.getTime());

		/*
		 * final FlightService flightService = flightServiceList.get(0);
		 * flightService.flightSearchItem(flightParams);
		 * flightParams.setDepartureAirportCode("JKTA"); final FlightService
		 * flightServiceq = flightServiceList.get(1);
		 * flightServiceq.flightSearchItem(flightParams); final FlightService
		 * flightServiceqa = flightServiceList.get(2);
		 * flightServiceqa.flightSearchItem(flightParams);
		 */
		final List<Future<FlightItems>> listFuture = new ArrayList<Future<FlightItems>>();
		for (short a = 0; a < flightServiceList.size(); a++) {
			final FlightService flightService = flightServiceList.get(a);
			if (flightService == null) {
				continue;
			}

			final Callable<FlightItems> flightItemsTask = new Callable<FlightItems>() {
				@Override
				public FlightItems call() throws Exception {
					return flightService.flightSearchItem(flightParams);
				}
			};
			final Future<FlightItems> flightItemFuture = executorService.submit(flightItemsTask);
			listFuture.add(flightItemFuture);
		}
		return null;
	}
}

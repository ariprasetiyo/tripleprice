package tripleprice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tripleprice.aggregator.AggregatorService;
import tripleprice.beans.TestProperties;
import tripleprice.flight.bean.FlightSearchItem;

/**
 *
 * @author ari-prasetiyo
 */
@Controller
public class LoginController {
	@Autowired
	TestProperties testProperties;

	@Autowired
	AggregatorService aggregatorService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}
		if (logout != null) {
			model.addObject("message", "Logged out from AG successfully.");
		}
		model.setViewName("login/login.html");

		System.out.println("-----------------" + testProperties.getUrlFlightSearchFindKey());

		FlightSearchItem sas = aggregatorService.getFlightSearch();
		return model;
	}
}

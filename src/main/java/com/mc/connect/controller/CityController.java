package com.mc.connect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mc.connect.service.CityService;

/**
 * Controller is ready to be leveraged by Spring MVC to handle web requests.
 * Since the @RestController annotation combines @Controller and @ResponseBody,
 * the web requests return data instead of view which is the requirement for
 * this assignment.
 * 
 * @author aalcamo
 *
 */
@RestController
public class CityController {

	private CityService cityService;

	/**
	 * controller dependency injection
	 * 
	 * @param cityService
	 */
	public CityController(CityService cityService) {
		this.cityService = cityService;
	}

	/**
	 * RESTful endpoint allows caller to determine if they can get from the origin
	 * city to the destination city. If either origin or destination is null or
	 * empty, simply return no.
	 * 
	 * @param origin      city traveling from
	 * @param destination city traveling to
	 * @return
	 */
	@RequestMapping("/connected")
	public String connect(@RequestParam(name = "origin", required = false, defaultValue = "") String origin,
			@RequestParam(name = "destination", required = false, defaultValue = "") String destination) {

		if (origin.isEmpty() || destination.isEmpty())  {
			return "no";
		}
		
		if (cityService.isConnected(origin, destination)) {
			return "yes";
		} else {
			return "no";
		}

	}

}
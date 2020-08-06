package com.mc.connect.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;

import com.mc.connect.model.Graph;

/**
 * Unit tests for our service validate that we load the expected city data, and
 * two known connectivity tests.
 * 
 * @author aalcamo
 *
 */
class CityServiceImplTest {

	private Graph<String> cityGraph;
	private CityService cityService;

	@BeforeEach
	void setUp() throws Exception {
		cityGraph = new Graph<String>();
		cityGraph.addEdge("Boston", "New York");
		cityGraph.addEdge("Philadelphia", "Newark");
		cityGraph.addEdge("Newark", "Boston");
		cityGraph.addEdge("Trenton", "Albany");
		cityService = new CityServiceImpl(new DefaultResourceLoader(), cityGraph);
	}

	@Test
	@DisplayName("test graph data is loaded and retrievex")
	void testLoadAndRetrieveGraphData() {
		String expectedGraph = "New York: Boston Boston <br>Newark: Philadelphia Boston Philadelphia Boston <br>Trenton: Albany Albany <br>Philadelphia: Newark Newark <br>Boston: New York Newark New York Newark <br>Albany: Trenton Trenton <br>";
		String actualGraph = cityService.getGraphData();
		System.out.println("expected graph = [" + expectedGraph + "]");
		System.out.println("actual graph   = [" + actualGraph + "]");
		assertEquals(actualGraph, expectedGraph);
	}

	@Test
	@DisplayName("test two cities are connected")
	void testConnected() {
		String originCity = "Boston";
		String destinationCity = "Newark";
		System.out.println("test connection between " + originCity + " and " + destinationCity);
		assertTrue(cityService.isConnected(originCity, destinationCity));
	}

	@Test
	@DisplayName("test two cities are not connected")
	void testNotConnected() {
		String originCity = "Philadelphia";
		String destinationCity = "Albany";
		System.out.println("test connection between " + originCity + " and " + destinationCity);
		assertFalse(cityService.isConnected(originCity, destinationCity));
	}

}

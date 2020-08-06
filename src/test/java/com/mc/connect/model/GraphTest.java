package com.mc.connect.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;

import com.mc.connect.service.CityServiceImpl;

class GraphTest {

	private Graph<String> cityGraph;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		cityGraph = new Graph<String>();
		cityGraph.addEdge("Boston", "New York");
		cityGraph.addEdge("Philadelphia", "Newark");
		cityGraph.addEdge("Newark", "Boston");
		cityGraph.addEdge("Trenton", "Albany");
		String expectedGraph = "New York: Boston <br>Newark: Philadelphia Boston <br>Trenton: Albany <br>Philadelphia: Newark <br>Boston: New York Newark <br>Albany: Trenton <br>";
		System.out.println("expected graph = [" + expectedGraph + "]");
		System.out.println("actual graph   = [" + cityGraph + "]");
		assertEquals(cityGraph.toString(), expectedGraph);
	}

}

package com.mc.connect.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for our controller simply validate that if we attempt to pass an
 * empty origin or empty destination city, the result will be no connectivity.
 * 
 * @author aalcamo
 *
 */
class CityControllerTest {

	CityController controller;

	@BeforeEach
	void setUp() throws Exception {
		controller = new CityController(null);
	}

	@Test
	void testEmptyOrigin() {
		assertEquals("no", controller.connect("", "destination"));
	}

	@Test
	void testEmptyDestination() {
		assertEquals("no", controller.connect("origin", ""));
	}

}

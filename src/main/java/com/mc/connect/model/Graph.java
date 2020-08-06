package com.mc.connect.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.springframework.stereotype.Component;

/**
 * Graph data structure used to read and maintain our cities and their
 * destinations, and determine if you can get from origin to destination.
 * 
 * @author aalcamo
 *
 * @param <T>
 */

@Component
public class Graph<T> {

	/**
	 * Map contains each city along with that city's destinations
	 */
	private Map<T, List<T>> map = new HashMap<>();

	/**
	 * Add a vertex to our graph.
	 * 
	 * @param s
	 */
	public void addVertex(T s) {
		map.put(s, new LinkedList<T>());
	}

	/**
	 * Add an edge between origin and destination vertices. We will treat edges as
	 * bidirectional since a traveler may always travel from the destination to the
	 * origin via the same road.
	 * 
	 * @param origin      origin city
	 * @param destination destination city
	 */
	public void addEdge(T origin, T destination) {

		if (!map.containsKey(origin))
			addVertex(origin);

		if (!map.containsKey(destination))
			addVertex(destination);

		map.get(origin).add(destination);
		map.get(destination).add(origin);
	}

	/**
	 * Determine if a traveler may travel from the origin city to the destination
	 * city based on the available roads.
	 * 
	 * @param origin      origin city
	 * @param destination destination city
	 * @return true if roads exist to allow a traveler to travel from the origin
	 *         city to the destination city. false otherwise
	 */
	public boolean isConnected(T origin, T destination) {

		// create a queue to perform city traversal
		Queue<T> queue = new LinkedList<T>();

		// maintain list of cities we have checked
		List<T> checked = new ArrayList<T>();

		// origin city must be in our graph
		if (!map.containsKey(origin)) {
			return false;
		}

		// begin with your origin city
		queue.add(origin);
		checked.add(origin);

		// traverse cities to see if destination can be reached
		while (!queue.isEmpty()) {

			// pop off the current city
			T currentCity = queue.remove();

			// have we reached our destination?
			if (currentCity.equals(destination)) {
				return true;
			}

			// now add current city's destinations to the queue
			List<T> list = map.get(currentCity);

			for (T city : list) {
				if (!checked.contains(city)) {
					queue.add(city);
					checked.add(city);
				}
			}

		}

		// destination was not reached
		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (T v : map.keySet()) {
			builder.append(v.toString() + ": ");
			for (T w : map.get(v)) {
				builder.append(w.toString() + " ");
			}
			builder.append("<br>");
		}

		return (builder.toString());
	}
}

package com.mc.connect.service;

public interface CityService {

	/**
	 * Convenience method to display our city connection data.
	 * 
	 * @return graph data contained in external resource
	 */
	public String getGraphData();

	/**
	 * Determine if a path exists between two cities
	 * 
	 * @param origin      city of origin
	 * @param destination destination city
	 * @return true if there is connectivity between origin and destination, false
	 *         otherwise.
	 */
	public boolean isConnected(String origin, String destination);

}

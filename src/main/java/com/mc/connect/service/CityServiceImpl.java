package com.mc.connect.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.mc.connect.model.Graph;

/**
 * Service to retrieve collection of roads each of which represents a conduit
 * between two cities. Leverages a data structure allowing the caller to
 * determine possible connectivity between two cities.
 * 
 * @author aalcamo
 *
 */
@Service
public class CityServiceImpl implements CityService {

	private Graph<String> graph;
	private ResourceLoader resourceLoader;

	/**
	 * Retrieve resource data from the classpath.
	 * 
	 * @param classpathResource name of city data file
	 */
	private void loadData(String classpathResource) {
		Resource resource = resourceLoader.getResource("classpath:" + classpathResource);
		InputStream in;
		BufferedReader reader;
		try {
			in = resource.getInputStream();
			reader = new BufferedReader(new InputStreamReader(in));
			while (true) {
				String line = reader.readLine();
				if (line != null) {
					String[] city = line.split(",");
					graph.addEdge(city[0].trim(), city[1].trim());
				} else {
					break;
				}
				// System.out.println(line);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Use constructor injection for loading resource data.
	 * 
	 * @param resourceLoader allows us to retrieve external resources via resource
	 *                       path
	 * @param graph          data structure maintains our city data
	 */
	public CityServiceImpl(ResourceLoader resourceLoader, Graph<String> graph) {
		this.graph = graph;
		this.resourceLoader = resourceLoader;
		loadData("city.txt");

	}

	@Override
	public String getGraphData() {
		return this.graph.toString();
	}

	@Override
	public boolean isConnected(String origin, String destination) {
		return this.graph.isConnected(origin, destination);
	}

}

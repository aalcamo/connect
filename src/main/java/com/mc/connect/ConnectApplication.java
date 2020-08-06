package com.mc.connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MasterCard Code Challenge main application determines if two cities are
 * connected. Two cities are considered connected if there's a series of roads
 * that can be traveled from one city to another. The list of roads will be
 * available in a file. The file contains a list of city pairs (one pair per
 * line, comma separated), which indicates that there's a road between those
 * cities.
 * 
 * @author aalcamo
 *
 */
@SpringBootApplication
public class ConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectApplication.class, args);
	}

}

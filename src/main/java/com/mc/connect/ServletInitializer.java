package com.mc.connect;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Initializer is an extension of the WebApplicationInitializer which runs a
 * Spring application from a traditional war archive. We extend this to override
 * the configure method and configure our application.
 * 
 * @author aalcamo
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ConnectApplication.class);
	}

}

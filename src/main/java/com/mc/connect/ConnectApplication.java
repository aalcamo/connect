package com.mc.connect;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
@EnableSwagger2
public class ConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectApplication.class, args);
	}

	ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Connect API Documentation")
            .description("The Connect API allows the user to determine if two cities are considered connected. This is determined by examining if there’s a series of roads that can be traveled from one city to another.")
            .contact(new Contact("Anthony Alcamo", "", "aalcamo@gofurthercorp.com"))
            .build();
    }
	/**
	 * Docket is a Springfox’s primary configuration mechanism for Swagger.
	 * DocumentationTyupe.SWAGGER_2 tells the Docket bean that we are using version
	 * 2 of the Swagger specification. select() creates a builder, apis() define the
	 * classes to be included, paths() allows us to define specific methods to be
	 * included.
	 * 
	 * @return
	 * @throws IOException
	 * @throws XmlPullParserException
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.mc.connect.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
}

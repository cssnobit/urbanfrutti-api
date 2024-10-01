package com.urbanfrutti.urbanfrutti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


// @PropertySource(value = "classpath:application.properties")
@SpringBootApplication
public class UrbanfruttiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbanfruttiApplication.class, args);
	}

}

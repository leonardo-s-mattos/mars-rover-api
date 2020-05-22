package com.mattos.marsrover;

import com.mattos.marsrover.application.service.RoverControlService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class MarsRoverApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverApiApplication.class, args);
	}

}

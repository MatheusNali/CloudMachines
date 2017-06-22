package com.cloudmachines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudmachines.controller.VerLogController;

@SpringBootApplication
public class CloudMachinesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudMachinesApplication.class, args);
	}
}

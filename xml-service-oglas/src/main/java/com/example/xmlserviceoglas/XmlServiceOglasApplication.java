package com.example.xmlserviceoglas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class XmlServiceOglasApplication {

	public static void main(String[] args) {
		SpringApplication.run(XmlServiceOglasApplication.class, args);
	}

}

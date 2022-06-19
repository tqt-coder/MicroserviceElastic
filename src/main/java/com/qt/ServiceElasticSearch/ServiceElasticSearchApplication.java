package com.qt.ServiceElasticSearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ServiceElasticSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceElasticSearchApplication.class, args);
	}

}

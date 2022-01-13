package com.coyote.big_city_library.rest_client_public;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RestClientPublicApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientPublicApplication.class, args);
	}

}

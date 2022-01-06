package com.coyote.big_city_library.rest_client_public;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RestClientPublicApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientPublicApplication.class, args);
	}

}

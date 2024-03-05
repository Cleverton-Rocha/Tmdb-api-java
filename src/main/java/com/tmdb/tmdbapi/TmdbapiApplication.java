package com.tmdb.tmdbapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {
		@Server(url = "/", description = "Default Server URL") })

@SpringBootApplication
@EnableFeignClients
public class TmdbapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmdbapiApplication.class, args);
	}

}

package com.example.scoresapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ScoresAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScoresAppApplication.class, args);
	}

	/*@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	@Bean
	public CommandLineRunner run(WebClient.Builder webClientBuilder) {
		return args -> {
			WebClient webClient = webClientBuilder.build();
			String response = webClient.get()
					.uri("http://localhost:8080/api/teams/logo")
					.retrieve()
					.bodyToMono(String.class)
					.block();
			System.out.println(response);
		};
	}*/
}

package br.example.matheusf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SenderAppConfig {
	
	public static void main(String[] args) {
		SpringApplication.run(SenderAppConfig.class, args);
	}
}

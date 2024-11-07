package com.nunosousa.kafkaDemo;

import com.nunosousa.kafkaDemo.ports.MainMenuPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaDemoApplication {

    public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(MainMenuPort mainMenuPort) {
		return (args) -> {
			mainMenuPort.start();
		};
	}

}

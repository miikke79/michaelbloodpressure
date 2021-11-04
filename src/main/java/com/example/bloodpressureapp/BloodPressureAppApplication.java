package com.example.bloodpressureapp;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bloodpressureapp.domain.Bloodpressure;
import com.example.bloodpressureapp.domain.Bloodpressurerepository;

@SpringBootApplication
public class BloodPressureAppApplication {
	private static final Logger log = LoggerFactory.getLogger(BloodPressureAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BloodPressureAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(Bloodpressurerepository repository) {
		return (args) -> {
			log.info("save a couple of records");
			repository.save(new Bloodpressure(80, 65, 65, LocalDate.of(2021, 01, 01)));
			repository.save(new Bloodpressure(90, 75, 75, LocalDate.of(2020, 12, 28)));
			
			log.info("fetch all records");
			for (Bloodpressure bloodpressure : repository.findAll()) {
				log.info(bloodpressure.toString());
			}

		};
	}
	
}

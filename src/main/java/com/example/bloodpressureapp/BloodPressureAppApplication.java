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
import com.example.bloodpressureapp.domain.Userrepository;

import com.example.bloodpressureapp.domain.User;


@SpringBootApplication
public class BloodPressureAppApplication {
	private static final Logger log = LoggerFactory.getLogger(BloodPressureAppApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BloodPressureAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(Bloodpressurerepository repository, Userrepository urepository) {
		return (args) -> {
			log.info("save a couple of records");
			repository.save(new Bloodpressure(90, 65, 65, LocalDate.of(2021, 11, 05)));
			repository.save(new Bloodpressure(110, 75, 75, LocalDate.of(2021, 10, 29)));
			repository.save(new Bloodpressure(115, 67, 65, LocalDate.of(2021, 10, 22)));
			repository.save(new Bloodpressure(95, 75, 75, LocalDate.of(2021, 10, 15)));
			repository.save(new Bloodpressure(70, 65, 65, LocalDate.of(2021, 10, 07)));
			repository.save(new Bloodpressure(110, 77, 90, LocalDate.of(2021, 10, 01)));
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all records");
			for (Bloodpressure bloodpressure : repository.findAll()) {
				log.info(bloodpressure.toString());
			}

		};
	}
	
}

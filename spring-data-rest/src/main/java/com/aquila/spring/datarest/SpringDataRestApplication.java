package com.aquila.spring.datarest;

import com.aquila.spring.datarest.model.WebsiteUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.aquila.spring.datarest.repository.UserRepository;

@SpringBootApplication
public class SpringDataRestApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringDataRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new WebsiteUser("Jack", "test1@test.com"));
			repository.save(new WebsiteUser("Chloe", "test2@test.com"));
			repository.save(new WebsiteUser("Kim", "test3@test.com"));
			repository.save(new WebsiteUser("David", "test4@test.com"));
			repository.save(new WebsiteUser("Michelle", "test5@test.com"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			repository.findAll().forEach(site -> {
				log.info(site.toString());
			});
			log.info("");
		};
	}

}

package com.nilam.spring.boot.crud.rest.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nilam.spring.boot.crud.rest.entity.Student;
import com.nilam.spring.boot.crud.rest.repository.StudentRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.nilam.*")
@EnableJpaRepositories(basePackages = {"com.nilam.spring.boot.crud.rest.repository"})
@EntityScan("com.nilam.spring.boot.crud.rest.entity")
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
public class Main {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(StudentRepository repository) {
	    return (args) -> {
	      // save a few customers
	      repository.save(new Student("Jack", "jack@gmail.com", "Pune"));
	      repository.save(new Student("Chloe", "Chloe@gmail.com", "Mumbai"));
	      repository.save(new Student("Kim", "kim@gmail.com", "Pune"));
	      repository.save(new Student("David", "David@gmail.com", "Chennai"));
	      repository.save(new Student("Michelle", "Michelle@gmail.com", "Banglore"));
	      
	      /*
	      // fetch all customers
	      log.info("Customers found with findAll():");
	      log.info("-------------------------------");
	      for (Customer customer : repository.findAll()) {
	        log.info(customer.toString());
	      }
	      log.info("");

	      // fetch an individual customer by ID
	      Customer customer = repository.findById(1L);
	      log.info("Customer found with findById(1L):");
	      log.info("--------------------------------");
	      log.info(customer.toString());
	      log.info("");

	      // fetch customers by last name
	      log.info("Customer found with findByLastName('Bauer'):");
	      log.info("--------------------------------------------");
	      repository.findByLastName("Bauer").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	      // for (Customer bauer : repository.findByLastName("Bauer")) {
	      //  log.info(bauer.toString());
	      // }
	      log.info("");
	      */
	    };
	  }
}

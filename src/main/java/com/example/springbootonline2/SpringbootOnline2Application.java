package com.example.springbootonline2;

import com.example.springbootonline2.domain.Employee;
import com.example.springbootonline2.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootOnline2Application {

	@Bean
	public CommandLineRunner init(EmployeeRepository employeeRepository) {
		return (args -> {
			employeeRepository.save(new Employee("John", "Doe"));
			employeeRepository.save(new Employee("Sammy", "Doe"));
			employeeRepository.save(new Employee("James", "Doe"));
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootOnline2Application.class, args);
	}

}

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
			Employee employee = new Employee();
			employee.setId(1);
			employee.setFirstName("john");
			employee.setLastName("Doe");
			employeeRepository.save(employee);
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootOnline2Application.class, args);
	}

}

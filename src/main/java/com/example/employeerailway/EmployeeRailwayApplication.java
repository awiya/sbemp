package com.example.employeerailway;

import com.example.employeerailway.model.Department;
import com.example.employeerailway.model.Employee;
import com.example.employeerailway.repository.DepartmentRepo;
import com.example.employeerailway.repository.EmployeeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EmployeeRailwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRailwayApplication.class, args);
	}

	@Bean
	CommandLineRunner start(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo){
		return args -> {
			employeeRepo.saveAll(
				List.of(
						Employee.builder().firstName("ayoub").lastName("idihia").email("ayoub@gmail.com").build(),
						Employee.builder().firstName("jad").lastName("idihia").email("jad@gmail.com").build(),
						Employee.builder().firstName("judia").lastName("idihia").email("judia@gmail.com").build()
				)
			);
			employeeRepo.findAll().forEach(System.out::println);
			departmentRepo.saveAll(
					List.of(

							Department.builder().name("informatique").code("IT").address("it@idihia.com").build(),
							Department.builder().name("resources humaines").code("RH").address("rh@idihia.com").build(),
							Department.builder().name("infrastructure").code("INFRA").address("infra@idihia.com").build()
					)
			);
			departmentRepo.findAll().forEach(System.out::println);
		};
	}

}

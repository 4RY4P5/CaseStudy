package com.example.loanService_r2dbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "LoanDetails", version = "1.0", description = "Documentation APIs v1.0"))

public class LoanServiceR2dbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanServiceR2dbcApplication.class, args);
	}

}

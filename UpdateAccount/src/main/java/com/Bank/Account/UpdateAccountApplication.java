package com.Bank.Account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "updateAccount", version = "1.0", description = "Documentation APIs v1.0"))
public class UpdateAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpdateAccountApplication.class, args);
	}

}

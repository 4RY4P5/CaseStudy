package com.example.loanService_r2dbc.service;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.loanService_r2dbc.model.Loan;
import com.example.loanService_r2dbc.repo.LoanRepo;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class ServiceTest {

	@Mock
	LoanRepo repo;
	
	  @InjectMocks
	LoanServiceImpl service;
	
	@BeforeEach
	public void setup() {
		Mockito.when(repo.findByCustomerId(1)).thenReturn(Flux.just(new Loan(1,"car",100000.0,LocalDate.of(2020, 03, 05),2.3,4,1)));
	}
	
	@Test
	public void testGetAllLoan() {
		
		StepVerifier.create(service.getAllLoan(1))
		.expectNextCount(2)
		.expectComplete().verify();
	}
}

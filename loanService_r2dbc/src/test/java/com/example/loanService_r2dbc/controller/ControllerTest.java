package com.example.loanService_r2dbc.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.loanService_r2dbc.model.Loan;
import com.example.loanService_r2dbc.model.ResponseMsg;
import com.example.loanService_r2dbc.service.LoanService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {


	@Autowired
	WebTestClient webTestClient;
	
	
	@MockBean
	LoanService loanService;
	
	@Test
	public void getAllLoanTest() {
		List<Loan> testList= new ArrayList<>();
		//String loanId, String loanType, double amount, LocalDate date, double rateOfInterest, double duration,
		//String customerId
		testList.add(new Loan(1,"car",100000.0,LocalDate.of(2020, 03, 05),2.3,4,1));
		testList.add(new Loan(2,"housing",750000.0,LocalDate.of(2019, 10, 22),1.5,2,2));
		
		Mockito.when(loanService.getAllLoan(1)).thenReturn(Flux.fromIterable(testList));
		
		webTestClient.get()
			.uri("loanservice/1/loan").exchange()
			.expectStatus().isOk();
	}
	
	@Test
	public void getLoanTest() {
		Loan l1=new Loan(1,"housing",750000.0,LocalDate.of(2019, 10, 22),1.5,2,1);
		
		Mockito.when(loanService.getLoan(1)).thenReturn(Mono.just(l1));
		
		webTestClient.get()
			.uri("loanservice/1/loan/1").exchange()
			.expectStatus().isOk();
	}
	
	
	  @Test public void createLoanTest() {
	  
	  Loan l1=new Loan(1,"housing",750000.0,LocalDate.of(2019, 10, 22),1.5,2,1);
	  
	  Mockito.when(loanService.newLoan(l1)).thenReturn(Mono.just(l1));
	  
	  webTestClient.post().uri("loanservice/1/loan") .body(Mono.just(l1), Loan.class)
	  .exchange().expectBody(ResponseMsg.class);
	  
	  }
	 
}

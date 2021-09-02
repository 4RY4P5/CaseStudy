package com.example.loanService_r2dbc.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loanService_r2dbc.model.Loan;
import com.example.loanService_r2dbc.model.ResponseMsg;
import com.example.loanService_r2dbc.service.LoanService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("loanservice/{customerId}/loan")
public class LoanController {

	@Autowired
	LoanService loanService;
	
	@GetMapping
	public Flux<Loan> getAllLoan(@PathVariable long customerId){
		return loanService.getAllLoan(customerId);
	}
	
	@GetMapping("/{loanId}")
	public Mono<Loan> getLoan(@PathVariable long loanId){
		return loanService.getLoan(loanId);
	}
	
	@PostMapping
	public Mono<ResponseEntity<ResponseMsg>> applyLoan(@PathVariable long customerId,@RequestBody Loan loan)throws URISyntaxException
	{
		loan.setCustomerId(customerId);
		Mono<Loan> res=loanService.newLoan(loan);
		StringBuilder locationStr = new StringBuilder();
		res.subscribe(e -> locationStr.append("http://localhost:8080/"+customerId+"/loan/").append(e.getLoanId()));
		
		URI location = new URI(locationStr.toString());
		
		return Mono.just(ResponseEntity.created(location).body(this.getResponse(loan.getLoanId(), "New Loan Added")));

	}
	
	private ResponseMsg getResponse(long id, String message) {
		ResponseMsg response = new ResponseMsg();
		response.setId(id);
		response.setStatus(HttpStatus.OK.name());
		response.setMessage(message);
		return response;
	}
}

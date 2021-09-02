package com.example.loanService_r2dbc.service;

import com.example.loanService_r2dbc.model.Loan;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanService {

	public Flux<Loan> getAllLoan(long customerId);
	public Mono<Loan> getLoan(long loanId);
	public Mono<Loan> newLoan(Loan loan);
}

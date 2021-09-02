package com.example.loanService_r2dbc.repo;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.loanService_r2dbc.model.Loan;

import reactor.core.publisher.Flux;



public interface LoanRepo extends ReactiveCrudRepository<Loan,Long>{

	
	public Flux<Loan> findByCustomerId(long customerId);
	
}

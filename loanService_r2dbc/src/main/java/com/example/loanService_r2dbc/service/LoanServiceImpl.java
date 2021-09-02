package com.example.loanService_r2dbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanService_r2dbc.model.Loan;
import com.example.loanService_r2dbc.repo.LoanRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanRepo loanRepo;

	@Override
	public Flux<Loan> getAllLoan(long customerId) {
		// TODO Auto-generated method stub
		return loanRepo.findByCustomerId(customerId);
	}

	@Override
	public Mono<Loan> getLoan(long loanId) {
		// TODO Auto-generated method stub
		return loanRepo.findById(loanId);
		
	}

	@Override
	public Mono<Loan> newLoan(Loan loan) {
		// TODO Auto-generated method stub
		return loanRepo.save(loan);
	}
	
	
	
	
	

}

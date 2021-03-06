package com.Bank.Account.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bank.Account.Repository.AccountRepository;
import com.Bank.Account.model.BankAccount;

import reactor.core.publisher.Mono;
@Service
public  class updateAccountServiceImpl implements updateAccountService{
	
	@Autowired
	AccountRepository accRepo;

	@Override
	public Mono<Boolean> updateAccount(BankAccount account) {
		try {
			accRepo.save(account).block();
		}catch(Exception e) {
			return Mono.just(Boolean.FALSE);
		}
		return Mono.just(Boolean.TRUE);
	}


	

}

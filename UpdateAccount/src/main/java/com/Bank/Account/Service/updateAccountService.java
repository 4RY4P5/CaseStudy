package com.Bank.Account.Service;

import com.Bank.Account.model.BankAccount;

//import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface updateAccountService {

	public Mono<Boolean> updateAccount(BankAccount account);

}

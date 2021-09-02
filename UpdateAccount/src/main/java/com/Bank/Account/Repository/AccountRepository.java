package com.Bank.Account.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.Bank.Account.model.BankAccount;


public interface AccountRepository extends ReactiveCrudRepository<BankAccount, Long>{
}

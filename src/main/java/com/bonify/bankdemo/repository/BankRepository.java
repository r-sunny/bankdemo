package com.bonify.bankdemo.repository;

import com.bonify.bankdemo.model.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, Long> {

     Bank getBankByIdentifier(String identifier);
}

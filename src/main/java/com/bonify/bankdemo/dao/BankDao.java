package com.bonify.bankdemo.dao;

import com.bonify.bankdemo.model.Bank;
import com.bonify.bankdemo.repository.BankRepository;
import java.util.List;

/**
 *  A class for handling the DAO operations of {@link Bank}.
 */
public class BankDao {

    BankRepository bankRepository;

    public BankDao(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    /**
     * Adds a list of banks to the database.
     * @param bankList details of the banks to add     *
     */
    public void addBank(List<String> bankList){

        String[] bankDetails;

        for (String bank : bankList) {

            bankDetails = bank.split(";");
            Bank bankObj = new Bank();
            bankObj.setName(bankDetails[0]);
            bankObj.setIdentifier(bankDetails[1]);
            bankRepository.save(bankObj);
        }
    }
}

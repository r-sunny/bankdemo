package com.bonify.bankdemo;

import com.bonify.bankdemo.dao.BankDao;
import com.bonify.bankdemo.model.Bank;
import com.bonify.bankdemo.parser.CsvParser;
import com.bonify.bankdemo.repository.BankRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankdemoApplication {

    static BankRepository bankRepository;
    static String bankIdentifier;

    public BankdemoApplication(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public static void main(String[] args) {

        SpringApplication.run(BankdemoApplication.class, args);

        CsvParser csvParser = new CsvParser();
        bankIdentifier = "10040000";

        BankDao bankDao = new BankDao(bankRepository);
        bankDao.addBank(csvParser.parseCsvFile());

        Bank bank = bankRepository.getBankByIdentifier(bankIdentifier);
        System.out.println("Bank name with identifier "+bankIdentifier+" is " +bank.getName());
    }
}

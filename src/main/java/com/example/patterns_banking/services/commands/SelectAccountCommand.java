package com.example.patterns_banking.services.commands;

import com.example.patterns_banking.models.Account;
import com.example.patterns_banking.models.Customer;
import com.example.patterns_banking.repositories.IAccountRepository;
import com.example.patterns_banking.repositories.ICustomerRepository;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class SelectAccountCommand implements ICommand<Account>{

    private final IAccountRepository accountRepository;

    //private final ICustomerRepository customerRepository;

    public SelectAccountCommand(IAccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;

    }

    @Override
    public Account execute() {

        List<Account> accountOptional = accountRepository.findAll();

        if (accountOptional.isEmpty()) {
            throw new RuntimeException("Account not found");
        }

        ListIterator<Account> account = accountOptional.listIterator();


        return account.next();
    }
}

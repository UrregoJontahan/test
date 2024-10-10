package com.technical_test.application.services;

import com.technical_test.domain.product.account.Account;
import com.technical_test.infrastructure.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        // Cambiar a getTypeAccount() en lugar de getNumberAccount()
        account.setNumberAccount(Account.generateAccountNumber(account.getTypeAccount()));
        return accountRepository.save(account);
    }

    public void deactivateAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.deactivate();
        accountRepository.save(account);
    }

    public void updateBalance(Long accountId, BigDecimal amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.updateBalance(amount);
        accountRepository.save(account);
    }

    public void cancelAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));
        account.cancel();
        accountRepository.save(account);
    }
}

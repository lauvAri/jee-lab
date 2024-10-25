package org.example.lab.service;

import org.example.lab.persistence.AccountDao;
import org.example.lab.domain.Account;
import org.example.lab.persistence.impl.AccountDaoImpl;

public class AccountService {

    private AccountDao accountDao;

    public AccountService() {
        this.accountDao = new AccountDaoImpl();
    }
    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountDao.getAccountByUsernameAndPassword(account);
    }
}

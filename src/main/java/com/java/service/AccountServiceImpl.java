package com.java.service;

import com.java.dao.AccountDao;

public class AccountServiceImpl implements AccountService{

    private AccountDao ad;

    public AccountDao getAd() {
        return ad;
    }

    public void setAd(AccountDao ad) {
        this.ad = ad;
    }

    @Override
    public void account(String in, String out, Double money) {
        ad.out(out,money);
        //int a= 10/0;
        ad.in(in,money);
    }
}

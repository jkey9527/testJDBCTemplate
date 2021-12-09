package com.java.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    public void in(String name, Double money) {
        getJdbcTemplate().update("update accounts set money=money+? where name=?",money,name);
    }

    public void out(String name, Double money) {
        getJdbcTemplate().update("update accounts set money=money-? where name=?",money,name);
    }
}

package com.depwypbal.deposit.model;

import javax.persistence.*;

@Entity
public class Deposit {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private long deposit;
    private long balans;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getBalans() {
        return balans;
    }

    public void setBalans(long balans) {
        this.balans = balans;
    }

    public Deposit() {
    }

    public Deposit(long deposit) {
        this.deposit = deposit;
    }

}

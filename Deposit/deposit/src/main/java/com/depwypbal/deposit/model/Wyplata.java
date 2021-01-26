package com.depwypbal.deposit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Wyplata {
    @Id
    @GeneratedValue
    private Long id;

    private long wyplata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getWyplata() {
        return wyplata;
    }

    public void setWyplata(long wyplata) {
        this.wyplata = wyplata;
    }

    public Wyplata() {
    }

    public Wyplata(long wyplata) {
        this.wyplata = wyplata;
    }
}

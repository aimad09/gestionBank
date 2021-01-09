package com.example.gestionbank.models;

public class Account {
    private double amount = 50;
    private String name ;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double Debit(double amount) {
        if(amount > this.amount)
            return -1;
        else {
            this.amount =this.amount - amount;
        }
        return amount;
    }

    public double Credit(double amount){
        this.amount =this.amount + amount;
        return amount;
    }



}

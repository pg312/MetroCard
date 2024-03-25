package com.example.geektrust.model;

public class Metrocard {

    private final String cardNumber;

    private int balance;

    public Metrocard(String cardNumber, int balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}

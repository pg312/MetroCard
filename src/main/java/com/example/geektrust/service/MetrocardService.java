package com.example.geektrust.service;

import com.example.geektrust.model.Metrocard;

import java.util.HashMap;

public class MetrocardService  {

    private final HashMap<String, Metrocard> metrocardHashMap;

    public MetrocardService(){
        this.metrocardHashMap = new HashMap<>();
    }


    public void addCard(String cardNumber, int balance) {
        Metrocard metrocard = new Metrocard(cardNumber,balance);
        metrocardHashMap.put(cardNumber, metrocard);
    }

    public Metrocard getCard(String cardNumber){
        return metrocardHashMap.get(cardNumber);
    }
}

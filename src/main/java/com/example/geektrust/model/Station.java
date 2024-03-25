package com.example.geektrust.model;

import java.util.TreeMap;

public class Station {

    private final String stationName;

    private int amountCollected;

    private int discountGiven;

    private TreeMap<String, Integer> passengerCountByType;

    public Station(String stationName) {
        this.stationName = stationName;
        this.amountCollected = 0;
        this.discountGiven = 0;
        this.passengerCountByType = new TreeMap<>();
    }

    public TreeMap<String, Integer> getPassengerCountByType() {
        return passengerCountByType;
    }


    public void updateTotalamountCollected(int charges) {
        amountCollected += charges;
    }

    public String getStationName() {
        return stationName;
    }

    public int getAmountCollected() {
        return amountCollected;
    }

    public int getDiscountGiven() {
        return discountGiven;
    }

    public void updateDiscount(int discountGiven) {
        this.discountGiven += discountGiven;
    }
}
package com.example.geektrust.service;

import com.example.geektrust.model.Station;

import java.util.Collections;
import java.util.Map;

public class PrintService {

    public void printDetails(Station[] stations){
        for (Station station :
                stations) {
            System.out.print("TOTAL_COLLECTION"+" "+station.getStationName() +" "+station.getAmountCollected()+ " "+station.getDiscountGiven()+"\n");
            System.out.println("PASSENGER_TYPE_SUMMARY");
            station.getPassengerCountByType().entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(passenger -> {System.out.println(passenger.getKey()+" "+passenger.getValue());
            });
        }
    }
}

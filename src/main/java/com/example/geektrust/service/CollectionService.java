package com.example.geektrust.service;

import com.example.geektrust.model.Metrocard;
import com.example.geektrust.model.Station;

import java.util.Set;

public class CollectionService {

    private PricingDetails pricingDetails;

    CollectionService(){
        pricingDetails = new PricingDetails();
    }
    public void updateTotalAmountCollected(Station station, Metrocard metrocard, String passengerType, Set<String> visitedPassenger){
        int charges = pricingDetails.getPriceForPassenger(passengerType);
        int balance = metrocard.getBalance();
        if(visitedPassenger.contains(metrocard.getCardNumber())){
            charges = (int) (charges * 0.5);
            station.updateDiscount( charges);
            visitedPassenger.remove(metrocard.getCardNumber());
        }
        else
            visitedPassenger.add(metrocard.getCardNumber());
        if(balance > charges)
            balance -= charges;
        else{
            charges += (charges-balance) * 0.02;
            balance = 0;
        }
        station.updateTotalamountCollected(charges);
        metrocard.setBalance(balance);
    }
}

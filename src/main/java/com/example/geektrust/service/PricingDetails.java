package com.example.geektrust.service;

import java.security.InvalidParameterException;
import java.util.HashMap;

public class PricingDetails {
    private final HashMap<String, Integer> pricingDetails;

    public PricingDetails(){
        pricingDetails = new HashMap<>();
        pricingDetails.put("ADULT", 200);
        pricingDetails.put("SENIOR_CITIZEN", 100);
        pricingDetails.put("KID", 50);
    }

    public int getPriceForPassenger(String passengerType){
        if(pricingDetails.get(passengerType) == null)
            throw new InvalidParameterException("INVALID_INPUT");
        return pricingDetails.get(passengerType);
    }

}

package com.example.geektrust.service;

import com.example.geektrust.model.Metrocard;
import com.example.geektrust.model.Station;

import java.security.InvalidParameterException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class StationService {

    private final Station[] stations = new Station[2];

    private final Set<String> visitedPassenger;

    private final CollectionService collectionService;



    public StationService(){
        stations[0] = new Station("CENTRAL");
        stations[1] = new Station("AIRPORT");
        this.visitedPassenger = new HashSet<>();

        collectionService = new CollectionService();
    }
    private Station getStation(String stationName) {
        if(stationName.equals("CENTRAL"))
            return stations[0];
        else if(stationName.equals("AIRPORT"))
           return stations[1];
        else
            throw new InvalidParameterException("INVALID_INPUT");
    }

    public Station[] getStations(){
        return stations;
    }
    public void checkInPassengerToStation(String stationName, Metrocard metrocard, String passengerType) {
        Station station = getStation(stationName);
        updatePassengerCount(station,passengerType);
        collectionService.updateTotalAmountCollected(station,metrocard,passengerType,visitedPassenger);
    }

    private void updatePassengerCount(Station station,  String passengerType) {
        TreeMap<String, Integer> passengerCount = station.getPassengerCountByType();
        passengerCount.merge(passengerType,1, Integer::sum);

    }


}

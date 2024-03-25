package com.example.geektrust;

import com.example.geektrust.model.Metrocard;
import com.example.geektrust.service.MetrocardService;
import com.example.geektrust.service.PrintService;
import com.example.geektrust.service.StationService;

import java.security.InvalidParameterException;

public class ProcessInput {

    MetrocardService metrocardService = new MetrocardService();
    StationService stationService = new StationService();
    PrintService printService = new PrintService();

    public void parseAndAct(String [] input){
        switch (input[0]) {
            case "BALANCE":
                metrocardService.addCard(input[1], Integer.parseInt(input[2]));
                break;
            case "CHECK_IN":
                Metrocard metrocard = metrocardService.getCard(input[1]);
                String passengerType = input[2];
                String stationName = input[3];
                stationService.checkInPassengerToStation(stationName, metrocard, passengerType);
                break;
            case "PRINT_SUMMARY":
                printService.printDetails(stationService.getStations());
                break;
            default:
                throw new InvalidParameterException("INVALID_INPUT");
        }

    }
}

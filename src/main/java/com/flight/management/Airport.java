package com.flight.management;

import com.flight.management.model.flight.BusinessFlight;
import com.flight.management.model.flight.EconomyFlight;
import com.flight.management.model.flight.Flight;
import com.flight.management.model.passenger.Passenger;

public class Airport {
    public static void main(String[] args) {
        Flight economy = new EconomyFlight("1");
        Flight business = new BusinessFlight("2");

        Passenger james = new Passenger("James", true);
        Passenger mike = new Passenger("Mike", false);

        business.addPassenger(james);
        business.removePassenger(james);
        economy.addPassenger(mike);
        business.addPassenger(mike);

        System.out.println("Business flight passengers list : ");
        for (Passenger p : business.getAllPassengers()) {
            System.out.println(p.getName());
        }

        System.out.println("Economy flight passengers list : ");
        for (Passenger p : economy.getAllPassengers()) {
            System.out.println(p.getName());
        }
    }
}
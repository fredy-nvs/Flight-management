package com.flight.management.model.flight;

import com.flight.management.model.passenger.Passenger;

public class EconomyFlight extends Flight {

    public EconomyFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        return passengers.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if (passenger.isVip()) {
            return false;
        }
        return passengers.remove(passenger);
    }

}

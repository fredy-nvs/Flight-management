package com.flight.management.model.flight;

import com.flight.management.model.passenger.Passenger;

public class BusinessFlight extends Flight {

    public BusinessFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (!passenger.isVip()) {
            return false;
        }
        return passengers.add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        return false;
    }

}

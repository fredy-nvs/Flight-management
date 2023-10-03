package com.flight.management.model.flight;

import com.flight.management.model.passenger.Passenger;

import java.util.*;

public abstract class Flight {

    private String id;

    protected Set<Passenger> passengers = new HashSet<>();

    public Flight(String id) {
        this.id = id;
    }

    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);

    public Set<Passenger> getAllPassengers() {
        return Collections.unmodifiableSet(passengers);
    }

    public String getId() {
        return id;
    }

}

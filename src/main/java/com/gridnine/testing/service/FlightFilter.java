package main.java.com.gridnine.testing.service;

import main.java.com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> filter(List<Flight> flights);
}

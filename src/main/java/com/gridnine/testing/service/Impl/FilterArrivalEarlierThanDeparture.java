package main.java.com.gridnine.testing.service.Impl;

import main.java.com.gridnine.testing.model.Flight;
import main.java.com.gridnine.testing.service.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, реализующий фильтр для перелетов, с датой прилета раньше даты вылета.
 */
public class FilterArrivalEarlierThanDeparture implements FlightFilter {

    /**
     * Фильтрует список перелетов на основе того, происходит ли вылет до прилета в каждом сегменте.
     * @param flights список перелетов для фильтрации
     * @return отфильтрованный список перелетов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .noneMatch(segment -> segment.getDepartureDate().isAfter(segment.getArrivalDate())))
                .collect(Collectors.toList());
    }
}

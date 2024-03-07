package main.java.com.gridnine.testing.service.Impl;

import main.java.com.gridnine.testing.model.Flight;
import main.java.com.gridnine.testing.service.FlightFilter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс, реализующий фильтр для перелетов, где вылет рейса произошел до настоящего момента времени.
 */
public class FilterUntilCurrentDepartureTime implements FlightFilter {

    /**
     * Фильтрует список перелетов на основе того, произошел ли вылет рейса до настоящего момента времени.
     * @param flights список перелетов для фильтрации
     * @return отфильтрованный список перелетов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {

        LocalDateTime currentTime = LocalDateTime.now();
        return flights.stream()
                .filter(flight -> flight.getSegments()
                        .stream()
                        .limit(1)
                        .anyMatch(segment -> !segment.getDepartureDate().isBefore(currentTime)))
                .collect(Collectors.toList());
    }
}

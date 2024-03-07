package main.java.com.gridnine.testing.service.Impl;

import main.java.com.gridnine.testing.model.Flight;
import main.java.com.gridnine.testing.model.Segment;
import main.java.com.gridnine.testing.service.FlightFilter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, реализующий фильтр для перелетов, где общее время на земле превышает два часа.
 */
public class FilterFlightOverTwoHoursGround implements FlightFilter {
    /**
     * Фильтрует список перелетов на основе общего времени на земле, превышающего два часа.
     * @param flights список перелетов для фильтрации
     * @return отфильтрованный список перелетов
     */
    @Override
    public List<Flight> filter(List<Flight> flights) {
        int hoursOnGround = 2;
        List<Flight> filterFlights = new ArrayList<>();
        for (Flight flight : flights) {
            long minutesOnGround = 0;
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                minutesOnGround += Duration.between(segments.get(i).getArrivalDate(), segments.get(i + 1).getDepartureDate()).toMinutes();
            }
            if (minutesOnGround <= hoursOnGround * 60L) {
                filterFlights.add(flight);
            }
        }
        return filterFlights;
    }
}

package main.java.com.gridnine.testing;

import main.java.com.gridnine.testing.model.Flight;
import main.java.com.gridnine.testing.service.FlightFilter;
import main.java.com.gridnine.testing.service.Impl.FilterArrivalEarlierThanDeparture;
import main.java.com.gridnine.testing.service.Impl.FilterFlightOverTwoHoursGround;
import main.java.com.gridnine.testing.service.Impl.FilterUntilCurrentDepartureTime;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        System.out.println("Фильтрация по рейсам: не отображаются рейсы, где вылет произошел до настоящего времени");
        FlightFilter filter1 = new FilterUntilCurrentDepartureTime();
        filter1.filter(flights).forEach(System.out::println);
        System.out.println();

        System.out.println("Фильтрация по рейсам: не отображаются рейсы, прилет которых раньше вылета");
        FlightFilter filter2 = new FilterArrivalEarlierThanDeparture();
        filter2.filter(flights).forEach(System.out::println);
        System.out.println();

        System.out.println("Фильтрация по рейсам: не отображаются рейсы, которые проводят время на земле более 2 часов");
        FlightFilter filter3 = new FilterFlightOverTwoHoursGround();
        filter3.filter(flights).forEach(System.out::println);
        System.out.println();
    }
}
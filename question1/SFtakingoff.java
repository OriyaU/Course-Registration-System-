package question1;

import java.util.*;

public class SFtakingoff implements FlightSearchStrategy{
    public List<Flight> flightSearch(List<Flight> flights){
        // Collections.sort(flights, (flight1, flight2) -> flight1.departureTime.compareTo(flight2.departureTime));
        flights.sort(Comparator.comparing(Flight::getDepartureTime));
        return flights;
    }

}

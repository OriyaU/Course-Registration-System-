package question1;

import java.util.Comparator;
import java.util.List;


public class SFprice implements FlightSearchStrategy {
    @Override
    public List<Flight> flightSearch(List<Flight> flights){
       flights.sort(Comparator.comparing(Flight::getPrice));
        return flights;
    }
}

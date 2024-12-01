package question1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDateTime;

public class SFtimeOfFlight implements FlightSearchStrategy{

    public List<Flight> flightSearch(List<Flight> flights){

        flights.sort(Comparator.comparing(Flight::getDurationTime));
        return flights;
    }
}

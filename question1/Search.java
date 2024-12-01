package question1;

import java.util.List;

public class Search {
    private FlightSearchStrategy searchSDtrategy;

    public void setSearchStrategy(FlightSearchStrategy searchStrategy) {
        this.searchSDtrategy = searchStrategy;
    }
    public List<Flight> orderedFlight(List<Flight> flights) {
        return searchSDtrategy.flightSearch(flights);
    }

}

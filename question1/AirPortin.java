package question1;

public interface  AirPortin {
    void addtoAirport(AirlineComposite airline) ;
    void printAirport();
    boolean containsItem(String name);
    void removeItem(Airline item);
}

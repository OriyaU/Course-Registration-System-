package question1;

public interface People {
    String getName();
    Flight getFlight();
    int getNumber();
    void registerToObserveSpecificFlight(ChangeType[] changes, Flight flight);


}

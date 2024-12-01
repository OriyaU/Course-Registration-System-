package question1;

public interface FlightChangeObserver {
    void subscribe(ChangeType[] changeType, FlightChanges flightChanges);
    void unsubscribe(ChangeType[] changeType, FlightChanges flightChanges);
    void notifySubscribers(ChangeType updateType, Flight flight);
}
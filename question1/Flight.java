package question1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flight implements Airline,FlightChangeObserver {
    protected String name;
    protected double price;
    protected LocalDateTime departureTime;
    protected int durationTime;
    protected boolean isHapening;
    protected AirlineComposite airlineComposite;

    Map<ChangeType, List<FlightChanges>> observers = new HashMap<>();
    public Flight(String name, double price, LocalDateTime departureTime, int durationTime, AirlineComposite airlineComposite) {
        this.name = name;
        this.price = price;
        this.departureTime = departureTime;
        this.durationTime = durationTime;
        this.isHapening = true;
        this.airlineComposite = airlineComposite;
        for (ChangeType changeType : ChangeType.values()) {
            this.observers.put(changeType, new ArrayList<>());
        }

    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
        notifySubscribers(ChangeType.SPECIALPRICE, this);
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }
    public void   setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
        notifySubscribers(ChangeType.FLIGHTDELAY, this);
    }

    public int getDurationTime() {
        return durationTime;
    }

    @Override
    public boolean containsItem(String name) {
        return this.name.equals(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print() {
        System.out.println("Flight name  " + this.name + " price  " + this.price + " time " + this.departureTime + " Duration Flight  " + this.durationTime);
    }



    public void setCancelled() {
        this.isHapening = false;
        notifySubscribers(ChangeType.CANCELFLIGHT, this);

    }

    public AirlineComposite getAirlineComposite() {
        return airlineComposite;
    }


    public void subscribe(ChangeType[] changeTypes, FlightChanges flightChanges) {
        for (ChangeType changeType : changeTypes) {
            List<FlightChanges> users = observers.get(changeType);
            users.add(flightChanges);
        }
    }

    public void unsubscribe(ChangeType[] changeTypes, FlightChanges flightChanges) {
        for (ChangeType changeType : changeTypes) {
            List<FlightChanges> users = observers.get(changeType);
            users.remove(flightChanges);
        }



    }
    public void notifySubscribers(ChangeType updateType, Flight flight) {
        List<FlightChanges> users = observers.get(updateType);
        for (FlightChanges listener : users) {
            listener.update(updateType, flight);
        }
    }
}

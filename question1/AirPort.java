package question1;

import javax.management.Notification;
import java.util.HashSet;

/// השדה תעופה יכול לקבל רק חברות תעופה חדשות
public class AirPort implements AirPortin {
    private Airline airline;
    private String airportName;
    private HashSet<AirlineComposite> allFlightsAndAirlines;
    //private final NotificationService notificationService;

    public AirPort(String airportName) {
        this.airportName = airportName;
        this.allFlightsAndAirlines = new HashSet<>();
      //  this.notificationService = new NotificationService();


    }
    @Override
    public void addtoAirport(AirlineComposite airline) {

        allFlightsAndAirlines.add(airline);
    }

    public void removeBigAirline(AirlineComposite airline) {
        allFlightsAndAirlines.remove(airline);

    }
    @Override
    public void printAirport() {
        System.out.println(airportName);
        for (Airline airline : allFlightsAndAirlines) {
            airline.print();
        }
    }

    @Override
    public boolean containsItem(String name) {
        for (Airline airline : allFlightsAndAirlines) {
            if (airline.getName().equals(name)) {
                return true;
            }
        }
        for (Airline item : allFlightsAndAirlines) {
            if (item.containsItem(name)) { // Call individual containsItem
                return true;
            }
        }

        return false;

    }
    @Override
    public void removeItem(Airline item) {
        if (allFlightsAndAirlines.contains(item))
            allFlightsAndAirlines.remove(item);
        else {
            for (AirlineComposite airline : allFlightsAndAirlines) {
                airline.removeItem(item);

            }
        }
    }





}

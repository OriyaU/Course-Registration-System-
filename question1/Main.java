package question1;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Create Airport
        AirPort benGurionAirport = new AirPort("Ben Gurion Airport");

        // Create Airlines
        AirlineComposite elAl = new AirlineComposite("El Al");
        AirlineComposite arkia = new AirlineComposite("Arkia");
        AirlineComposite elBen = new AirlineComposite("El Ben");

        // Create Flights
        Flight flight11 = new Flight("Tel Aviv - New York", 1200.0, LocalDateTime.of(2024, 5, 10, 10, 0), 180,elAl);
        Flight flight22 = new Flight("Tel Aviv - London", 800.0, LocalDateTime.of(2024, 5, 15, 12, 0), 120,elAl);
        Flight flight33 = new Flight("Tel Aviv - Paris", 1000.0, LocalDateTime.of(2024, 5, 20, 15, 0), 150,arkia);
        Flight flight44= new Flight("Tel Aviv - Paris", 1000.0, LocalDateTime.of(2024, 5, 20, 15, 0), 150,elBen);

        List<Flight> listOfFlights = new ArrayList<>();

        listOfFlights.add(flight11);
        listOfFlights.add(flight22);
        listOfFlights.add(flight33);

        Search flightSearch = new Search();
        flightSearch.setSearchStrategy(new SFtakingoff()); // Use SFtakingoff for departure time sorting
        List<Flight> sortedFlights = flightSearch.orderedFlight(listOfFlights);
        System.out.println("Flights sorted by departure time:");
        for (Flight flight : sortedFlights) {
           flight.print(); // Print flight details (assuming Flight has a toString method)
        }

        flightSearch.setSearchStrategy(new SFprice());
        sortedFlights = flightSearch.orderedFlight(listOfFlights);
        System.out.println("Flights sorted by price of flight:");
        for (Flight flight : sortedFlights) {
            flight.print();
        }

        flightSearch.setSearchStrategy(new SFtimeOfFlight());
        sortedFlights = flightSearch.orderedFlight(listOfFlights);
        System.out.println("Flights sorted by duration time flight:");
        for (Flight flight : sortedFlights) {
            flight.print(); // Print flight details (assuming Flight has a toString method)
        }

        // Assign Flights to Airlines
        elAl.add(flight11);
        elAl.add(flight33);
        elBen.add(flight44);
        arkia.add(flight22);
        arkia.add(elBen);

        // Add Airlines to Airport
        benGurionAirport.addtoAirport(elAl);
        benGurionAirport.addtoAirport(arkia);

        System.out.println("All passengers and workers registered for notifications.");
        System.out.println("Airport Details:");
        benGurionAirport.printAirport(); // Print airport information

        System.out.println(benGurionAirport.containsItem(flight11.getName()));
        System.out.println(benGurionAirport.containsItem(elBen.getName()));
        benGurionAirport.removeItem(elBen);
        benGurionAirport.printAirport();
        System.out.println(benGurionAirport.containsItem("El Ben"));


        // Create Passengers and Workers
        Passenger passenger1 = new Passenger("Shahar Shlom", flight11, 123);
        Passenger passenger2 = new Passenger("Dany Bela", flight11, 124);
        Passenger passenger3 = new Passenger("Yael Levi", flight22, 123);

        Worker worker1 = new Worker("Beny Cohen", flight33, 167);
        Worker worker2 = new Worker("Bar Davied", flight22, 168);
        ChangeType[] m= new ChangeType[2];
        m[0]=ChangeType.CANCELFLIGHT;
        m[1]=ChangeType.FLIGHTDELAY;

        worker1.registerToObserveSpecificFlight(m, flight11);
        passenger2.registerToObserveSpecificFlight(ChangeType.values(),flight11);
        passenger1.registerToObserveSpecificFlight(ChangeType.values(),flight22);
        flight11.setPrice(5);
        flight11.setCancelled();
        flight22.setDepartureTime(LocalDateTime.of(2024, 5, 15, 13, 0));
        flight22.setPrice(500);




    }








    

}


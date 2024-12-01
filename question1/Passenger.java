package question1;

public class Passenger implements People, FlightChanges {
    private String name;
    private Flight flight;
    private int sitNumber;

    public Passenger(String name, Flight flight, int sitNumber) {
        this.name = name;
        this.flight = flight;
        this.sitNumber = sitNumber;

    }

    public String getName() {
        return name;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getNumber() {
        return sitNumber;
    }


    public int getSitNumber() {
        return sitNumber;
    }

    @Override
    public void registerToObserveSpecificFlight(ChangeType[] changes, Flight flight) {
        flight.subscribe(changes, this);
    }

    @Override
    public void update(ChangeType changeType, Flight flight) {

        switch (changeType) {
            case FLIGHTDELAY:
                System.out.println(this.name + " flight" + flight.getName() + " is delayed"+flight.getDurationTime());
                break;
            case CANCELFLIGHT:
                System.out.println(this.name + " flight" + flight.getName() + " cancelled");
                break;
            case SPECIALPRICE:
                System.out.println(this.name + " flight" + flight.getName() + "There is a special price for your flight"+flight.getPrice());
                break;
        }

    }
}

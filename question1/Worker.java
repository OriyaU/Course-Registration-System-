package question1;

public class Worker implements People, FlightChanges {
    private String name;
    private int numberOfWorker;
    private Flight flight;

    public Worker(String name, Flight flight, int numberOfWorker) {
        this.name = name;
        this.numberOfWorker = numberOfWorker;
        this.flight = flight;

    }

    public String getName() {
        return name;

    }

    @Override
    public Flight getFlight() {
        return null;
    }


    @Override
    public int getNumber() {

        return numberOfWorker;
    }

    @Override
    public void registerToObserveSpecificFlight(ChangeType[] changes, Flight flight) {
        flight.subscribe(changes, this);
    }

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

package question1;

import java.util.HashSet;

public class AirlineComposite implements Airline {
    private String name;
    private final HashSet<Airline> children;

    public AirlineComposite(String name) {
        this.name = name;
        this.children = new HashSet<>();
    }

    public void add(Airline item) {
        children.add(item);
    }

    public void removeItem(Airline item) {

        if (children.contains(item)) {
            this.children.remove(item);
        }
        // Remove from immediate children

        // Recursively remove from child composites if needed
        for (Airline child : children) {
            if (child instanceof AirlineComposite) {
                ((AirlineComposite) child).removeItem(item);
            }

        }


    }


    public boolean containsItem(String name1) {
        if (this.name.equals(name1)) {
            return true;
        } else {
            for (Airline item : children) {
                if (item.containsItem(name1)) { // Call child containsItem
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void print() {
        System.out.println("Airline: " + name);
        for (Airline item : children) {
            item.print();
        }
    }


}

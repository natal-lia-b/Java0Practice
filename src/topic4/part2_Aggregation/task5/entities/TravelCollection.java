package topic4.part2_Aggregation.task5.entities;

import java.util.ArrayList;

/**
 * EPAM Java0Practice. Topic 4. Part 2 (aggregation). Task 5.
 * Travel collection. Mechanizm to add one travel to travel collection
 *
 * @author Natallia Bialiatskaya
 * @version 1.0
 * @since 03.08.2021
 */

public class TravelCollection implements Cloneable {
    private ArrayList<Travel> travelList;

    public TravelCollection() {
        travelList = new ArrayList<>();
    }

    public void addTravel(Travel oneTravel) {
        travelList.add(oneTravel);
    }

    public void removeTravel(Travel oneTravel) {
        travelList.remove(oneTravel);
    }

    public ArrayList<Travel> getTravelList() {
        return travelList;
    }

    public void setTravelList(ArrayList<Travel> travelList) {
        this.travelList = travelList;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Travel oneTravel : travelList) {
            result.append(oneTravel.toString());
        }
        return result.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package Classes;

import java.util.Comparator;

public class SortByManufacturing implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        return o1.getManufacturingYear()-o2.getManufacturingYear();
    }

}

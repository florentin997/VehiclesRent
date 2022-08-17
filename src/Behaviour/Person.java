package Behaviour;

import java.util.ArrayList;

public interface Person {
    public String opensTheVehicleDoor();
    public String entersVehicle();
    public String startEngine();
    public String stopEngine();
    public String exitsVehicle();
    public ArrayList<Vehicle> viewAllVehicles();
}

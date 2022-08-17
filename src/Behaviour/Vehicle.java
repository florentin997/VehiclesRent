package Behaviour;

public interface Vehicle {
    public String startVehicle();
    public String stopVehicle();
    public String driving();
    public int useAcceleration(int changeInSpeed); //pas the speed as param (how much faster does the car go?)
    public int useBreak(int changeInSpeed); //pas the speed as param (how much slower does the car go?)

}

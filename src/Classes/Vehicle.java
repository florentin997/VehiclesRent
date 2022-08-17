package Classes;

public class Vehicle implements Behaviour.Vehicle{
     private String RegistrationNumber;
     private Type Type;
    private String Brand;
     private int ManufacturingYear;
     private String Colour;

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type type) {
        this.Type = type;
    }

    public int getManufacturingYear() {
        return ManufacturingYear;
    }

    public void setManufacturingYear(int manufacturingYear) {
        ManufacturingYear = manufacturingYear;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getColour() {
        return Colour;
    }

    public void setColour(String colour) {
        Colour = colour;
    }


    public Vehicle(String registrationNumber, Type type, String brand,int manufacturingYear, String colour) {
        RegistrationNumber = registrationNumber;
        this.Type = type;
        ManufacturingYear = manufacturingYear;
        Brand = brand;
        Colour = colour;
    }

    @Override
    public String startVehicle() {
        return null;
    }

    @Override
    public String stopVehicle() {
        return null;
    }

    @Override
    public String driving() {
        return null;
    }

    @Override
    public int useAcceleration(int changeInSpeed) {
        return 0;
    }

    @Override
    public int useBreak(int changeInSpeed) {
        return 0;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "RegistrationNumber='" + RegistrationNumber + '\'' +
                ", Type=" + Type.name() +
                ", ManufacturingYear=" + ManufacturingYear +
                ", Brand='" + Brand + '\'' +
                ", Colour='" + Colour + '\'' +
                '}';
    }

}

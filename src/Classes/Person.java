package Classes;

import Behaviour.Vehicle;

import java.util.ArrayList;
import java.util.Date;

public class Person implements Behaviour.Person {
    private String PersonalIdNumber;
    private String FirstName;
    private String LastName;
    private Date DateOfBirth;
    private Gender Gender;
    private int EmittedYearOfDrivingLicense;

    public String getPersonalIdNumber() {
        return PersonalIdNumber;
    }

    public void setPersonalIdNumber(String personalIdNumber) {
        PersonalIdNumber = personalIdNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return Gender;
    }

    public void setGender(Gender gender) {
        Gender = gender;
    }

    public int getEmitedYearOfDrivingLicense() {
        return EmittedYearOfDrivingLicense;
    }

    public void setEmitedYearOfDrivingLicense(int emitedYearOfDrivingLicense) {
        EmittedYearOfDrivingLicense = emitedYearOfDrivingLicense;
    }

    public Person(String personalIdNumber, String firstName, String lastName, Date dateOfBirth, Gender gender, int emitedYearOfDrivingLicense) {
        PersonalIdNumber = personalIdNumber;
        FirstName = firstName;
        LastName = lastName;
        DateOfBirth = dateOfBirth;
        Gender = gender;
        EmittedYearOfDrivingLicense = emitedYearOfDrivingLicense;
    }

    @Override
    public String opensTheVehicleDoor() {
        return null;
    }

    @Override
    public String entersVehicle() {
        return null;
    }

    @Override
    public String startEngine() {
        return null;
    }

    @Override
    public String stopEngine() {
        return null;
    }

    @Override
    public String exitsVehicle() {
        return null;
    }

    @Override
    public ArrayList<Vehicle> viewAllVehicles() {
        return null;
    }
}

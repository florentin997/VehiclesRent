package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Rent{
    private int Id;
    private Date StartDate;
    private Date EndDate;
    private float Kilometers;
    private String PersonalIdentificationNumber;
    private String RegistrationNumber;

    public Rent(int id, String personalIdentificationNumber, String registrationNumber, Date startDate, Date endDate, float kilometers) {
        Id = id;
        PersonalIdentificationNumber = personalIdentificationNumber;
        RegistrationNumber = registrationNumber;
        StartDate = startDate;
        EndDate = endDate;
        Kilometers = kilometers;
    }

    public Rent(Date startDate, Date endDate, float kilometers, String personalIdentificationNumber, String registrationNumber) {
        StartDate = startDate;
        EndDate = endDate;
        Kilometers = kilometers;
        PersonalIdentificationNumber = personalIdentificationNumber;
        RegistrationNumber = registrationNumber;
    }

    public static List<Rent> GetRentedVehicles() {
        String sql = "SELECT * FROM rent";
        List<Rent> rentedVehicles = new ArrayList<Rent>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VehiclesRent","root","strongpassword99!");
             PreparedStatement ps = con.prepareStatement(sql)) {
            //ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    rentedVehicles.add(new Rent(
                            rs.getInt("idRent"),
                            rs.getString("PersonCNP"),
                            rs.getString("VehicleRegPlate"),
                            rs.getDate("startDate"),
                            rs.getDate("endDate"),
                            rs.getFloat("km")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentedVehicles;
    }

    public static void InsertRentedVehicleInDB(String CNP, String RegPlate, Date startDate, Date endDate, float km){
        String sql = "INSERT INTO rent(PersonCNP, VehicleRegPlate, startDate,endDate,km) values(?,?,?,?,?)";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VehiclesRent","root","strongpassword99!");
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, CNP);
            ps.setString(2, RegPlate);
            ps.setDate(3, (java.sql.Date) startDate);
            ps.setDate(4, (java.sql.Date) endDate);
            ps.setFloat(5, km);

            ps.executeUpdate();
        }
            catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Rent> GetAllVehiclesRentedByUser(String CNP){
        String sql = "SELECT * FROM rent WHERE PersonCNP=?";
        List<Rent> vehiclesList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VehiclesRent","root","strongpassword99!");
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, CNP);
            try (ResultSet rs = ps.executeQuery()) {
                while(rs.next()) {
                    vehiclesList.add(new Rent(
                            rs.getInt("idRent"),
                            rs.getString("PersonCNP"),
                            rs.getString("VehicleRegPlate"),
                            rs.getDate("startDate"),
                            rs.getDate("endDate"),
                            rs.getFloat("km")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiclesList;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "Id=" + Id +
                ", StartDate=" + StartDate +
                ", EndDate=" + EndDate +
                ", Kilometers=" + Kilometers +
                ", PersonalIdentificationNumber='" + PersonalIdentificationNumber + '\'' +
                ", RegistrationNumber='" + RegistrationNumber + '\'' +
                '}';
    }
}

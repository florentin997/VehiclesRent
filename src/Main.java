import Classes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static Classes.Rent.GetAllVehiclesRentedByUser;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {


        //Vehicule create de mine
//        List<Person> peopleList = new ArrayList<>();
//        List<Vehicle> vehiclesList = new ArrayList<>();
//
//        Person p1 = new Person("1990875624761", "Mircea", "Mircescu", new Date(1999 - 07 - 05), Gender.Male, 1999);
//        Person p2 = new Person("1800875624761", "Ionut", "Popesci", new Date(1980 - 07 - 05), Gender.Male, 1980);
//        Person p3 = new Person("2200875624761", "Ioana", "Alecse", new Date(2000 - 07 - 05), Gender.Female, 2000);
//        Person p4 = new Person("2950875624761", "Maria", "Popescu", new Date(1995 - 07 - 05), Gender.Female, 1995);
//
//        peopleList.add(p1);
//        peopleList.add(p2);
//        peopleList.add(p3);
//        peopleList.add(p4);
//
//        Vehicle v1 = new Vehicle("BV10BRV", Type.MASINA, "Toyota", 2017 , "Grey");
//        Vehicle v2 = new Vehicle("BV94JTE", Type.MASINA, "Tesla", 2020, "White");
//        Vehicle v3 = new Vehicle("B543ADS", Type.SCOOTER, "Suzuki", 2018, "Green");
//        Vehicle v4 = new Vehicle("BV23DAS", Type.MASINA, "Hyundai", 2012, "Black");
//
//        vehiclesList.add(v1);
//        vehiclesList.add(v2);
//        vehiclesList.add(v3);
//        vehiclesList.add(v4);
//
//        System.out.println("Lista de masini: " + GetAllVehicles(vehiclesList));
//
//        for (int i = 0; i < vehiclesList.size(); i++) {
//            System.out.println("Plate number: " + vehiclesList.get(i).getRegistrationNumber() + ", manufacturing year " + vehiclesList.get(i).getManufacturingYear());
//            Collections.sort(vehiclesList, new SortByManufacturing());
//        }



//        System.out.println("Alege un tip de vehicul");
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();

//        List<Vehicle> vehicleByTypeList = new ArrayList<>();
//
//        for(Vehicle v : vehiclesList){
//            if(v.getType().toString().toLowerCase().equals(str.toLowerCase())){
//                System.out.println(v.toString());
//                vehicleByTypeList.add(v);
//            }
//        }
        //-------------------pana aici------------------------

        //Vehiculele citite din fisierul text

        List<Vehicle> vehiclesList = new ArrayList<Vehicle>();

        try (Scanner scanner = new Scanner(new File("src/vehicles.txt"));) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] objects = line.split(",");
                Type type = Type.valueOf(objects[1].toUpperCase().trim());
                Vehicle car = new Vehicle(objects[0], type, objects[2], Integer.parseInt(objects[3].trim()), objects[4]);
                vehiclesList.add(car);
            }
        } catch (FileNotFoundException fne) {
            fne.printStackTrace();
        }

        List<String> lambdaVehiclesListRegNum = vehiclesList.stream().map(Vehicle::getRegistrationNumber).collect(toList());
        //System.out.println(lambdaVehiclesListRegNum.size());

        //Sortare cu lambda dupa manufacturingYear
        //List<String> lambdaSortedCarsList = carsList.stream().sorted(comparing(Car::getManufacturingYear)).collect(toList());

        //sort by manufacturing year with lambda
        Comparator<Vehicle> byManYear = Comparator.comparing(Vehicle::getManufacturingYear);
        Collections.sort(vehiclesList, byManYear);
        //System.out.println(vehiclesList.toString());

        //all car registration numbers by type
        //System.out.println("Alege un tip de vehicul: ");
        //Scanner sc = new Scanner(System.in);
        //String userInput = sc.nextLine().toUpperCase();
        //List<String> vehicleByTypeList = vehiclesList.stream().filter(vehicle -> vehicle.getType().toString().contains(userInput)).map(Vehicle::getRegistrationNumber).collect(toList());
        //System.out.println(vehicleByTypeList);

        List<Rent> rentedVehicles = new ArrayList<>();
        rentedVehicles = Rent.GetRentedVehicles();
        //System.out.println(rentedVehicles);

        //---------INSERT METHOD-----------
        //Rent.InsertRentedVehicleInDB("2990707998877","BV-67-ACC", null, null, 23);

        //---------GET ALL VEHICLES FOR A GIVEN PERSON
        List<Rent> VehiclesByUser = GetAllVehiclesRentedByUser("2990707998877");
        System.out.println(VehiclesByUser);
    }

    public static List<String> GetAllVehicles(List<Vehicle> list) {
        List<String> vehiclesList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            vehiclesList.add(list.get(i).getRegistrationNumber());
        }
        return vehiclesList;
    }
}


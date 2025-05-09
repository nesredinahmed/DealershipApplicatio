import java.util.ArrayList;

public class Dealership {
    String name;
    String address;
    String phone;
    ArrayList<String> inventory = new ArrayList<String>();

    //Contractor

    Dealership (String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>(inventory);

    }

    //Getters

    void getVehiclesByPrice(String min, String max){
        //List Vehicle by Price
    }

    void getVehiclesByMake(String min, String max){
        //List Vehicle by Make
    }

    void getVehiclesByYear(String min, String max){
        //List Vehicle by Year
    }

    void getVehiclesByColor(String min, String max){
        //List Vehicle by Color
    }

    void getVehiclesByMileage(String min, String max){
        //List Vehicle by Mileage
    }

    void getVehiclesByType(String min, String max){
        //List Vehicle by Type
    }

    void getVehiclesByAll(String min, String max){
        //List Vehicle All
    }
    void addVehicles(String vehicle){

        System.out.println("Add Vehicle");
    }

    void removeVehicle(String min, String max){
        //List Vehicle
    }
}

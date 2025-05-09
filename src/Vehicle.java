public class Vehicle {
    int vin;
    int year;
    String make;
    String model;
    String vehicleType;
    String color;
    int odometer;
    double price;

    Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price){
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;

    }
    Vehicle(int vin){//Overloaded Constructor
        this.vin = vin;

    }

    public String toString() {
        return String.format("VIN: '%d'\nYEAR: '%d'\nMAKE: '%s'\nMODEL: '%s'\n",
                this.vin, this.year, this.make, this.model);
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle(123, 2022, "TOYOTA", "Camry", "Hybrid", "Black", 30_000, 35000);
        Vehicle v2 = new Vehicle(123, 2022, "TOYOTA", "Camry", "Hybrid", "Black", 30_000, 35000);
        System.out.println(v);
        System.out.println(v2);
    }

}

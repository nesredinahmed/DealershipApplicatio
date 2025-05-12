
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UserInterface{
    private Dealership dealership;
    BufferedReader in;
    DealershipFileManager manager;
    UserInterface() {
        this.init();
    }
    private void init(){
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.manager = new DealershipFileManager();
        this.dealership = this.manager.getDealership();
    }
    void display() {
        String command = "";
        while (!command.equalsIgnoreCase("x")) {
            System.out.println("""
                    MAIN MENU:
                        Search By:
                            a) all
                            p) price
                            m) make and model
                            y) year
                            c) color
                            o) odometer miles
                            t) type (e.g. sedan)
                            +) add
                            -) remove
                            x) e(x)it
                    """);
            command = null;
            try {
                command = in.readLine().toLowerCase().trim();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            switch (command) {
                case "a" -> processGetAllVehiclesRequest();
                case "p" -> processGetByPriceRequest();
                case "m" -> processGetByMakeModelRequest();
                case "y" -> processGetByYearRequest();
                case "c" -> processGetByColorRequest();
                case "o" -> processGetByMilesRequest();
                case "t" -> processGetByTypeRequest();
                case "+" -> processAddVehicleRequest();
                case "-" -> processRemoveVehiclesRequest();
                case "x" -> System.out.println("Thanks!");
                default -> System.out.println("Invalid Command");
            }
        }
    }

    private void processRemoveVehiclesRequest() {
        int vin = getInt("VIN to Remove");
        Vehicle v = null;
        for(Vehicle candidate : dealership.getAllVehicles()){
            if(candidate.getVIN() == vin){
                v = candidate;
                break;
            }
        }
        if(v == null){
            System.out.println("No vehicle with VIN: " + vin);
            return;
        }
        this.dealership.removeVehicle(v);
    }

    private void processGetByTypeRequest() {
        var list = this.dealership.getVehiclesByType(
                getString("Vehicle Type e.g. Truck/Sedan/Roadster")
        );
        if(list.size() == 0){
            System.out.println("None Found.");
            return;
        }
        for(Vehicle v : list){
            System.out.println(v);
        }
    }

    private void processGetByColorRequest() {
        var list = this.dealership.getVehiclesByColor(
                getString("Color")
        );
        if(list.size() == 0){
            System.out.println("None Found.");
            return;
        }
        for(Vehicle v : list){
            System.out.println(v);
        }
    }

    private void processGetByMilesRequest() {
        var list = this.dealership.getVehiclesByMileage(
                getInt("Minimum"),
                getInt("Maximum")
        );
        if(list.size() == 0){
            System.out.println("None Found.");
            return;
        }
        for(Vehicle v : list){
            System.out.println(v);
        }
    }

    private void processAddVehicleRequest() {
        //TODO Collect all info from user
        int vin = getInt("VIN");
        int year = getInt("Year");
        String make = getString("Make");
        String model = getString("Model");
        String vehicleType = getString("Vehicle (e.g. sedan):");
        String color = getString("Color");
        int odometer = getInt("Mileage");
        double price = getDouble("Price");
        var v = new Vehicle(
                vin,
                year,
                make,
                model,
                vehicleType,
                color,
                odometer,
                price
        );
        dealership.addVehicle(v);
    }

    void processGetAllVehiclesRequest(){
        var list = this.dealership.getAllVehicles();
        if(list.size() == 0){
            System.out.println("None Found.");
            return;
        }
        for(Vehicle v : list){
            System.out.println(v);
        }
    }
    int getInt(String name){
        System.out.printf("%s: ", name);
        Integer value = null;
        while(value==null) {
            try {
                value = Integer.parseInt(in.readLine().toLowerCase().trim().replace(",", ""));
            } catch (IOException e) {
                System.out.println("Try Again:");
            }
        }
        return value;
    }
    double getDouble(String name){
        System.out.printf("%s: ", name);
        Double value = null;
        while(value==null) {
            try {
                value = Double.parseDouble(in.readLine().toLowerCase().trim().replace(",", ""));
            } catch (IOException e) {
                System.out.println("Try Again:");
            }
        }
        return value;
    }
    String getString(String name){
        System.out.printf("%s: ", name);
        String value = null;
        while(value==null) {
            try {
                value = in.readLine();
            } catch (IOException e) {
                System.out.println("Try Again:");
                value = null;
                continue;
            }

            if(value.trim().isEmpty()){
                System.out.println("Try Again:");
                value = null;
            }
        }
        return value;
    }
    void processGetByPriceRequest(){
        var list = this.dealership.getVehiclesByPrice(
                getInt("Minimum"),
                getInt("Maximum")
        );

        if(list.size() == 0){
            System.out.println("None Found.");
        }

        for(Vehicle v : list){
            System.out.println(v);
        }
    }
    void processGetByYearRequest(){
        var list = this.dealership.getVehiclesByYear(
                getInt("Minimum Year"),
                getInt("Maximum Year")
        );

        if(list.size() == 0){
            System.out.println("None Found.");
        }

        for(Vehicle v : list){
            System.out.println(v);
        }
    }
    void processGetByMakeModelRequest(){
        var list = this.dealership.getVehiclesByMakeModel(
                getString("Make"),
                getString("Model")
        );

        if(list.size() == 0){
            System.out.println("None Found.");
        }

        for(Vehicle v : list){
            System.out.println(v);
        }
    }

}

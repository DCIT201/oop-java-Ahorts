import java.util.Objects;
import java.util.Scanner;

public class Main {
    // Two scanner instances are initialized here namely input and stringInput. Initially, input was used for all input
    // data types. However, this resulted in some string fields empty since nextLine() consumes the new line
    // character. One way to deal with this was to use  nextLine() twice for the first to consume the new line
    // character and the second accept the string input. But I didn't feel like littering the code with all those
    // extra lines so, separating the string data type from the rest with its own scanner instance seems to fix that.
    // Update: Decided to fix the issue with functions which also validates the input

    static Scanner input = new Scanner(System.in);
    static Scanner stringInput = new Scanner(System.in);
    static RentalAgency agency;

    public static void main(String[] args) {
        System.out.println("*===Welcome to Advanced Vehicle Rental Management System!*===");
        String agencyName = getString("Enter your agency name: ");
        agency = new RentalAgency(agencyName);

        do {
            displayMainMenu();
            System.out.println("\nSelect an option: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    CustomerOperations();
                    break;
                case 2:
                    VehicleOperations();
                    break;
                case 3:
                    RentalOperations();
                    break;
                case 4:
                    Reports();
                    break;
                case 5:
                    System.out.println("Thank you for using " + agency.getAgencyName() + " Rental System!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (true);

    }

    private static void displayMainMenu() {
        System.out.println("\n*=== " + agency.getAgencyName() + " Rental System ===*");
        System.out.println("1. Customer Operations");
        System.out.println("2. Vehicle Operations");
        System.out.println("3. Rental Operations");
        System.out.println("4. Reports");
        System.out.println("5. Exit");
    }

    private static void CustomerOperations() {
        while (true) {
            System.out.println("\n*=== Customer Operations ===*");
            System.out.println("1. Add New Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. View Customer Rental History");
            System.out.println("4. View Customer Current Rentals");
            System.out.println("5. Back to Main Menu");
            System.out.println("\n Select an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    viewCustomers();
                    break;
                case 3:
                    viewCustomerHistory();
                    break;
                case 4:
                    viewCustomerCurrentRentals();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }


        }
    }

    private static void VehicleOperations() {
        while (true) {
            System.out.println("\n*=== Vehicle Operations ===*");
            System.out.println("1. Add New Car");
            System.out.println("2. Add New Motorcycle");
            System.out.println("3. Add New Truck");
            System.out.println("4. View All Vehicles");
            System.out.println("5. View Available Vehicles");
            System.out.println("6. Remove Vehicle");
            System.out.println("7. Edit Vehicle");
            System.out.println("8. View Specific Vehicle");
            System.out.println("9. Back to Main Menu");
            System.out.println("\n Select an option: ");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    addNewCar();
                    break;
                case 2:
                    addNewMotorcycle();
                    break;
                case 3:
                    addNewTruck();
                    break;
                case 4:
                    viewAllVehicles();
                    break;
                case 5:
                    viewAvailableVehicles();
                    break;
                case 6:
                    removeVehicle();
                    break;
                case 7:
                    editVehicle();
                    break;
                case 8:
                    viewVehicle();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void RentalOperations() {
        while (true) {
            System.out.println("\n*=== Rental Operations ===*");
            System.out.println("1. Rent a Vehicle");
            System.out.println("2. Return a Vehicle");
            System.out.println("3. Back to Main Menu");
            System.out.println("\n Select an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    rentVehicle();
                    break;
                case 2:
                    returnVehicle();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void Reports() {
        while (true) {
            System.out.println("\n*=== Reports ===*");
            System.out.println("1. Print All Reports");
            System.out.println("2. Main Menu");
            System.out.println("\nSelect an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(agency.generateRentalReport());
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }

    // Customer Operations methods
    private static void addNewCustomer() {
        String name = getString("Enter customer name: ");
        String email = getString("Enter customer email: ");

        Customer customer = new Customer(name, email);
        System.out.println("Customer added successfully! Customer ID: " + customer.getCustomerId());
    }

    private static void viewCustomers() {
        System.out.println("*=== Rental Customers ===*");

        for (Customer customer : Customer.getCustomers()) {
            System.out.println("Customer ID: " + customer.getCustomerId() + " Name: " + customer.getName() + " Email: "
                    + customer.getEmail());
        }
    }

    private static void viewCustomerHistory() {
        int id = getInt("Enter customer ID: ");

        for (Customer customer : Customer.getCustomers()) {
            if (customer.getCustomerId() == id) {
                System.out.println("Customer ID: " + customer.getCustomerId());
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("\n*=== Customer History ===*");
                for (Vehicle vehicle : customer.getRentalHistory()) {
                    System.out.println(vehicle.toString());
                }

            }
        }


    }

    private static void viewCustomerCurrentRentals() {
        int id = getInt("Enter customer ID: ");
        for (Customer customer : Customer.getCustomers()) {
            if (customer.getCustomerId() == id) {
                System.out.println("Customer ID: " + customer.getCustomerId());
                System.out.println("Name: " + customer.getName());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("\n*=== Customer Rentals ===*");
                for (Vehicle vehicle : customer.getCurrentRentals()) {
                    System.out.println(vehicle.toString());
                }
            }
        }
    }

    // Vehicle Operations methods
    private static void addNewCar() {
        String model = getString("Enter car model: ");
        double rate = getDouble("Enter base rental rate: ");

        Car car = new Car(model, rate);

        car.setHasAirConditioners(getBoolean("Has Air Conditioners? (true/false): "));
        car.setHasChildSeats(getBoolean("Has Child Seats? (true/false): "));
        car.setHasGPS(getBoolean("Has GPS? (true/false): "));
        car.setHasCamera(getBoolean("Has camera? (true/false): "));
        car.setSeatCount(getInt("Enter seat count: "));

        car.setColor(getString("Enter color: "));
        car.setTransmission(getString("Enter transmission type: "));
        car.setFuelType(getString("Enter fuel type: "));

        agency.addVehicle(car);
        System.out.println("\nCar added successfully! Vehicle ID: " + car.getVehicleId() + " || Model: " + car.getModel()
                + " || Rental rate: " + RentCalculator.calculateFinalRate(rate, car.activeFeatures));
    }

    private static void addNewMotorcycle() {
        String model = getString("Enter motorcycle model: ");
        double rate = getDouble("Enter base rental rate: ");

        Motorcycle motorcycle = new Motorcycle(model, rate);

        motorcycle.setHasHelmet(getBoolean("Has Helmet? (true/false): "));
        motorcycle.setHasWindshield(getBoolean("Has Windshield? (true/false): "));
        motorcycle.setHasStorageBox(getBoolean("Has Storage Box? (true/false): "));

        motorcycle.setColor(getString("Enter color: "));
        motorcycle.setSeatCount(getInt("Enter seat count: "));
        motorcycle.setTransmission(getString("Enter transmission type: "));
        motorcycle.setFuelType(getString("Enter fuel type: "));

        agency.addVehicle(motorcycle);
        System.out.println("Motorcycle added successfully! Vehicle ID: " + motorcycle.getVehicleId()
                + "Model: " + motorcycle.getModel());

    }

    private static void addNewTruck() {
        String model = getString("Enter truck model: ");
        double rate = getDouble("Enter base rental rate: ");

        Truck truck = new Truck(model, rate);

        truck.setHasAirConditioners(getBoolean("Has Air Conditioners? (true/false): "));
        truck.setHasCamera(getBoolean("Has camera? (true/false): "));
        truck.setHasGPS(getBoolean("Has GPS? (true/false): "));
        truck.setHasHydraulics(getBoolean("Has Hydraulics? (true/false): "));


        truck.setColor(getString("Enter color: "));
        truck.setSeatCount(getInt("Enter seat count: "));
        truck.setTransmission(getString("Enter transmission type: "));
        truck.setFuelType(getString("Enter fuel type: "));

        agency.addVehicle(truck);
        System.out.println("Truck added successfully! Vehicle ID: " + truck.getVehicleId() +
                "Model: " + truck.getModel());
    }

    private static void viewAllVehicles() {
        System.out.println("\n*=== All Vehicles ===*");
        for (Vehicle vehicle : agency.getAgencyVehicles()) {
            System.out.println(vehicle.toString());
        }
    }

    private static void viewAvailableVehicles() {
        System.out.println("\n*=== Available Vehicles ===*");
        for (Vehicle vehicle : agency.getAvailableVehicles()) {
            System.out.println(vehicle.toString());
        }
    }

    private static void removeVehicle() {
        agency.removeVehicle(getInt("Enter vehicle ID: "));
        System.out.println("Vehicle removed successfully! / Vehicle does not exist!");
    }

    private static void editVehicle() {
        Vehicle vehicle = findVehicle(getInt("Enter vehicle ID: "));
        if (vehicle != null) {

            vehicle.setModel(getString("Enter model: "));
            vehicle.setBaseRentalRate(getDouble("Enter new rental rate: "));
            vehicle.setColor(getString("Enter color: "));
            vehicle.setTransmission(getString("Enter transmission type: "));
            vehicle.setFuelType(getString("Enter fuel type: "));

            // Since all subclasses have at least 1 specific property not available in the vehicle class, direct manipulation
            // is not feasible. I initially intended to use instanceOf() and if statements to determine the subclasses
            // to edit the appropriate fields but the guys on stackoverflow say it's bad practice. So, I declared the
            // editFeature method which is then overridden by each subclass to edit its fields.
            vehicle.editFeatures();

            System.out.println("\nVehicle updated successfully!");
            System.out.println(vehicle);
        } else {
            System.out.println("Vehicle not found!");
        }
    }

    private static void viewVehicle() {
        Vehicle vehicle = findVehicle(getInt("Enter vehicle ID: "));
        if (vehicle != null) {
            System.out.println("*=== Vehicle Information ===*");
            System.out.println("Vehicle ID: " + vehicle.getVehicleId());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Transmission type: " + vehicle.getTransmission());
            System.out.println("Fuel type: " + vehicle.getFuelType());
            vehicle.viewFeatures();
            System.out.println("Rental Rate: " +
                    RentCalculator.calculateFinalRate(vehicle.getBaseRentalRate(), vehicle.activeFeatures));
        } else {
            System.out.println("Vehicle not found!");
        }
    }


    // Rental Operations methods
    private static void rentVehicle() {
        int customerId = getInt("Enter customer ID: ");
        int vehicleId = getInt("Enter vehicle ID: ");
        int daysToRent = getInt("Enter days to rent: ");

        agency.rentVehicle(Objects.requireNonNull(findCustomer(customerId)),
                Objects.requireNonNull(findVehicle(vehicleId)),
                daysToRent);
    }

    private static void returnVehicle() {
        int vehicleId = getInt("Enter vehicle ID to return: ");
        agency.returnVehicle(findVehicle(vehicleId));

    }

    private static Vehicle findVehicle(int vehicleId) {
        for (Vehicle vehicle : agency.getAgencyVehicles()) {
            if (vehicle.getVehicleId() == vehicleId) {
                return vehicle;
            }
        }
        return null;
    }

    private static Customer findCustomer(int customerId) {
        for (Customer customer : Customer.getCustomers()) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }

        }
        return null;
    }

    // Methods to ask for input.
    private static int getInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer");
            }
        }
    }

    public static double getDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a number (Integer/Double)");
            }
        }
    }

    public static boolean getBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String answer = input.nextLine().toLowerCase();
            if (answer.equals("true") || answer.equals("false")) {
                return Boolean.parseBoolean(answer);
            }
            System.out.println("Please enter true or false.");
        }
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return stringInput.nextLine();
    }
}





import java.util.Objects;
import java.util.Scanner;

public class Main {
    // Two scanner instances are initialized here namely input and stringInput. Initially, input was used for all input
    // data types. However, this resulted in some string fields empty since nextLine() consumes the new line
    // character. One way to deal with this was to use  nextLine() twice for the first to consume the new line
    // character and the second accept the string input. But I didn't feel like littering the code with all those
    // extra lines so, separating the string data type from the rest with its own scanner instance seems to fix that.

    static Scanner input = new Scanner(System.in);
    static Scanner stringInput = new Scanner(System.in);
    static RentalAgency agency;

    public static void main(String[] args) {
        System.out.println("*===Welcome to Advanced Vehicle Rental Management System!*===");
        System.out.print("Enter the name of your agency: ");
        String agencyName = stringInput.nextLine();
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
            System.out.println("7. Back to Main Menu");
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
        System.out.println("Enter customer name: ");
        String name = stringInput.nextLine();

        System.out.println("Enter customer email: ");
        String email = stringInput.nextLine();

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
        System.out.print("Enter customer ID: ");
        int id = input.nextInt();

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
        System.out.print("Enter customer ID: ");
        int id = input.nextInt();
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
        System.out.print("Enter car model: ");
        String model = stringInput.nextLine();
        System.out.print("Enter base rental rate: ");
        double rate = input.nextDouble();

        Car car = new Car(model, rate);
        System.out.print("Has Air Conditioners? (true/false)");
        car.setHasAirConditioners(input.nextBoolean());

        System.out.print("Has child seats? (true/false): ");
        car.setHasChildSeats(input.nextBoolean());

        System.out.print("Has GPS? (true/false): ");
        car.setHasGPS(input.nextBoolean());

        System.out.print("Has camera? (true/false): ");
        car.setHasCamera(input.nextBoolean());

        System.out.print("Enter seat count: ");
        car.setSeatCount(input.nextInt());


        System.out.print("Enter color: ");
        car.setColor(stringInput.nextLine());
        System.out.print("Enter transmission type: ");
        car.setTransmission(stringInput.nextLine());
        System.out.print("Enter fuel type: ");
        car.setFuelType(stringInput.nextLine());

        agency.addVehicle(car);
        System.out.println("Car added successfully! Vehicle ID: " + car.getVehicleId());

    }

    private static void addNewMotorcycle() {
        System.out.print("Enter motorcycle model: ");
        String model = stringInput.nextLine();
        System.out.print("Enter base rental rate: ");
        double rate = input.nextDouble();

        Motorcycle motorcycle = new Motorcycle(model, rate);

        System.out.print("Has Helmet? (true/false): ");
        motorcycle.setHasHelmet(input.nextBoolean());

        System.out.print("Has Windshield? (true/false): ");
        motorcycle.setHasWindshield(input.nextBoolean());

        System.out.print("Has Storage Box? (true/false): ");
        motorcycle.setHasStorageBox(input.nextBoolean());


        System.out.print("Enter color: ");
        motorcycle.setColor(stringInput.nextLine());

        System.out.print("Enter seat count: ");
        motorcycle.setSeatCount(input.nextInt());

        System.out.print("Enter transmission type: ");
        motorcycle.setTransmission(stringInput.nextLine());

        System.out.print("Enter fuel type: ");
        motorcycle.setFuelType(stringInput.nextLine());

        agency.addVehicle(motorcycle);
        System.out.println("Motorcycle added successfully! Vehicle ID: " + motorcycle.getVehicleId());

    }

    private static void addNewTruck() {
        System.out.print("Enter truck model: ");
        String model = stringInput.nextLine();
        System.out.print("Enter base rental rate: ");
        double rate = input.nextDouble();

        Truck truck = new Truck(model, rate);

        System.out.print("Has Air Conditioners? (true/false): ");
        truck.setHasAirConditioners(input.nextBoolean());

        System.out.print("Has camera? (true/false): ");
        truck.setHasCamera(input.nextBoolean());

        System.out.print("Has GPS? (true/false): ");
        truck.setHasGPS(input.nextBoolean());

        System.out.print("Has Hydraulics? (true/false): ");
        truck.setHasHydraulics(input.nextBoolean());


        System.out.print("Enter color: ");
        truck.setColor(stringInput.nextLine());

        System.out.print("Enter seat count: ");
        truck.setSeatCount(input.nextInt());

        System.out.print("Enter transmission type: ");
        truck.setTransmission(stringInput.nextLine());

        System.out.print("Enter fuel type: ");
        truck.setFuelType(stringInput.nextLine());

        agency.addVehicle(truck);
        System.out.println("Truck added successfully! Vehicle ID: " + truck.getVehicleId());
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
        System.out.print("Enter vehicle ID: ");
        agency.removeVehicle(input.nextInt());
        System.out.println("Vehicle removed successfully!");
    }


    // Rental Operations methods
    private static void rentVehicle() {
        System.out.print("Enter Customer ID: ");
        int customerId = input.nextInt();

        System.out.print("Enter vehicle ID: ");
        int vehicleId = input.nextInt();
        System.out.print("Enter number of days to rent: ");
        int daysToRent = input.nextInt();

        agency.rentVehicle(findCustomer(customerId),
                Objects.requireNonNull(findVehicle(vehicleId)),
                daysToRent);
    }

    private static void returnVehicle() {
        System.out.print("Enter vehicle ID to return: ");
        int vehicleId = input.nextInt();
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
}





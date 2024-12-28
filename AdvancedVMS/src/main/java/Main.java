import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static RentalAgency agency;

    public static void main(String[] args) {
        System.out.println("*===Welcome to Advanced Vehicle Rental Management System!*===");
        System.out.print("Enter the name of your agency: ");
        String agencyName = input.nextLine();
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
            System.out.println("2. View Customer Rental History");
            System.out.println("3. View Customer Current Rentals");
            System.out.println("4. Back to Main Menu");
            System.out.println("\n Select an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    viewCustomerHistory();
                    break;
                case 3:
                    viewCustomerCurrentRentals();
                    break;
                case 4:
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
                    displayMainMenu();
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void Reports() {
        while (true) {
            System.out.println("\n*=== Reports ===*");
            System.out.println("1. Print All Reports");
            System.out.println("Main Menu");
            System.out.println("\nSelect an option: ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(agency.generateRentalReport());
                    break;
                case 2:
                    displayMainMenu();
                    break;
                    default:
                        System.out.println("Invalid choice. Please try again.");

            }
        }
    }


}



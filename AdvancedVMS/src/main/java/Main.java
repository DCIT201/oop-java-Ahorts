import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static RentalAgency agency;

    public static void main(String[] args) {
        System.out.println("Welcome to Advanced Vehicle Rental Management System!");
        System.out.println("Enter the name of your agency: ");
        String agencyName = input.nextLine();
        agency = new RentalAgency(agencyName);


        do {
            displayMainMenu();
            System.out.println("\nSelect an option: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    handleCustomerOperations();
                    break;
                case 2: handleVehicleOperations();
                    break;
                case 3: handleRentalOperations();
                    break;
                case 4: handleReports();
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
        System.out.println("\n=== " + agency.getAgencyName() + " Rental System ===");
        System.out.println("1. Customer Operations");
        System.out.println("2. Vehicle Operations");
        System.out.println("3. Rental Operations");
        System.out.println("4. Reports");
        System.out.println("5. Exit");
    }
    private static void handleCustomerOperations() {
        while (true) {
            System.out.println("\n=== Customer Operations ===");
            System.out.println("1. Add New Customer");
            System.out.println("2. View Customer Rental History");
            System.out.println("3. View Customer Current Rentals");
            System.out.println("4. Back to Main Menu");


        }
    }

    private static void handleVehicleOperations() {
        while (true) {
            System.out.println("\n=== Vehicle Operations ===");
            System.out.println("1. Add New Car");
            System.out.println("2. Add New Motorcycle");
            System.out.println("3. Add New Truck");
            System.out.println("4. View All Vehicles");
            System.out.println("5. View Available Vehicles");
            System.out.println("6. Remove Vehicle");
            System.out.println("7. Back to Main Menu");
        }
    }

    private static void handleRentalOperations() {
        while (true) {
        System.out.println("\n=== Rental Operations ===");
        }
    }
    private static void handleReports() {
        while (true) {
            System.out.println("\n=== Reports ===");
        }
    }

}



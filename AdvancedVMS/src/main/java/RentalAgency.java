import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentalAgency {
    private String agencyName;
    List<Vehicle> agencyVehicles;
    List<RentalTransaction> transactions;

    public RentalAgency(String name) {
        this.agencyName = name;
        this.agencyVehicles = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }
    public String getAgencyName() {
        return agencyName;
    }
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    // This method creates a new list which all currently available vehicles are stored
    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : agencyVehicles) {
            if (vehicle.isAvailable()) {
                availableVehicles.add(vehicle);
            }
        }
        return availableVehicles;
    }
    public void addVehicle(Vehicle vehicle) {
        agencyVehicles.add(vehicle);
    }
    public void removeVehicle(int vehicleId) {
        agencyVehicles.removeIf(vehicle -> Objects.equals(vehicle.getVehicleId(), vehicleId));
    }
    public void rentVehicle(Customer customer, Vehicle vehicle, int daysRented) {
        if (!vehicle.isAvailable()) {
            throw new IllegalStateException("Vehicle is not available for rental.");
        }
        if (customer.getCurrentRentals().size() > 3) {
            throw new IllegalStateException("Customer has reached the maximum rental limit.");
        }
        LocalDate rentalDate = LocalDate.now();
        RentalTransaction transaction = new RentalTransaction(customer, vehicle, rentalDate, daysRented);
        transactions.add(transaction);
    }
    //return rented vehicle
    public void returnVehicle(RentalTransaction transaction) {
        if (transaction.isCompleted()){
            throw new IllegalStateException("Transaction is already completed. Vehicle returned.");
        }
        transaction.markAsCompleted();
    }
    public String generateRentalReport() {
        StringBuilder report = new StringBuilder();
        report.append("Rental Report for ").append(agencyName).append("\n");
        report.append("====================================\n");

        for (RentalTransaction transaction : transactions) {
            report.append(transaction.toString()).append("\n");
        }

        return report.toString();
    }
}

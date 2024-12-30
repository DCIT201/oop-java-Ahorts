import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RentalAgency {
    private String agencyName;
   private final List<Vehicle> agencyVehicles;
    private final List<RentalTransaction>  transactions;


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
    public List<Vehicle> getAgencyVehicles() {
        return agencyVehicles;
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
    public void rentVehicle(@NotNull Customer customer, @NotNull Vehicle vehicle, int daysRented) {
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
    public void returnVehicle(Vehicle vehicle) {

        for (RentalTransaction transaction : transactions) {
            if (transaction.getVehicle().equals(vehicle)) {
                transaction.markAsCompleted();
            }
        }
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

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static int id = 0;
    private final int customerId;
    private String name;
    private String email;
    private final List<Vehicle> currentRentals;
    private final List<Vehicle> rentalHistory;
    private boolean canRent = true;

    public Customer(String name, String email) {
        id++;
        this.customerId = id;
        this.name = name;
        this.email = email;
        rentalHistory = new ArrayList<>();
        currentRentals = new ArrayList<>();
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void addToHistory(Vehicle vehicle) {
        rentalHistory.add(vehicle);
    }
    public List<Vehicle> getRentalHistory() {
        return rentalHistory;
    }

    public void addRentals(Vehicle vehicle) {
        if (!canRent) throw new IllegalStateException("Customer has reached the maximum number of rentals");
        currentRentals.add(vehicle);
        rentalHistory.add(vehicle);
    }
    public List<Vehicle> getCurrentRentals() {
        return currentRentals;
    }

    public void setCanRent(boolean canRent) {
        this.canRent = canRent;
    }
    public void setCanRent() {
        this.canRent = currentRentals.size() < 4;
    }

    public boolean getCanRent() {
        return canRent;
    }

    public void returnVehicle(Vehicle vehicle) {
        if (!currentRentals.contains(vehicle)) throw new IllegalArgumentException("Customer has not rented this vehicle");
        currentRentals.remove(vehicle);
    }

}


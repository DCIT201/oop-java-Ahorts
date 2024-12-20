import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private String contact;
    private final List<Vehicle> rentalHistory;

    public Customer(String customerId, String name, String contact) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
        rentalHistory = new ArrayList<>();
    }
    public String getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getContact() {
        return contact;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public void addToHistory(Vehicle vehicle) {
        rentalHistory.add(vehicle);
    }
    public List<Vehicle> getRentalHistory() {
        return rentalHistory;
    }
}

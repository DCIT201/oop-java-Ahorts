// This class is to keep all records of transactions made in the agency
// We import java.time.LocalDate to be able to work with dates
import java.time.LocalDate;

public class RentalTransaction {
    private static int id = 0;
    private final int transactionId;
    private final Customer customer;
    private final Vehicle vehicle;
    private final LocalDate rentalDate;
    private  final int rentalDays;
    private boolean isCompleted;

    public RentalTransaction( Customer customer, Vehicle vehicle, LocalDate rentalDate, int rentalDays) {
        id++;
        this.transactionId = id;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDate = rentalDate;
        this.rentalDays = rentalDays;
        this.isCompleted = false;
       vehicle.rent(customer, rentalDays);
    }

    public Customer getCustomer() {
        return customer;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public LocalDate getRentalDate() {
        return rentalDate;
    }
    public boolean isCompleted() {
        return isCompleted;
    }
    public LocalDate getReturnDate(){
        return rentalDate.plusDays(rentalDays);
    }
    public double calculateTotalCost() {
        return vehicle.calculateRent(rentalDays);
    }

    // This method marks the transaction as complete when the customer returns the vehicle.
    public void markAsCompleted() {
        if (isCompleted) {
            throw new IllegalStateException("Transaction is already completed.");
        }
        isCompleted = true;
        vehicle.returnVehicle();
        customer.returnVehicle(vehicle);
    }

    // The toString method is overridden here to make basic info about a transaction available when debugging or logging
    // information
    @Override
    public String toString() {
        return "Transaction [transactionId=" + transactionId +
                ", customer=" + customer.getName() +
                ", vehicle=" + vehicle.getModel() +
                ", rentalDate=" + rentalDate +
                ", rentalDays=" + rentalDays +
                ", returnDate=" + this.getReturnDate() +
                ", isCompleted=" + isCompleted +
                " Cost=" + this.calculateTotalCost() + "]";
    }
}

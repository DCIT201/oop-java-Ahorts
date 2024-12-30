import java.util.HashSet;
import java.util.Set;

public abstract class Vehicle implements Rentable {
    private static int id = 0;
    private final int vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    private int seatCount;
    private String color;
    private String transmission;
    private String fuelType;
    // I decided to use a map which stores all the multipliers for the features of each vehicle subclass. The
    // activeFeatures stores the currently enabled features of the specified vehicle
    protected Set<String> activeFeatures;


    public Vehicle(String model, double baseRentalRate) {
        id++;
        this.vehicleId = id;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
        this.seatCount = 1;
        this.activeFeatures = new HashSet<>();
    }
    public int getVehicleId() {
        return vehicleId;
    }
    public String getModel() {
        return model;
    }
    public double getBaseRentalRate() {
        return baseRentalRate;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getTransmission() {
        return transmission;
    }
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    public String getFuelType() {
        return fuelType;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void setBaseRentalRate(double baseRentalRate) {
        this.baseRentalRate = baseRentalRate;
    }

    public abstract double calculateRent(int days);
    // The method below is declared abstract to be overridden by its subclasses based on specific features.
    // See Main.editVehicle() for implementation and reasoning
    public abstract void editFeatures();
    public abstract void viewFeatures();

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
    public int getSeatCount() {
        return seatCount;
    }
    public void returnVehicle(){
        setAvailable(true);
    }
    public void rent(Customer customer, int days){
        if (!this.isAvailable()) throw new IllegalStateException("Vehicle is not available");
        setAvailable(false);
        customer.addRentals(this);
    }

    @Override
    public String toString(){
        return "[Vehicle: " +  getClass().getSimpleName() + "." + " VehicleId=" + getVehicleId() + " Model=" + getModel() +
                ". Rental Rate=" + RentCalculator.calculateFinalRate(getBaseRentalRate(),activeFeatures) + "]";
    }

}

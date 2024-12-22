public abstract class Vehicle {
    private static int id = 0;
    private final int vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    private int seatCount;

    public Vehicle(String model, double baseRentalRate) {
        id++;
        this.vehicleId = id;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = true;
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

    public void setModel(String model) {
        this.model = model;
    }
    public void setBaseRentalRate(double baseRentalRate) {
        this.baseRentalRate = baseRentalRate;
    }

    public abstract double calculateRent(int days);

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }
    public int getSeatCount() {
        return seatCount;
    }

    @Override
    public String toString(){
        return "[Vehicle: " +  getClass().getSimpleName() + "." + " VehicleId=" + getVehicleId() + " Model=" + getModel() + "]";
    }

}

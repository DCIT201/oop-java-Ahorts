public abstract class Vehicle {
    private String vehicleId;
    private String model;
    private double baseRentalRate;
    private boolean isAvailable;
    private int seatCount;

    public Vehicle(String vehicleId, String model, double baseRentalRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRentalRate = baseRentalRate;
        this.isAvailable = false;
    }
    public String getVehicleId() {
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
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
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
        return "[Vehicle rented: " +  getClass().getSimpleName() + "." + " VehicleId=" + getVehicleId() + " Model=" + getModel() + "]";
    }

}

public class Car extends Vehicle {
    public Car(String vehicleId, String model, double baseRentalRate){
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRent(int days) {
        return getBaseRentalRate() * days;
    }
}

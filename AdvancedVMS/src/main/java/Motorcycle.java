public class Motorcycle extends Vehicle {

    public Motorcycle(String vehicleId, String model, double baseRentalRate){
        super(vehicleId, model, baseRentalRate);
    }
    @Override
    public double calculateRent(int days) {
        return days * super.getBaseRentalRate();
    }


}

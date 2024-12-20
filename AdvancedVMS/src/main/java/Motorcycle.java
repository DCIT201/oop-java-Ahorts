public class Motorcycle extends Vehicle implements Rentable{

    public Motorcycle(String vehicleId, String model, double baseRentalRate){
        super(vehicleId, model, baseRentalRate);
    }
    @Override
    public double calculateRent(int days) {
        return days * super.getBaseRentalRate();
    }

    public double rent(Customer customer, int days){
        if (!super.isAvailable()) throw new IllegalStateException("Motorcycle is not available");

        setAvailable(false);
        double cost = calculateRent(days);
        customer.addToHistory(this);
        return cost;
    }

    public void returnVehicle(){
        setAvailable(true);
    }
}

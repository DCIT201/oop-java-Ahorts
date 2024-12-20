public class Truck extends Vehicle implements Rentable{
    private boolean hasAirConditioners;

    public Truck(String vehicleId, String model, double baseRentalRate){
        super(vehicleId, model, baseRentalRate);
    }

    @Override
    public double calculateRent(int days) {
        if (hasAirConditioners) {
            return days * super.getBaseRentalRate() * 1.5;
        }
        return days * super.getBaseRentalRate();
    }

    public void setHasAirConditioners(boolean hasAirConditioners){
        this.hasAirConditioners = hasAirConditioners;
    }
    public boolean getHasAirConditioners(){
        return this.hasAirConditioners;
    }

    public double rent(Customer customer, int days){
        if (!super.isAvailable()) throw new IllegalStateException("Truck is not available");

        setAvailable(false);
        double cost = calculateRent(days);
        customer.addToHistory(this);
        return cost;
    }

    public void returnVehicle(){
        setAvailable(true);
    }



}

public class Car extends Vehicle implements Rentable{
    private boolean hasAirConditioners;
    public Car( String model, double baseRentalRate){
        super( model, baseRentalRate);
    }

    public void setHasAirConditioners(boolean hasAirConditioners){
        this.hasAirConditioners = hasAirConditioners;
    }
    public boolean getHasAirConditioners(){
        return this.hasAirConditioners;
    }

    @Override
    public double calculateRent(int days) {
        if (hasAirConditioners){
            return getBaseRentalRate() * days * 1.5;
        }
        return getBaseRentalRate() * days;
    }

    public double rent(Customer customer, int days){
        if (!super.isAvailable()) throw new IllegalStateException("Car is not available");

        setAvailable(false);
        double cost = calculateRent(days);
        customer.addToHistory(this);
        return cost;
    }

    public void returnVehicle(){
        setAvailable(true);
    }
}

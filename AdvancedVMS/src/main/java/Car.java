public class Car extends Vehicle {
    private boolean hasAirConditioners;

    public Car(String vehicleId, String model, double baseRentalRate){
        super(vehicleId, model, baseRentalRate);
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
}

public class Car extends Vehicle implements Rentable{
    private boolean hasAirConditioners;
    private boolean hasChildSeats;
    private boolean hasGPS;
    private boolean hasCamera;
    public Car( String model, double baseRentalRate){
        super( model, baseRentalRate);
        hasCamera = false;
        hasGPS = false;
        hasAirConditioners = false;
        hasChildSeats = false;
    }

    public void setHasAirConditioners(boolean hasAirConditioners){
        this.hasAirConditioners = hasAirConditioners;
    }
    public boolean getHasAirConditioners(){
        return this.hasAirConditioners;
    }
    public void setHasChildSeats(boolean hasChildSeats){
        this.hasChildSeats = hasChildSeats;
    }
    public boolean getHasChildSeats(){
        return hasChildSeats;
    }
    public void setHasGPS(boolean hasGPS){
        this.hasGPS = hasGPS;
    }
    public boolean getHasGPS(){
        return hasGPS;
    }
    public void setHasCamera(boolean hasCamera){
        this.hasCamera = hasCamera;
    }
    public boolean getHasCamera(){
        return hasCamera;
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

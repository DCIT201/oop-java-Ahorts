public class Car extends Vehicle implements Rentable{
    private boolean hasAirConditioners;
    private boolean hasChildSeats;
    private boolean hasGPS;
    private boolean hasCamera;
    public Car( String model, double baseRentalRate){
        super( model, baseRentalRate);

    }

    public void setHasAirConditioners(boolean hasAirConditioners){
        if(hasAirConditioners){
            activeFeatures.add("AC");
        }else {
            activeFeatures.remove("AC");
        }
        this.hasAirConditioners = hasAirConditioners;
    }
    public boolean getHasAirConditioners(){
        return this.hasAirConditioners;
    }
    public void setHasChildSeats(boolean hasChildSeats){
        if(hasChildSeats){
            activeFeatures.add("CHILD_SEAT");
        }
        else{
            activeFeatures.remove("CHILD_SEAT");
        }
        this.hasChildSeats = hasChildSeats;
    }
    public boolean getHasChildSeats(){
        return hasChildSeats;
    }
    public void setHasGPS(boolean hasGPS){
        if (hasGPS){
            activeFeatures.add("GPS");
        } else {
            activeFeatures.remove("GPS");
        }
        this.hasGPS = hasGPS;
    }
    public boolean getHasGPS(){
        return hasGPS;
    }
    public void setHasCamera(boolean hasCamera){
        if(hasCamera){
            activeFeatures.add("CAMERA");
        } else {
            activeFeatures.remove("CAMERA");
        }
        this.hasCamera = hasCamera;
    }
    public boolean getHasCamera(){
        return hasCamera;
    }
    @Override
    public double calculateRent(int days) {
        return days * RentCalculator.calculateFinalRate(getBaseRentalRate(), activeFeatures);
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

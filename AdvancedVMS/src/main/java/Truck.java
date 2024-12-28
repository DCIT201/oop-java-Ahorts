public class Truck extends Vehicle implements Rentable{
    private boolean hasAirConditioners;
    private boolean hasCamera;
    private boolean hasGPS;
    private boolean hasHydraulics;

    public Truck( String model, double baseRentalRate){
        super(model, baseRentalRate);
        hasCamera = false;
        hasGPS = false;
        hasAirConditioners = false;
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
    public void setHasHydraulics(boolean hasHydraulics){
        this.hasHydraulics = hasHydraulics;
    }
    public boolean getHasHydraulics(){
        return hasHydraulics;
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

public class Truck extends Vehicle{
    private boolean hasAirConditioners;
    private boolean hasCamera;
    private boolean hasGPS;
    private boolean hasHydraulics;

    public Truck( String model, double baseRentalRate){
        super(model, baseRentalRate);
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
    public void setHasHydraulics(boolean hasHydraulics){
        if (hasHydraulics){
            activeFeatures.add("HYDRAULICS");
        } else {
            activeFeatures.remove("HYDRAULICS");
        }
        this.hasHydraulics = hasHydraulics;
    }
    public boolean getHasHydraulics(){
        return hasHydraulics;
    }

    @Override
    public double calculateRent(int days) {
        return days * RentCalculator.calculateFinalRate(getBaseRentalRate(), activeFeatures);
    }
    public void editFeatures(){
        setHasAirConditioners(Main.getBoolean("Has Air Conditioners? (true/false): "));
        setHasCamera(Main.getBoolean("Has camera? (true/false): "));
        setHasGPS(Main.getBoolean("Has GPS? (true/false): "));
        setHasHydraulics(Main.getBoolean("Has Hydraulics? (true/false): "));
    }
    public void viewFeatures(){
        System.out.println("Has Air Conditioners?: " + getHasAirConditioners());
        System.out.println("Has Camera?: " + getHasCamera());
        System.out.println("Has GPS?: " + getHasGPS());
        System.out.println("Has Hydraulics?: " + getHasHydraulics());
    }

    public void setHasAirConditioners(boolean hasAirConditioners){
        if (hasAirConditioners) {
            activeFeatures.add("AC");
        } else {
            activeFeatures.remove("AC");
        }
        this.hasAirConditioners = hasAirConditioners;
    }
    public boolean getHasAirConditioners(){
        return this.hasAirConditioners;
    }

}

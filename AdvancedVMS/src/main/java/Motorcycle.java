public class Motorcycle extends Vehicle implements Rentable{
    private boolean hasHelmet;
    private boolean hasStorageBox;
    private boolean hasWindshield;

    public Motorcycle( String model, double baseRentalRate){
        super(model, baseRentalRate);
        this.hasHelmet = false;
        this.hasStorageBox = false;
        this.hasWindshield = false;
    }
    public void setHasStorageBox(boolean hasStorageBox){
        this.hasStorageBox = hasStorageBox;
    }
    public void setHasHelmet(boolean hasHelmet){
        this.hasHelmet = hasHelmet;
    }
    public void setHasWindshield(boolean hasWindshield){
        this.hasWindshield = hasWindshield;
    }
    public boolean hasHelmet(){
        return this.hasHelmet;
    }
    public boolean hasStorageBox(){
        return this.hasStorageBox;
    }
    public boolean hasWindshield(){
        return this.hasWindshield;
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

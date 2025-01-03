public class Motorcycle extends Vehicle {
    private boolean hasHelmet;
    private boolean hasStorageBox;
    private boolean hasWindshield;

    public Motorcycle( String model, double baseRentalRate){
        super(model, baseRentalRate);
    }
    public void setHasStorageBox(boolean hasStorageBox){
        if (hasStorageBox){
            activeFeatures.add("STORAGE");
        } else {
            activeFeatures.remove("STORAGE");
        }
        this.hasStorageBox = hasStorageBox;
    }
    public void setHasHelmet(boolean hasHelmet) {
        if (hasHelmet){
            activeFeatures.add("HELMET");
        } else {
            activeFeatures.remove("HELMET");
        }
        this.hasHelmet = hasHelmet;
    }
    public void setHasWindshield(boolean hasWindshield){
        if (hasWindshield){
            activeFeatures.add("WINDSHIELD");
        } else {
            activeFeatures.remove("WINDSHIELD");
        }
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
        return days * RentCalculator.calculateFinalRate(getBaseRentalRate(), activeFeatures);
    }
    public void editFeatures(){
        activeFeatures.clear();
        setHasHelmet(Main.getBoolean("Has Helmet? (true/false): "));
        setHasWindshield(Main.getBoolean("Has Windshield? (true/false): "));
        setHasStorageBox(Main.getBoolean("Has Storage Box? (true/false): "));
    }
    public void viewFeatures(){
        System.out.println("Has Helmet?: " + hasHelmet());
        System.out.println("Has Windshield?: " + hasWindshield());
        System.out.println("Has StorageBox?: " + hasStorageBox());
    }


}

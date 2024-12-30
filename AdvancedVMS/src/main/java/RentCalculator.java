import java.util.HashMap;
import java.util.Map;
import java.util.Set;
// This class is made to calculate the increase in price based on the available features. This is to also help
// me add new features down the line without rewriting code.
public class RentCalculator {
    private static final Map<String, Double> MULTIPLIERS = new HashMap<>();
    static {
        MULTIPLIERS.put("AC", 1.5);
        MULTIPLIERS.put("GPS", 1.1);
        MULTIPLIERS.put("CHILD_SEAT", 1.1);
        MULTIPLIERS.put("CAMERA", 1.05);
        MULTIPLIERS.put("HELMET", 1.1);
        MULTIPLIERS.put("STORAGE", 1.05);
        MULTIPLIERS.put("WINDSHIELD", 1.05);
        MULTIPLIERS.put("HYDRAULICS", 1.20);
    }
    public static double calculateFinalRate(double baseRate, Set<String> features) {
        double finalRate = baseRate;
        for (String feature : features) {
            Double multiplier = MULTIPLIERS.get(feature);
            if (multiplier != null) {
                finalRate *= multiplier;
            }
        }
        return finalRate;
    }


}

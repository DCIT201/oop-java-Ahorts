import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TruckTest {
    private Truck truck;

    @BeforeEach
    void setUp() {
        truck = new Truck("TRUCK001", "MAN TGX", 800);
        truck.setAvailable(true);
    }

    @Test
    void testCalculateRentalCost() {
        assertEquals(1600, truck.calculateRent(2), "Rental cost calculation failed");
        truck.setHasAirConditioners(true);
        assertEquals(2400, truck.calculateRent(2), "Rental cost calculation failed");
    }

    @Test
    void testIsAvailableForRental() {
        assertTrue(truck.isAvailable(), "Truck is not available");
    }

    @Test
    void testHasAirConditioners() {
        truck.setHasAirConditioners(true);
        assertTrue(truck.getHasAirConditioners(), "No Air conditioning");
    }


}

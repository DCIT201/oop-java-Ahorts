import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


 class MotorcycleTest {
     private Motorcycle motorcycle;
     @BeforeEach
     void setUp() {
         motorcycle = new Motorcycle("MOTOR001", "DUCATI DESERT", 100);
         motorcycle.setAvailable(true);
     }

     @Test
     void testCalculateRentalCost() {
         assertEquals(500, motorcycle.calculateRent(5), "Rental cost calculation failed");
     }

     @Test
     void testIsAvailableForRental() {
         assertTrue(motorcycle.isAvailable(), "Motorcycle is not available");
     }

     @Test
     void testSetAndGetSeatingCapacity() {
         motorcycle.setSeatCount(1);
         assertEquals(1, motorcycle.getSeatCount(), "Seating capacity getter/setter failed");
     }

     @Test
     void testEncapsulation() {
         motorcycle.setVehicleId("CAR002");
         assertEquals("CAR002", motorcycle.getVehicleId(), "Encapsulation test failed for Vehicle ID");
     }

}


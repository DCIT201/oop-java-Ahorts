import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


 class CarTest {
     private Car car;

     @BeforeEach
     void setUp() {
         car = new Car("CAR001", "Toyota Camry", 300);
         car.setAvailable(true);

     }

     @Test
     void testCalculateRentalCost() {
         assertEquals(900, car.calculateRent(3), "Rental cost calculation failed");
         car.setHasAirConditioners(true);
         assertEquals(1350, car.calculateRent(3), "Rental cost calculation failed");
     }

     @Test
     void testIsAvailableForRental() {
         assertTrue(car.isAvailable(), "Availability check failed");
     }

     @Test
     void testHasAirConditioners() {
         car.setHasAirConditioners(true);
         assertTrue(car.getHasAirConditioners(), "Air conditioning check failed");
     }


}

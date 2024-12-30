import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class CustomerTest {
    private Customer customer;
    private Car car;
    private Truck truck;
    private Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        customer = new Customer( "David Mason", "david.mason@gmail.com");
         car = new Car( "Honda Accord", 100);
         truck = new Truck("Ford F-150", 300);
         motorcycle = new Motorcycle("DUCATI DESERT", 100);
    }
    @Test
    void testCustomerDetails() {
        assertEquals(2, customer.getCustomerId(), " Customer ID is incorrect");
        assertEquals("David Mason", customer.getName(), " Customer Name is incorrect");
        assertEquals("david.mason@gmail.com", customer.getEmail(), " Customer Email is incorrect");
    }
    @Test
    void testSetDetails() {

        customer.setName("Simon Riley");
        customer.setEmail("ghost@gmail.com");
        assertEquals("Simon Riley", customer.getName(), " Customer Name is incorrect");
        assertEquals("ghost@gmail.com", customer.getEmail(), " Customer Email is incorrect");
    }
    @Test
    void testAddToHistory() {
        customer.addToHistory(car);
        customer.addToHistory(truck);

        List<Vehicle> rentalHistory = customer.getRentalHistory();
        assertEquals(2, rentalHistory.size());
        assertEquals(truck, rentalHistory.get(1));
        assertEquals(car, rentalHistory.get(0));
    }
    @Test
    void testCurrentRentals(){
        customer.addRentals(car);
        customer.addRentals(truck);
        assertEquals(2, customer.getCurrentRentals().size());

    }
    @Test
    void testCustomerEligibility() {
        assertTrue( customer.getCanRent());
       customer.setCanRent(false);
        assertFalse( customer.getCanRent());

        customer.setCanRent(true);

        Car car2 = new Car( "Hyundai Sonata", 100);
        customer.addRentals(car);
        customer.addRentals(truck);
        customer.addRentals(motorcycle);
        customer.addRentals(car2);

        customer.setCanRent();
        assertFalse( customer.getCanRent());
    }
    @Test
    void testReturnVehicle() {
        customer.addRentals(car);
        customer.addRentals(truck);
        customer.returnVehicle(car);
        assertEquals(1, customer.getCurrentRentals().size());
    }
    @Test
    void testDiscountEligibility(){
        assertFalse(customer.isEligibleForDiscount());
    }

}

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.time.LocalDate;

public class RentalAgencyTest {
    private RentalAgency rentalAgency;
    private Car car;
    private Motorcycle motorcycle;
    private Truck truck;
    private Customer customer;
    private RentalTransaction transaction;

    // Initialize some mock data to be used in the tests
    @BeforeEach
    void setUp() {
        rentalAgency = new RentalAgency("Ahorts Rentals");
        customer = new Customer("John Doe", "jd@gmail.com");
        car = new Car( "Toyota Corolla", 50);
        motorcycle = new Motorcycle("Harley Davidson", 30.0);
        truck = new Truck( "Ford F-150", 100.0);

        rentalAgency.addVehicle(car);
        rentalAgency.addVehicle(truck);
        rentalAgency.addVehicle(motorcycle);
    }
    @Test
    void testAddVehicle() {
        List<Vehicle> fleet = rentalAgency.getAvailableVehicles();
        assertTrue(fleet.contains(car));
        assertEquals(3, fleet.size());
    }
    @Test
     void testRemoveVehicle() {
        rentalAgency.removeVehicle(car);

        List<Vehicle> fleet = rentalAgency.getAvailableVehicles();
        assertFalse(fleet.contains(car));
        assertEquals(2, fleet.size());
    }
    @Test
     void testRentVehicleSuccess() {


        assertNotNull(transaction);
        assertEquals(customer, transaction.getCustomer());
        assertEquals(car, transaction.getVehicle());
        assertFalse(car.isAvailable());
    }
    @Test
    void testGenerateRentalReport() {
        // Rent two vehicles
        rentalAgency.rentVehicle(customer, car, 3);
        rentalAgency.rentVehicle(customer, motorcycle, 2);

//        String report = rentalAgency.generateRentalReport();
//        assertTrue(report.contains("Customer: John Doe"));
//        assertTrue(report.contains("Vehicle rented: Toyota Corolla"));
//        assertTrue(report.contains("Vehicle rented: Harley Davidson"));
    }


}

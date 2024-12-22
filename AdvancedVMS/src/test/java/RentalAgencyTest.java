import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        customer = new Customer("CUST001", "John Doe", "jd@gmail.com");
        car = new Car("CAR001", "Toyota Corolla", 50);
        motorcycle = new Motorcycle("MOTO001", "Harley Davidson", 30.0);
        truck = new Truck("TRUCK001", "Ford F-150", 100.0);

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
        agency.removeVehicle(car.getVehicleId());

        List<Vehicle> fleet = agency.getAvailableVehicles();
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
        agency.rentVehicle(customer, car, 3);
        agency.rentVehicle(customer, motorcycle, 2);

        String report = agency.generateRentalReport();
        assertTrue(report.contains("Customer: John Doe"));
        assertTrue(report.contains("Vehicle rented: Toyota Corolla"));
        assertTrue(report.contains("Vehicle rented: Harley Davidson"));
    }


}

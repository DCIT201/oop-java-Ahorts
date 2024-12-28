import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RentalAgencyTest {
    private RentalAgency rentalAgency;
    private Car car;
    private Motorcycle motorcycle;
    private Truck truck;
    private Customer customer;

    // Initialize some mock data to be used in the tests
    @BeforeEach
    void setUp() {
        rentalAgency = new RentalAgency("Ahorts Rentals");
        customer = new Customer("John Doe", "jd@gmail.com");
        car = new Car( "Toyota Corolla", 20);
        motorcycle = new Motorcycle("Harley Davidson", 50.0);
        truck = new Truck( "Ford F-150", 500.0);

        rentalAgency.addVehicle(car);
        rentalAgency.addVehicle(truck);
        rentalAgency.addVehicle(motorcycle);


    }
    @Test
    void testGetAgencyName() {
        assertEquals("Ahorts Rentals", rentalAgency.getAgencyName());
        rentalAgency.setAgencyName("Ojoe Rentals");
        assertEquals("Ojoe Rentals", rentalAgency.getAgencyName());
    }
    @Test
    void testAvailableVehicle() {
        // The 3 vehicles added initially are not rented so there are 3 vehicles available for rent.
        // After renting 2 vehicles, the number of vehicles available for rent should be one.

        assertTrue(rentalAgency.getAvailableVehicles().contains(car));
        assertEquals(3, rentalAgency.getAvailableVehicles().size());

        rentalAgency.rentVehicle(customer, car, 3);
        rentalAgency.rentVehicle(customer, motorcycle, 2);
        assertEquals(1, rentalAgency.getAvailableVehicles().size());
    }

    // Test to verify how many vehicles are at the agency
    @Test
    void testAgencyVehicle() {
        assertEquals(3, rentalAgency.getAvailableVehicles().size());
    }
    @Test
     void testRemoveVehicle() {
        System.out.println(rentalAgency.getAgencyVehicles());
        // Vehicle id can change resulting in failed test
        // TODO: Change test structure
        rentalAgency.removeVehicle(8);

        assertFalse( rentalAgency.getAgencyVehicles().contains(motorcycle));
        assertEquals(2,  rentalAgency.getAgencyVehicles().size());
        System.out.println(rentalAgency.getAgencyVehicles());
    }
    @Test
     void testRentVehicle() {
        rentalAgency.rentVehicle(customer, truck, 5);
        assertFalse(truck.isAvailable());

    }
    @Test
    void testGenerateRentalReport() {
        // Rent 3 vehicles
        rentalAgency.rentVehicle(customer, car, 3);
        rentalAgency.rentVehicle(customer, motorcycle, 2);
        rentalAgency.rentVehicle(customer, truck, 10);

        String report = rentalAgency.generateRentalReport();

        assertTrue(report.contains("customer=John Doe"));
        assertTrue(report.contains("vehicle=Toyota Corolla"));
        assertTrue(report.contains("vehicle=Harley Davidson"));
    }
    @Test
    void testReturnVehicle() {
        rentalAgency.rentVehicle(customer, truck, 10);
        rentalAgency.rentVehicle(customer, motorcycle, 2);
        assertFalse(truck.isAvailable());

        rentalAgency.returnVehicle(truck);
        assertTrue(truck.isAvailable());
        assertEquals(1, customer.getCurrentRentals().size());

    }

}

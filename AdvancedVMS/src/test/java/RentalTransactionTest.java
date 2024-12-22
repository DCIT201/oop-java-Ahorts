import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

 class RentalTransactionTest {
   private RentalTransaction rentalTransaction;
   private Car car;
   private Customer customer;

   // setting up required classes for test cases
   @BeforeEach
  void setUp() {
    car = new Car( "BMW M5", 200);
    customer = new Customer("John Doe", "jd@gmail.com");
    rentalTransaction = new RentalTransaction( customer, car, LocalDate.of(2024,12,7), 5);
   }
   @Test
  void testRentDate(){
    assertEquals(LocalDate.of(2024, 12, 7), rentalTransaction.getRentalDate());
   }
   @Test
  void testReturnDate(){
    assertEquals(LocalDate.of(2024,12, 12), rentalTransaction.getReturnDate());
   }
   @Test
  void testCompletion(){
    customer.addRentals(car); // This is required to ensure an error is not thrown
    rentalTransaction.markAsCompleted();
    assertTrue(rentalTransaction.isCompleted());
   }
}

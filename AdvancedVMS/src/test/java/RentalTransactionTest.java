import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

 class RentalTransactionTest {
   private RentalTransaction rentalTransaction;
   private Car car;
   private Customer customer;

   @BeforeEach
  void setUp() {
    car = new Car("CAR001", "BMW M5", 200);
    customer = new Customer("CUST001", "John Doe", "jd@gmail.com");
    rentalTransaction = new RentalTransaction("TRANS001", customer, car, LocalDate.of(2024,12,7), 5);
   }
   @Test
  void testRentDate(){
    assertEquals(LocalDate.of(2024, 12, 7), rentalTransaction.getRentDate());
   }
   @Test
  void testReturnDate(){
    assertEquals(LocalDate.of(2024,12, 12), rentalTransaction.getReturnDate());
   }
}

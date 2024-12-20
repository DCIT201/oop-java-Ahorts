import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


 class CarTest {
     private Car car;

     @BeforeEach
     void setUp() {
         car = new Car("CAR001", "Toyota Camry", 100);
     }

}

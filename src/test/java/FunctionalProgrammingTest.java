import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionalProgrammingTest {

  Function<Integer, Integer> square = x -> x * x;

  //JUnit
  @Test
  public void testSquareFunction() {
    Assertions.assertEquals(25, square.apply(5).intValue());
    Assertions.assertEquals(0, square.apply(0).intValue());
    Assertions.assertEquals(4, square.apply(-2).intValue());
  }

}

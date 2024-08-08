import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    Calculator calc = new Calculator();

    @Test
    public void testPlus() {
        int a = 2;
        int b = 3;
        int expected = 5;
        int result = calc.plus.apply(a,b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMinus() {
        int a = 5;
        int b = 3;
        int expected = 2;
        int result = calc.minus.apply(a,b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMultiply() {
        int a = 5;
        int b = 3;
        int expected = 15;
        int result = calc.multiply.apply(a,b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDivide() {
        int a = 15;
        int b = 3;
        int expected = 5;
        int result = calc.divide.apply(a,b);
        Assertions.assertEquals(expected, result);
    }
}

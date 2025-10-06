package level3;

import level1ex1.BooksManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void checkSum() {
        assertEquals(3.7f, Calculator.sum(2.5, 1.2), 0.0001);
    }

    @Test
    void checkSubstraction() {
        assertEquals(5.8, Calculator.substraction(12.2, 6.4), 0.0001);
    }

    @Test
    void checkMultiplication() {
        assertEquals(7.7, Calculator.multiplication(3.5, 2.2), 0.0001);
    }

    @Test
    void checkDivision() {
        assertEquals(4.5, Calculator.division(9.0, 2.0), 0.0001);
    }
}

package level3;

import level1ex1.BooksManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void checkSum() {
        assertEquals(3.7f, Calculator.sum(2.5f, 1.2f));
    }

    @Test
    void checkSubstraction() {
        assertEquals(5.8f, Calculator.substraction(12.2f, 6.4f));
    }

    @Test
    void checkMultiplication() {
        assertEquals(7.7f, Calculator.multiplication(3.5f, 2.2f));
    }

    @Test
    void checkDivision() {
        assertEquals(4.5f, Calculator.division(9.0f, 2.0f));
    }
}

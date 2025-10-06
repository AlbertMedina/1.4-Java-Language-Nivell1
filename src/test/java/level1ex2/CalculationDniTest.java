package level1ex2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationDniTest {

    @ParameterizedTest
    @MethodSource("dniNumbersAndLetters")
    void checkCalculateDNILetter(long dniNumber, char dniLetter) {
        assertEquals(dniLetter, CalculationDni.calculateDNILetter(dniNumber));
    }

    static Stream<Arguments> dniNumbersAndLetters() {
        return Stream.of(
                Arguments.of(12345678, 'Z'),
                Arguments.of(87654321, 'X'),
                Arguments.of(1, 'R'),
                Arguments.of(0, 'T'),
                Arguments.of(99999999, 'R'),
                Arguments.of(11111111, 'H'),
                Arguments.of(55555555, 'K'),
                Arguments.of(24681012, 'B'),
                Arguments.of(10305070, 'N'),
                Arguments.of(98765432, 'M')
        );
    }
}

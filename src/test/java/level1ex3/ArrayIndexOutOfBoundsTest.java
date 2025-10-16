package level1ex3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayIndexOutOfBoundsTest {

    @Test
    void shouldThrowArrayIndexOutOfBoundsException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, ArrayIndexOutOfBounds::triggerArrayIndexOutOfBounds);
    }
}

package level2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIndexOutOfBoundsException;

public class AssertJAssertionsTest {

    @Test
    public void shouldValuesBeEqual() {
        int a = 1;
        int b = 1;
        int c = 2;
        assertThat(a).isEqualTo(b);
        assertThat(a).isNotEqualTo(c);
    }

    @Test
    public void shouldObjectsBeEqual() {
        String a = "Hello";
        String b = "Hello";
        String c = "Welcome";
        assertThat(a).isEqualTo(b);
        assertThat(a).isNotEqualTo(c);
    }

    @Test
    public void shouldArraysBeEqual() {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        assertThat(a).isEqualTo(b);
    }

    @Test
    public void shouldListContainCorrectValues() {
        String myString = "Albert";
        Character myChar = 'A';
        Boolean myBoolean = true;
        Float myFloat = 1.0f;
        List<Object> list = new ArrayList<>(List.of(myString, myChar, myBoolean));
        assertThat(list).containsExactly(myString, myChar, myBoolean);
        assertThat(list).containsExactlyInAnyOrder(myBoolean, myString, myChar);
        assertThat(list).containsOnlyOnce(myString);
        assertThat(list).doesNotContain(myFloat);
    }

    @Test
    public void shouldMapContainKey() {
        Map<String, Integer> myGrades = new HashMap<>();
        myGrades.put("English", 8);
        myGrades.put("History", 10);
        myGrades.put("Biology", 6);
        assertThat(myGrades).containsKey("History");
    }

    @Test
    public void shouldThrowArrayIndexOutOfBoundsException() {
        assertThatIndexOutOfBoundsException()
                .isThrownBy(() -> AssertJAssertions.getNumberName(8));
    }

    @Test
    public void shouldOptionalBeEmpty() {
        Optional<String> myOptional = Optional.empty();
        assertThat(myOptional).isEmpty();
    }
}

package level1ex2;

public class CalculationDni {

    private static final String DNI_LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public static char calculateDNILetter(long dniNumber) {
        if (dniNumber < 0 || dniNumber > 99999999) {
            throw new IllegalArgumentException("A DNI number must be between 0 and 99999999.");
        }
        int index = (int) (dniNumber % 23);
        return DNI_LETTERS.charAt(index);
    }
}

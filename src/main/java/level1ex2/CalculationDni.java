package level1ex2;

public class CalculationDni {

    private static final String DNI_LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public CalculationDni() {
    }

    public static char calculateDNILetter(long dniNumber) {
        char dniLetter = ' ';
        try {
            if (dniNumber < 0 || dniNumber > 99999999) {
                throw new IllegalArgumentException("A DNI number must be between 0 and 99999999.");
            }

            int index = (int) (dniNumber % 23);
            dniLetter = DNI_LETTERS.charAt(index);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid DNI number: " + e.getMessage());
        }

        return dniLetter;
    }
}

package level1ex2;

public class CalculationDni {

    private static final String DNI_LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public CalculationDni() {
    }

    public static char calculateDNILetter(long dniNumber) {
        char dniLetter = ' ';
        try {
            if (String.valueOf(dniNumber).length() != 8) {
                throw new IllegalArgumentException("A DNI number must have 8 digits.");
            }

            int index = (int) (dniNumber % 23);
            dniLetter = DNI_LETTERS.charAt(index);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid DNI number: " + e.getMessage());
        }

        return dniLetter;
    }
}

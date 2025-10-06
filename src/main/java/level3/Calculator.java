package level3;

public class Calculator {

    public Calculator() {
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double subtraction(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("We cannot divide by 0.");
        }
        return a / b;
    }
}

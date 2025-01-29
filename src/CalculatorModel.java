public class CalculatorModel {
    private Double storedNumber = null;

    // Basic operations
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    // Advanced operations
    public double exponentiate(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public double sine(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public double cosine(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public double tangent(double angle) {
        return Math.tan(Math.toRadians(angle));
    }

    // Store and recall number
    public void storeNumber(double number) {
        storedNumber = number;
    }

    public Double recallNumber() {
        if (storedNumber == null) {
            throw new IllegalStateException("No number stored");
        }
        return storedNumber;
    }
}

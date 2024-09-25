import java.util.*;

public  class Caculation {
    public double add(double a, double b) {
        return a + b;
    }
    public double sub(double a, double b) {
        return a - b;
    }
    public double mul(double a, double b) {
        return a * b;
    }
    public double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x, y;
        System.out.print("Enter the first operand: ");
        x = sc.nextDouble();
        System.out.print("Enter the second operand: ");
        y = sc.nextDouble();
        Caculation cal = new Caculation();
        System.out.printf("Sum of two operands is: %.2f%n", cal.add(x, y));
        System.out.printf("Difference of two operands is: %.2f%n", cal.sub(x, y));
        System.out.printf("Product of two operands is: %.2f%n", cal.mul(x, y));
        System.out.printf("Quotient of two operands is: %.2f%n", cal.div(x, y));
        sc.close();
    }
}
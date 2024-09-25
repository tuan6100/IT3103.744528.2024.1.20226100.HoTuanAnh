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
    public double div(double a, double b) throws ArithmeticException {
        return a / b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x, y;
        System.out.println("Enter the first operand: ");
        x = sc.nextDouble();
        System.out.println("Enter the second operand: ");
        y = sc.nextDouble();
        Caculation cal = new Caculation();
        System.out.println("Sum of two operands is: %,2f", cal.add(x, y));
        System.out.println("Difference of two operands is: %,2f", cal.sub(x, y));
        System.out.println("Product of two operands is: %,2f", cal.mul(x, y));
        System.out.println("Sum of two operands is: %,2f", cal.div(x,y));
    }
}
package problem2_2_6;
import java.util.*;

class SecondDegreeEquation {
    private double a, b, c;
    private Scanner sc;

    public SecondDegreeEquation() {
        this.sc = new Scanner(System.in);
    }

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }

    public void setA() {
        System.out.print("a = ");
        this.a = sc.nextDouble();
    }
    public void setB() {
        System.out.print("b = ");
        this.b = sc.nextDouble();
    }
    public void setC() {
        System.out.print("c = ");
        this.c = sc.nextDouble();
    }

    public void solve() throws Exception{
        if (a == 0) {
            throw new Exception("Not the format of second degree equation.\n");
        }
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta < 0) {
            System.out.println("No solution \n");
        } else if (delta == 0) {
            System.out.printf("The solution is: x = %.2f\n", -b / (2*a));
        } else {
            System.out.printf("The solutions are: x1 = %.2f and x2 = %.2f\n", (-b + Math.sqrt(delta)) / (2*a) , (-b - Math.sqrt(delta)) / (2*a));
        }
    }

    public void done() {
        sc.close();
    }
}

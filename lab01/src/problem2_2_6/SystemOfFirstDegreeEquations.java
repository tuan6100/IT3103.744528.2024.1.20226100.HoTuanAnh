package problem2_2_6;
import java.util.*;

class SystemOfFirstDegreeEquations {
    private double a11, a12, b1, a21, a22, b2;
    private Scanner sc;

    public SystemOfFirstDegreeEquations() {
        this.sc = new Scanner(System.in);
    }

    public double getA11() {
        return a11;
    }
    public double getA12() {
        return a12;
    }
    public double getB1() {
        return b1;
    }
    public double getA21() {
        return a21;
    }
    public double getA22() {
        return a22;
    }
    public double getB2() {
        return b2;
    }

    public void setA11() {
        System.out.print("a11 = ");
        this.a11 = sc.nextDouble();
    }
    public void setA12() {
        System.out.print("a12 = ");
        this.a12 = sc.nextDouble();
    }
    public void setB1() {
        System.out.print("b1 = ");
        this.b1 = sc.nextDouble();
    }
    public void setA21() {
        System.out.print("a21 = ");
        this.a21 = sc.nextDouble();
    }
    public void setA22() {
        System.out.print("a22 = ");
        this.a22 = sc.nextDouble();
    }
    public void setB2() {
        System.out.print("b2 = ");
        this.b2 = sc.nextDouble();
    }
   
    public void solve() {
        double D = a11*a22 - a12*a21, Dx = b1*a22 - b2*a12, Dy = a11*b2 - a21*b1;
        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
            System.out.println("The system has infinitely many solutions.\n");
            } else {
            System.out.println("The system has no solution.\n");
            }
        } else {
            double x = Dx / D;
            double y = Dy / D;
            System.out.printf("The solutions are: x = %.2f and y = %.2f\n", x, y);
        }
    }

    public void done() {
        sc.close();
    }
}

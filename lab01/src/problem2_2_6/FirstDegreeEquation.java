package problem2_2_6;
import java.util.*;

class FirstDegreeEquation {
    private double a, b;
    private Scanner sc;

    public FirstDegreeEquation() {
        this.sc = new Scanner(System.in);
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }

    public void setA() {
        System.out.print("a =  ");
        this.a = sc.nextDouble();
    }
    public void setB() {
        System.out.print("b = ");
        this.b = sc.nextDouble();
    }

    public void solve() throws Exception{
        if (a == 0) {
            throw new Exception("Not the format of first degree equation.\n");
        }
        System.out.printf("The solution is: x = %.2f\n", -b / a);
    } 

    public void done() {
        sc.close();
    }
}
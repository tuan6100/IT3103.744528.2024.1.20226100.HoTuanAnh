package hust.soict.itep.lab01.problem2_2_6;
import javax.swing.*;

class FirstDegreeEquation {
    private double a, b;

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }

    public void setA() {
        String input = JOptionPane.showInputDialog(null, "Ho Tuan Anh 20226100  a = ");
        this.a = Double.parseDouble(input);
    }
    public void setB() {
        String input = JOptionPane.showInputDialog(null, "Ho Tuan Anh 20226100  b = ");
        this.b = Double.parseDouble(input);
    }

    public void solve() throws IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("Ho Tuan Anh 20226100 - Not the format of first degree equation.\n");
        }
        JOptionPane.showMessageDialog(null, String.format("Ho Tuan Anh 20226100 - The solution is: x = %.2f", -b / a));
    }
}

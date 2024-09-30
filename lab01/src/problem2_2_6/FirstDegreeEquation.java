package problem2_2_6;
import javax.swing.JOptionPane;

class FirstDegreeEquation {
    private double a, b;

    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }

    public void setA() {
        String input = JOptionPane.showInputDialog(null, "a = ");
        this.a = Double.parseDouble(input);
    }
    public void setB() {
        String input = JOptionPane.showInputDialog(null, "b = ");
        this.b = Double.parseDouble(input);
    }

    public void solve() throws Exception {
        if (a == 0) {
            throw new Exception("Not the format of first degree equation.\n");
        }
        JOptionPane.showMessageDialog(null, String.format("The solution is: x = %.2f", -b / a));
    }
}

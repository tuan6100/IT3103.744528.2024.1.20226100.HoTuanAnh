package problem2_2_6;

import javax.swing.*;

class SystemOfFirstDegreeEquations {
    private double a11, a12, b1, a21, a22, b2;

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
        this.a11 = Double.parseDouble(JOptionPane.showInputDialog("Ho Tuan Anh 20226100 a11 = "));
    }
    public void setA12() {
        this.a12 = Double.parseDouble(JOptionPane.showInputDialog("Ho Tuan Anh 20226100 a12 = "));
    }
    public void setB1() {
        this.b1 = Double.parseDouble(JOptionPane.showInputDialog("Ho Tuan Anh 20226100 b1 = "));
    }
    public void setA21() {
        this.a21 = Double.parseDouble(JOptionPane.showInputDialog("Ho Tuan Anh 20226100 a21 = "));
    }
    public void setA22() {
        this.a22 = Double.parseDouble(JOptionPane.showInputDialog("Ho Tuan Anh 20226100 a22 = "));
    }
    public void setB2() {
        this.b2 = Double.parseDouble(JOptionPane.showInputDialog("Ho Tuan Anh 20226100 b2 = "));
    }
   
    public void solve() {
        double D = a11 * a22 - a12 * a21, Dx = b1 * a22 - b2 * a12, Dy = a11 * b2 - a21 * b1;
        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                JOptionPane.showMessageDialog(null, "Ho Tuan Anh 20226100 The system has infinitely many solutions.");
            } else {
                JOptionPane.showMessageDialog(null, "Ho Tuan Anh 20226100 The system has no solution.");
            }
        } else {
            double x = Dx / D;
            double y = Dy / D;
            JOptionPane.showMessageDialog(null, String.format("Ho Tuan Anh 20226100 The solutions are: x = %.2f and y = %.2f", x, y));
        }
    }

}

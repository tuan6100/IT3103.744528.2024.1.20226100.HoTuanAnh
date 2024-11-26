package hust.soict.itep.lab01.problem2_2_6;

import javax.swing.*;

class SecondDegreeEquation {
    private double a, b, c;

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
        String input = JOptionPane.showInputDialog(null, "Ho Tuan Anh 20226100 a = ");
        this.a = Double.parseDouble(input);
    }
    public void setB() {
        String input = JOptionPane.showInputDialog(null, "Ho Tuan Anh 20226100 b = ");
        this.b = Double.parseDouble(input);
    }
    public void setC() {
        String input = JOptionPane.showInputDialog(null, "Ho Tuan Anh 20226100 c = ");
        this.c = Double.parseDouble(input);
    }

    public void solve() throws IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("Ho Tuan Anh 20226100 Not the format of second degree equation.\n");
        }
        double delta = Math.pow(b, 2) - 4 * a * c;
        if (delta < 0) {
            JOptionPane.showMessageDialog(null, "Ho Tuan Anh 20226100 No solution");
        } else if (delta == 0) {
            JOptionPane.showMessageDialog(null, String.format("Ho Tuan Anh 20226100 The solution is: x = %.2f", -b / (2 * a)));
        } else {
            JOptionPane.showMessageDialog(null, String.format("Ho Tuan Anh 20226100 The solutions are: x1 = %.2f and x2 = %.2f", (-b + Math.sqrt(delta)) / (2 * a), (-b - Math.sqrt(delta)) / (2 * a)));
        }
    }
}

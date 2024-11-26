package hust.soict.itep.lab01.problem2_2_6;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        String[] options = {
            "Exit",
            "Solve first degree equation",
            "Solve second degree equation",
            "Solve system of first-degree equations"
        };

        while (true) {
            int option = JOptionPane.showOptionDialog(
                null,
                "List available options:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (option == 0 || option == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Ho Tuan Anh 20226100 Thanks!");
                break;
            } else if (option == 1) {
                JOptionPane.showMessageDialog(null, "Ho Tuan Anh 20226100 ax + b = 0");
                try {
                    FirstDegreeEquation firstDegreeEquation = new FirstDegreeEquation();
                    firstDegreeEquation.setA();
                    firstDegreeEquation.setB();
                    firstDegreeEquation.solve();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (option == 2) {
                JOptionPane.showMessageDialog(null, "Ho Tuan Anh 20226100 ax^2 + bx + c = 0");
                try {
                    SecondDegreeEquation secondDegreeEquation = new SecondDegreeEquation();
                    secondDegreeEquation.setA();
                    secondDegreeEquation.setB();
                    secondDegreeEquation.setC();
                    secondDegreeEquation.solve();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (option == 3) {
                JOptionPane.showMessageDialog(null, "Ho Tuan Anh 20226100 \na11.x + a12.y = b1\na21.x + a22.y = b2");
                SystemOfFirstDegreeEquations systemOfFirstDegreeEquations = new SystemOfFirstDegreeEquations();
                systemOfFirstDegreeEquations.setA11();
                systemOfFirstDegreeEquations.setA12();
                systemOfFirstDegreeEquations.setB1();
                systemOfFirstDegreeEquations.setA21();
                systemOfFirstDegreeEquations.setA22();
                systemOfFirstDegreeEquations.setB2();
                systemOfFirstDegreeEquations.solve();
                
            }
        }
    }
}

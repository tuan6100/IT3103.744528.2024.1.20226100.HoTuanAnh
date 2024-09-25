package problem2_2_5;
import javax.swing.*;

public class ShowTwoNumbers {
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
        ShowTwoNumbers calculator = new ShowTwoNumbers();
        String strNum1, strNum2;
        String strNotification = "You've just entered";
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ",
                "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += ' ' + strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ",
                "Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;
        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        JOptionPane.showMessageDialog(null, "Sum: " + calculator.add(num1, num2),
                "Addition", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Subtraction: " + calculator.sub(num1, num2),
                "Subtraction", JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(null, "Multiplication: " + calculator.mul(num1, num2),
                "Multiplication", JOptionPane.INFORMATION_MESSAGE);

        try {
            JOptionPane.showMessageDialog(null, "Division: " + calculator.div(num1, num2),
                    "Division", JOptionPane.INFORMATION_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        System.exit(0);
    }
}
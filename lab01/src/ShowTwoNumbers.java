import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Ho Tuan Anh 20226100-You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null,
                "Ho Tuan Anh 20226100-Please input the first number: ",
                "Le", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null,
                "Ho Tuan Anh 20226100-Please input the second number: ",
                "Lo", JOptionPane.INFORMATION_MESSAGE);
        strNotification += strNum2;

        JOptionPane.showMessageDialog(null, strNotification,
                "Ho Tuan Anh - 20226100", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
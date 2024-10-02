package problem_6_1;

import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've choosen: " + (option==JOptionPane.YES_OPTION?"Yes":"No"));
    //     Object[] options = {"I do", "I don't"};
    //     int n = JOptionPane.showOptionDialog(null,
    //         "Would you like this custom options?",
    //         "Custom Option Dialog",
    //         JOptionPane.YES_NO_OPTION,
    //         JOptionPane.QUESTION_MESSAGE,
    //         null,
    //         options,
    //         options[1]);
    //     JOptionPane.showMessageDialog(null, "You've chosen: " + options[n]);
         System.exit(0);
    }
}

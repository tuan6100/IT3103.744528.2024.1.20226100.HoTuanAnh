package hust.soict.itep.aims.screen.adding;

import java.awt.Container;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.itep.aims.store.Store;



public class AddItemToStoreScreen extends JFrame {

    protected JPanel inputPanel = new JPanel();
    protected TextField id = new TextField(10);
    protected TextField title = new TextField(10);
    protected TextField category = new TextField(10);
    protected TextField cost = new TextField(10);
    protected Container container;


    public AddItemToStoreScreen(Store store) {
        this.add(new JLabel("Enter id: "));
        this.add(id);
        this.add(new JLabel("Enter title: "));
        this.add(title);
        this.add(new JLabel("Enter category: "));
        this.add(category);
        this.add(new JLabel("Enter cost: "));
    }

    protected JPanel createInputField(String labelText, TextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 
        JLabel label = new JLabel(labelText);
        panel.add(label);
        panel.add(textField);
        return panel;
    }

    public void createInputLayout() {
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.add(createInputField("Enter id: ", id));
        inputPanel.add(createInputField("Enter title: ", title));
        inputPanel.add(createInputField("Enter category: ", category));
        inputPanel.add(createInputField("Enter cost: ", cost));
    }


}

package hust.soict.itep.aims.screen.adding;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.screen.StoreScreen;
import hust.soict.itep.aims.store.Store;


import java.awt.TextField;
import java.awt.event.ActionEvent;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private TextField length = new TextField(10);
    private TextField director = new TextField(10);


    public AddDigitalVideoDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store);
        this.setTitle("Add DVD");
        this.setSize(400, 300);
        createInputLayout();
        inputPanel.add(createInputField("Enter length: ", length));
        inputPanel.add(createInputField("Enter director: ", director));
        JButton addButton = new JButton("Add DVD");
        inputPanel.add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDigitalVideoDisc(store, storeScreen);
            }
        });
        this.add(inputPanel);
        this.setVisible(true);
    }

    private void addDigitalVideoDisc(Store store, StoreScreen storeScreen) {
        try {
            int dvdId = Integer.parseInt(id.getText());
            String dvdTitle = title.getText().trim();
            String dvdCategory = category.getText().trim();
            float dvdCost = Float.parseFloat(cost.getText());
            int dvdLength = Integer.parseInt(length.getText());
            String dvdDirector = director.getText().trim();
            if (dvdTitle.isEmpty() || dvdCategory.isEmpty() || dvdDirector.isEmpty()) {
                throw new IllegalArgumentException("All text fields must be filled.");
            }
            DigitalVideoDisc dvd = new DigitalVideoDisc(dvdId, dvdTitle, dvdCategory, dvdCost, dvdLength, dvdDirector);
            store.addMedia(dvd);
            storeScreen.refreshCenter();
            JOptionPane.showMessageDialog(this, 
                "DVD '" + dvd.getTitle() + "' added to store successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            clearInputFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Invalid input: Ensure ID, Cost, and Length are numeric values.", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, 
                ex.getMessage(), 
                "Input Error", 
                JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "An unexpected error occurred: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearInputFields() {
        id.setText("");
        title.setText("");
        category.setText("");
        cost.setText("");
        length.setText("");
        director.setText("");
    }
}



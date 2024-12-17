package hust.soict.itep.aims.screen.adding;

import javax.swing.*;

import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.screen.StoreScreen;
import hust.soict.itep.aims.store.Store;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    private List<String> authors = new ArrayList<>();
    private JPanel authorsPanel = new JPanel();
    private JTextField authorField = new JTextField(10);

    public AddBookToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store);
        this.setTitle("Add Book");
        this.setSize(400, 300);
        createInputLayout();
        JPanel authorInputPanel = createInputField("Enter author: ", new TextField(authorField.getText(), 10));
        JButton addAuthorButton = new JButton("Add Author");
        addAuthorButton.addActionListener(e -> addAuthor());
        authorInputPanel.add(addAuthorButton);
        inputPanel.add(authorInputPanel);
        authorsPanel.setLayout(new BoxLayout(authorsPanel, BoxLayout.Y_AXIS));
        JScrollPane authorsScrollPane = new JScrollPane(authorsPanel);
        authorsScrollPane.setPreferredSize(new Dimension(380, 100));
        inputPanel.add(new JLabel("Authors:"));
        inputPanel.add(authorsScrollPane);
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> addBook(store, storeScreen));
        inputPanel.add(addButton);

        this.add(inputPanel);
        this.setVisible(true);
    }

    private void addAuthor() {
        String authorName = authorField.getText().trim();
        if (!authorName.isEmpty()) {
            if (authors.contains(authorName)) {
                JOptionPane.showMessageDialog(this, "Author already added.", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }
            authors.add(authorName);
            JLabel authorLabel = new JLabel(authorName);
            authorsPanel.add(authorLabel);
            authorsPanel.revalidate();
            authorsPanel.repaint();
            authorField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Author name cannot be empty.", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void addBook(Store store, StoreScreen storeScreen) {
        try {
            int bookId = Integer.parseInt(id.getText());
            String bookTitle = title.getText().trim();
            String bookCategory = category.getText().trim();
            float bookCost = Float.parseFloat(cost.getText());
            if (bookTitle.isEmpty() || bookCategory.isEmpty()) {
                throw new IllegalArgumentException("All text fields must be filled.");
            }
            Book book = new Book(bookId, bookTitle, bookCategory, bookCost, authors);
            store.addMedia(book);
            storeScreen.refreshCenter();
            JOptionPane.showMessageDialog(this, 
                "Book '" + book.getTitle() + "' added to store successfully!", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
            clearInputFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Invalid input: Ensure ID and Cost are numeric values.", 
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
        authorField.setText("");
        authors.clear();
        authorsPanel.removeAll();
        authorsPanel.revalidate();
        authorsPanel.repaint();
    }
}

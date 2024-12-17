package hust.soict.itep.aims.screen.adding;

import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.Track;
import hust.soict.itep.aims.screen.StoreScreen;
import hust.soict.itep.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private TextField director = new TextField(10);
    private TextField artist = new TextField(10);
    private JPanel tracksPanel = new JPanel();
    private JScrollPane tracksScrollPane;

    public AddCompactDiscToStoreScreen(Store store, StoreScreen storeScreen) {
        super(store);
        this.setTitle("Add Compact Disc");
        this.setSize(400, 300);

        createInputLayout();
        inputPanel.add(createInputField("Enter director: ", director));
        inputPanel.add(createInputField("Enter artist: ", artist));
        JButton addTrackButton = new JButton("Add Track");
        addTrackButton.addActionListener(e -> addTrackField());
        inputPanel.add(addTrackButton);

        tracksPanel.setLayout(new BoxLayout(tracksPanel, BoxLayout.Y_AXIS));
        tracksScrollPane = new JScrollPane(tracksPanel);
        tracksScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tracksScrollPane.setPreferredSize(new Dimension(380, 150));

        JButton addButton = new JButton("Add Compact Disc");
        addButton.addActionListener(e -> addCompactDisc(store, storeScreen));

        this.setLayout(new BorderLayout());
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(tracksScrollPane, BorderLayout.CENTER);
        this.add(addButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private void addTrackField() {
        JPanel trackPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        trackPanel.add(new JLabel("Track title:"));
        JTextField trackTitleField = new JTextField(10);
        trackPanel.add(trackTitleField);
        trackPanel.add(new JLabel("Length:"));
        JTextField trackLengthField = new JTextField(5);
        trackPanel.add(trackLengthField);
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            tracksPanel.remove(trackPanel);
            tracksPanel.revalidate();
            tracksPanel.repaint();
        });
        trackPanel.add(removeButton);

        tracksPanel.add(trackPanel);
        tracksPanel.revalidate();
        tracksPanel.repaint();
    }

    private void addCompactDisc(Store store, StoreScreen storeScreen) {
        try {
            int cdId = Integer.parseInt(id.getText());
            String cdTitle = title.getText().trim();
            String cdCategory = category.getText().trim();
            float cdCost = Float.parseFloat(cost.getText());
            String cdDirector = director.getText().trim();
            String cdArtist = artist.getText().trim();
            ArrayList<Track> tracks = collectTracks();

            if (cdTitle.isEmpty() || cdCategory.isEmpty() || cdDirector.isEmpty() || cdArtist.isEmpty()) {
                throw new IllegalArgumentException("All fields must be filled.");
            }

            CompactDisc cd = new CompactDisc(cdId, cdTitle, cdCategory, cdCost, cdDirector, cdArtist, tracks);
            store.addMedia(cd);
            storeScreen.refreshCenter();

            JOptionPane.showMessageDialog(this,
                    "Compact Disc '" + cd.getTitle() + "' added successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            clearInputFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid input: Ensure ID, Cost, and Track Length are numeric.",
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

    private ArrayList<Track> collectTracks() {
        ArrayList<Track> tracks = new ArrayList<>();
        for (Component comp : tracksPanel.getComponents()) {
            JPanel trackPanel = (JPanel) comp;
            String title = ((JTextField) trackPanel.getComponent(1)).getText().trim();
            String lengthText = ((JTextField) trackPanel.getComponent(3)).getText().trim();

            if (title.isEmpty() || lengthText.isEmpty()) {
                throw new IllegalArgumentException("Track title and length cannot be empty.");
            }
            int length = Integer.parseInt(lengthText);
            tracks.add(new Track(title, length));
        }
        return tracks;
    }

    private void clearInputFields() {
        id.setText("");
        title.setText("");
        category.setText("");
        cost.setText("");
        director.setText("");
        artist.setText("");
        tracksPanel.removeAll();
        tracksPanel.revalidate();
        tracksPanel.repaint();
    }
}

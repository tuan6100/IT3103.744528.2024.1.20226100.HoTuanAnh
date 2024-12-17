
package hust.soict.itep.aims.screen;

import javax.swing.*;
import java.awt.*;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Playable;
import hust.soict.itep.aims.media.Track;
import hust.soict.itep.aims.store.Store;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;



public class MediaStore extends JPanel  {

    private Media media;


    public MediaStore(Media media, Cart cartAims) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + "$");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addCartButton = new JButton("Add to cart");
        container.add(addCartButton);
        addCartButton.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                try {
                    cartAims.addMedia(media);
                    JOptionPane.showMessageDialog(null, "Media " + media.getTitle() + " added to cart successfully", 
                                      "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), "Failed", JOptionPane.WARNING_MESSAGE);
                }
            }

        });
    
        if(media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog playDialog;
                    try {
                        playDialog = createPlayDialog(media);
                        playDialog.setVisible(true);
                        playDialog.setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
                        playDialog.setSize(300,200);
                        playDialog.pack();
                    } catch (PlayerException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(playButton);
        }
            
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    static JDialog createPlayDialog(Media media) throws PlayerException {
        JDialog playDialog = new JDialog();
        Container container = playDialog.getContentPane();
        playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
        container.add(Box.createRigidArea(new Dimension(10,10)));
        if(media instanceof DigitalVideoDisc dvd) {
            if (dvd.getLength() <= 0) {
                throw new PlayerException("ERROR: DVD length is non-positive");
            }
            container.add(new JLabel("Playing DVD:" + dvd.getTitle()));
            container.add(new JLabel("DVD length:" + dvd.getLength() +" min"));
        } else if (media instanceof CompactDisc cd) {
            container.add(new JLabel("Playing CD: " + cd.getTitle()));
            container.add(new JLabel("Artist: " + cd.getArtist()));
            for (Track track : cd.getTracks()) {
                container.add(new JLabel("Play: " + track.getTitle() + ". Length: " + track.getLength() + " min"));
            }
        }
        playDialog.setTitle("Play " + media.getTitle());
        return playDialog;
    }



    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc(1,"DVD 1","category 1",
                1.99f,9,"Director 1");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(6,"DVD2","category 2",
                2.99f,99,"Director 2");

        ArrayList<Track> tracks = new ArrayList<Track>();
        tracks.add(new Track("Track 1",1));
        tracks.add(new Track("Track 2",2));
        CompactDisc cd = new CompactDisc(2,"CD 1","category 3",3.99f,"director 3","artist 1",tracks);

        ArrayList<Track> tracks2 = new ArrayList<Track>();
        tracks2.add(new Track("track 3",3));
        tracks2.add(new Track("track 4",4));
        tracks2.add(new Track("track 5",5));
        CompactDisc cd2 = new CompactDisc(5,"CD 2","category 4",4.99f, "director 4", "artist 2",tracks2);

        List<String> authors = new ArrayList<String>();
        authors.add("Author 1");
        Book book1   = new Book(3,"Book 1","category 5",5.99f, authors);
        List<String> authors2 = new ArrayList<String>();
        authors2.add("Author 2");
        Book book2   = new Book(4,"Book 2","category 6",9.99f, authors2);

        Store store = new Store();
        Cart cart = new Cart();

        try {
            store.addMedia(cd);
            store.addMedia(cd2);
            store.addMedia(dvd);
            store.addMedia(dvd2);
            store.addMedia(book1);
            store.addMedia(book2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        new StoreScreen(store, cart);
    }
    
}
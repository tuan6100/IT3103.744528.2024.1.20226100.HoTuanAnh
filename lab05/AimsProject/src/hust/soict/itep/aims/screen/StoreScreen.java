package hust.soict.itep.aims.screen;

import javax.swing.*;
import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.screen.adding.AddBookToStoreScreen;
import hust.soict.itep.aims.screen.adding.AddCompactDiscToStoreScreen;
import hust.soict.itep.aims.screen.adding.AddDigitalVideoDiscToStoreScreen;
import hust.soict.itep.aims.store.Store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreScreen extends JFrame {

    private Store store;
    private Cart cartAims;
    private JPanel center; 

    public StoreScreen(Store store, Cart cartAims) {
        this.store = store;
        this.cartAims = cartAims;

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(createNorth(), BorderLayout.NORTH);
        container.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setLocation(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint());
        setTitle("HoTuanAnh_20226100 Store");
        setSize(1024, 768);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookToStoreScreen(store, StoreScreen.this); 
            }
        });

        JMenuItem addCD = new JMenuItem("Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddCompactDiscToStoreScreen(store, StoreScreen.this); 
            }
        });

        JMenuItem addDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDigitalVideoDiscToStoreScreen(store, StoreScreen.this); 
            }
        });

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View cart");
        cartButton.setPreferredSize(new Dimension(100, 50));
        cartButton.setMaximumSize(new Dimension(100, 50));
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cartAims);
            }
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createCenter() {
        center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        refreshCenter(); // Populate the center panel with initial data
        return center;
    }

    public void refreshCenter() {
        center.removeAll(); // Clear existing components in the center panel

        ArrayList<Media> mediaStore = store.getItemsInStore();
        for (Media media : mediaStore) {
            MediaStore cell = new MediaStore(media, cartAims);
            center.add(cell);
        }

        center.revalidate(); // Refresh the panel
        center.repaint();
    }
}

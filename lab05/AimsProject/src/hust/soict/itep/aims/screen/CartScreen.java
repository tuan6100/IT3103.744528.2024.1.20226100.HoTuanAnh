package hust.soict.itep.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.itep.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("HoTuanAnh_20226100 Cart");
        this.setVisible(true);
        setSize(1100, 768);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../screen/fxml/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart); 
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        });
    }
}


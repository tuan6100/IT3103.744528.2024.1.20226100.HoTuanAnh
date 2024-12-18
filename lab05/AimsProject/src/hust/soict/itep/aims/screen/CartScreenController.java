package hust.soict.itep.aims.screen;

import javafx.scene.control.Label;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import hust.soict.itep.aims.cart.Cart;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.Media;
import hust.soict.itep.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CartScreenController {
    
    private Cart cart;

    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TextField tfFilter;
    @FXML
    private ToggleGroup filterCategory;
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;
    @FXML
    private TableColumn<Media,Float> colMediaCost;
    @FXML
    private Label totalPrice;

    
    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(FXCollections.observableList(this.cart.getItemsOrdered()));
        tblMedia.setPlaceholder(new Label("No item in cart"));
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        btnRemove.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Media media = tblMedia.getSelectionModel().getSelectedItem();
                try {
                    cart.removeMedia(media);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                totalPrice.setText(Float.toString(cart.totalCost()) +"$");
                tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
            }
        });
        tfFilter.textProperty().addListener((ChangeListener<? super String>) new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observableValue, Media oldValue, Media newValue) {
                        updateButtonBar(newValue);
                    }
                }
        );
        totalPrice.setText(Float.toString(cart.totalCost()) + "$");
        btnPlay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JDialog playDialog;
                try {
                    playDialog = MediaStore.createPlayDialog(tblMedia.getSelectionModel().getSelectedItem());
                    playDialog.setVisible(true);
                    playDialog.setSize(300,200);
                    playDialog.pack();
                } catch (PlayerException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnPlaceOrder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                createPopUp();
                cart.getItemsOrdered().clear();
                tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
                totalPrice.setText(Float.toString(cart.totalCost()) + "$");
            }
        });
    }

    @FXML
    void showFilteredMedia(String s) {
        if (filterCategory.getSelectedToggle() == radioBtnFilterTitle) {
            ArrayList<Media> filterByTitle = new ArrayList<Media>();
            for (Media item : cart.getItemsOrdered()) {
                if (item.getTitle().contains(s)) {
                    filterByTitle.add(item);
                }
            }
            tblMedia.setItems(FXCollections.observableList(filterByTitle));
        } else if (filterCategory.getSelectedToggle() == radioBtnFilterId) {
            ArrayList<Media> filterByID = new ArrayList<Media>();
            for (Media item : cart.getItemsOrdered()) {
                if (item.getId() == Integer.parseInt(s)) {
                    filterByID.add(item);
                }
            }
            tblMedia.setItems(FXCollections.observableList(filterByID));
        }
    }

    @FXML
    void createPopUp() {
        Stage popupwindow =new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Place order");

        Label label1 = new Label("You have place your order !");
        label1.setFont(Font.font("San Serif", FontWeight.BOLD,14));
        Label label2 = new Label("Your bill total is " + Float.toString(cart.totalCost()) + "$");
        Button button1= new Button("OK !");
        label2.setTextFill(Color.RED);
        button1.setOnAction(e -> popupwindow.close());
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, label2,button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 300, 200);
        popupwindow.setScene(scene1);
        popupwindow.show();
    }

    @FXML
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        try {
            cart.removeMedia(media);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

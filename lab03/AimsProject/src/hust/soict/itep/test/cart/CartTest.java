package hust.soict.itep.test.cart;

import hust.soict.itep.aims.cart.Cart_HoTuanAnh20226100;
import hust.soict.itep.aims.disc.DigitalVideoDisc_HoTuanAnh20226100;

public class CartTest {
    public static void main(String[] args) {
        Cart_HoTuanAnh20226100 cart = new Cart_HoTuanAnh20226100();
        DigitalVideoDisc_HoTuanAnh20226100 dvd1 = new DigitalVideoDisc_HoTuanAnh20226100("The Lion King","Animation",
                "Roger Allers",87,19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc_HoTuanAnh20226100 dvd2 = new DigitalVideoDisc_HoTuanAnh20226100("Star wars","Science Fiction",
                "Geogre Lucas",87,24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc_HoTuanAnh20226100 dvd3 = new DigitalVideoDisc_HoTuanAnh20226100("Aladin","Animation",18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();

        cart.searchById(3);
        cart.searchById(4);

        cart.searchByTitle("The Lion King");
        cart.searchByTitle("abc");
    }
}

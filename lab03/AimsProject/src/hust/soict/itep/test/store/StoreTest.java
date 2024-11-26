package hust.soict.itep.test.store;

import hust.soict.itep.aims.disc.DigitalVideoDisc_HoTuanAnh20226100;
import hust.soict.itep.aims.store.Store_HoTuanAnh20226100;

public class StoreTest {
    public static void main(String[] args) {
        Store_HoTuanAnh20226100 store = new Store_HoTuanAnh20226100();
        DigitalVideoDisc_HoTuanAnh20226100 dvd1 = new DigitalVideoDisc_HoTuanAnh20226100("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        DigitalVideoDisc_HoTuanAnh20226100 dvd2 = new DigitalVideoDisc_HoTuanAnh20226100("Star wars", "Science Fiction",
                "Geogre Lucas", 87, 24.95f);
        DigitalVideoDisc_HoTuanAnh20226100 dvd3 = new DigitalVideoDisc_HoTuanAnh20226100("Aladin", "Animation", 18.99f);
        
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);
        store.print();

        store.removeDVD(dvd1);
        store.print();
    }
}

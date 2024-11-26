package hust.soict.itep.aims.store;

import hust.soict.itep.aims.disc.DigitalVideoDisc_HoTuanAnh20226100;
import java.util.*;

public class Store_HoTuanAnh20226100 {

    private  DigitalVideoDisc_HoTuanAnh20226100 itemsInStore[] ;

    public void addDVD(DigitalVideoDisc_HoTuanAnh20226100 disc) {
        if (itemsInStore == null) {
            itemsInStore = new DigitalVideoDisc_HoTuanAnh20226100[1];
            itemsInStore[0] = disc;
        } else {
            DigitalVideoDisc_HoTuanAnh20226100[] newItems = Arrays.copyOf(itemsInStore, itemsInStore.length + 1);
            newItems[newItems.length - 1] = disc;
            itemsInStore = newItems;
        }
        System.out.println(disc.getTitle() + " has been added to the store!");

    }

    public void removeDVD(DigitalVideoDisc_HoTuanAnh20226100 disc) {
        if (itemsInStore != null && itemsInStore.length > 0) {
            List<DigitalVideoDisc_HoTuanAnh20226100> list = new ArrayList<>(Arrays.asList(itemsInStore));
            if (list.remove(disc)) {
                itemsInStore = list.toArray(new DigitalVideoDisc_HoTuanAnh20226100[0]);
                System.out.println("The disc " + disc.getTitle() + " has been removed from the store!");
            } else {
                System.out.println("The disc " + disc.getTitle() + " is not found in the store!");
            }
        } else {
            System.out.println("The store is empty!");
        }
    }

    public void print() {
        System.out.println("\n*********************STORE************************** \nOrdered items: \n");
        for (int i = 0; i < itemsInStore.length; i++) {
            System.out.println(i+1 + itemsInStore[i].toString());
        }
        System.out.println("***************************************************\n");
    }
       
    
}

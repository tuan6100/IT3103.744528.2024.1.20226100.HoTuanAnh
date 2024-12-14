package hust.soict.itep.aims.store;

import hust.soict.itep.aims.media.*;
import java.util.*;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media) throws Exception {
        if (itemsInStore.contains(media)) {
            if (media instanceof Book) {
                throw new Exception("HoTuanAnh-20226100 Book " + media.getTitle()  + " is aready exist");
            } else if (media instanceof DigitalVideoDisc) {
                throw new Exception("HoTuanAnh-20226100 DVD " + media.getTitle()  + " is aready exist");
            } else if (media instanceof CompactDisc) {
                throw new Exception("HoTuanAnh-20226100 CD " + media.getTitle()  + " is aready exist");
            }
        }
        itemsInStore.add(media);
        if (media instanceof Book) {
            System.out.println("HoTuanAnh-20226100 Book " + media.getTitle()  + " added to store successfully");
        } else if (media instanceof DigitalVideoDisc) {
            System.out.println("HoTuanAnh-20226100 DVD " + media.getTitle()  + " added to store successfully");
        } else if (media instanceof CompactDisc) {
            System.out.println("HoTuanAnh-20226100 CD " + media.getTitle()  + " added to store successfully");
        }
    }

    public void removeMedia(Media media) throws Exception {
        if (!itemsInStore.contains(media)) {
            if (media instanceof Book) {
                throw new Exception("HoTuanAnh-20226100 Book " + media.getTitle()  + " not found");
            } else if (media instanceof DigitalVideoDisc) {
                throw new Exception("HoTuanAnh-20226100 DVD " + media.getTitle()  + " not found");
            } else if (media instanceof CompactDisc) {
                throw new Exception("HoTuanAnh-20226100 CD " + media.getTitle()  + " not found");
            }
        }
        itemsInStore.remove(media);
        if (media instanceof Book) {
            System.out.println("HoTuanAnh-20226100 Book " + media.getTitle()  + " removed from store successfully");
        } else if (media instanceof DigitalVideoDisc) {
            System.out.println("HoTuanAnh-20226100 DVD " + media.getTitle()  + " removed from store successfully");
        } else if (media instanceof CompactDisc) {
            System.out.println("HoTuanAnh-20226100 CD " + media.getTitle()  + " removed from store successfully");
        }
    }

    public Media searchById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("\n*********************STORE************************** \nOrdered items: \n");
        itemsInStore.forEach(media -> System.out.println(media.toString())); 
        System.out.println("***************************************************\n");
    }
    
       
    
}

package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.media.*;

import java.util.ArrayList;
import java.util.Collections;

public class Cart {
   
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) throws Exception {
        if (itemsOrdered.contains(media)) {
            if (media instanceof Book) {
                throw new Exception("HoTuanAnh-20226100 Book " + media.getTitle()  + " is aready exist");
            } else if (media instanceof DigitalVideoDisc) {
                throw new Exception("HoTuanAnh-20226100 DVD " + media.getTitle()  + " is aready exist");
            } else if (media instanceof CompactDisc) {
                throw new Exception("HoTuanAnh-20226100 CD " + media.getTitle()  + " is aready exist");
            }
        }
        itemsOrdered.add(media);
        if (media instanceof Book) {
            System.out.println("HoTuanAnh-20226100 Book " + media.getTitle()  + " added to cart successfully");
        } else if (media instanceof DigitalVideoDisc) {
            System.out.println("HoTuanAnh-20226100 DVD " + media.getTitle()  + " added to cart successfully");
        } else if (media instanceof CompactDisc) {
            System.out.println("HoTuanAnh-20226100 CD " + media.getTitle()  + " added to cart successfully");
        }
    }

    public void removeMedia(Media media) throws Exception {
        if (!itemsOrdered.contains(media)) {
            if (media instanceof Book) {
                throw new Exception("HoTuanAnh-20226100 Book " + media.getTitle()  + " not found");
            } else if (media instanceof DigitalVideoDisc) {
                throw new Exception("HoTuanAnh-20226100 DVD " + media.getTitle()  + " not found");
            } else if (media instanceof CompactDisc) {
                throw new Exception("HoTuanAnh-20226100 CD " + media.getTitle()  + " not found");
            }
        }
        itemsOrdered.remove(media);
        if (media instanceof Book) {
            System.out.println("HoTuanAnh-20226100 Book " + media.getTitle()  + " removed from cart successfully");
        } else if (media instanceof DigitalVideoDisc) {
            System.out.println("HoTuanAnh-20226100 DVD " + media.getTitle()  + " removed from cart successfully");
        } else if (media instanceof CompactDisc) {
            System.out.println("HoTuanAnh-20226100 CD " + media.getTitle()  + " removed from cart successfully");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public Media searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public Media searchByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void print() {
        System.out.println("\n*********************CART************************** \nOrdered items: \n");
        itemsOrdered.forEach(media -> System.out.println(media.toString()));
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************\n");
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void empty() {
        itemsOrdered.clear();
    }

}

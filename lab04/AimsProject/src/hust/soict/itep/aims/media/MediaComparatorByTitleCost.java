package hust.soict.itep.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    // So sanh theo thu tu tang dan
    @Override
    public int compare(Media o1, Media o2) {
        return Comparator.comparing(Media::getTitle)  // tang dan
                 .thenComparing(Media::getCost, Comparator.reverseOrder())  // giam dan
                 .compare(o1, o2);
    }

    
}
package hust.soict.itep.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

  
    @Override
    public int compare(Media o1, Media o2) {
        return Comparator.comparing(Media::getCost, Comparator.reverseOrder())  // giam dan 
                 .thenComparing(Media::getTitle)  // tang dan
                 .compare(o1, o2);
    }
    
}

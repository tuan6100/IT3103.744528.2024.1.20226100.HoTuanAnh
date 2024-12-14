package hust.soict.itep.test;

import java.util.ArrayList;
import java.util.List;

import hust.soict.itep.aims.media.*;


public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        DigitalVideoDisc dvd = new DigitalVideoDisc(1, "dvd 1", "dvd", 5, 10, "xxx");

        List<Track> tracks = new ArrayList<>();
        tracks.add(new Track("track 1",3));
        tracks.add(new Track("track 2",4));
        CompactDisc cd = new CompactDisc(2, "cd 1", "cd", 2.5f, "yyy", "abc", tracks);

        List<String> authors = new ArrayList<String>();
        authors.add("name 1");
        authors.add("name 2");
        Book book = new Book(3,"book 1", "book", 10, authors);

        mediae.add(dvd);
        mediae.add(cd);
        mediae.add(book);

        for(Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}

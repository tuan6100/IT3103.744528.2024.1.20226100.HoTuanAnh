
package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable{

    private String artist;
    private List<Track> tracks = new ArrayList<>();


    public CompactDisc(int id, String title, String category, float cost, String director, String artist, List<Track> tracks) {
        super(id, title, category, cost, director);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void addTrack(Track track) throws Exception {
        if (tracks.contains(track)) {
            throw new Exception("HoTuanAnh-20226100 Track " +track.getTitle() + " already exists in the list.");
        }
        tracks.add(track);
        System.out.println("HoTuanAnh-20226100 Track "  + track.getTitle() + " added successfully");
    }

    public void removeTrack(Track track) throws Exception {
        if (!tracks.contains(track)) {
            throw new Exception("HoTuanAnh-20226100 Track " +track.getTitle() + " not found.");
        }
        tracks.remove(track);
        System.out.println("HoTuanAnh-20226100 Track " + track.getTitle() + " removed successfully");
    }

    // Ghi de phuong thuc getLength() cua lop Disc
    @Override
    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }
    
    // Trien khai phuong thuc play() trong interface
    @Override
    public void play() {
        System.out.println("HoTuanAnh-20226100 Playing CD: " + this.getTitle());
        System.out.println("HoTuanAnh-20226100 CD artist: " + artist);
        System.out.println("HoTuanAnh-20226100 CD lenght: " + getLength());
        tracks.forEach(track -> track.play());
    }

    // Ghi de phuong thuc toString() cua lop Media
    @Override
    public String toString() {
        return "HoTuanAnh20226100 CD: { " + "\n" +
                                        "    id: "+ getId() + "\n" +
                                        "    title: " + getTitle() +  "\n" +
                                        "    category: " + getCategory() +  "\n" +                                 
                                        "    director: " + getDirector() + "\n" +
                                        "    track: { \n" +
                                        printtracks() + "    }" + "\n" +
                                        "    cost: " + getCost() + "$" + "\n" +
                                        "}" ; 
    }

    private String printtracks() {
        String str = "" ;
        for (Track track : tracks) {
            str += "        title: " + track.getTitle() + ',' + "\n" +
                   "        length: " + track.getLength() + '\n';
        }
        return str;
    }

}
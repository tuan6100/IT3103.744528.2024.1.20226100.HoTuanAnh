package hust.soict.itep.aims.media;

public class Track implements Playable{
    
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Trien khai phuong thuc play() trong interface
    @Override
    public void play() {
        System.out.println("HoTuanAnh-20226100 Playing track: " + this.getTitle());
        System.out.println("HoTuanAnh-20226100 Track length: " + this.getLength());
    }

    // Ghi de phuong thuc equals() mac dinh
    @Override
    public boolean equals(Object o) {
        Track track = (Track) o;
        return track.getTitle().equals(this.getTitle()) && (track.getLength() == this.getLength());
    }
}

package hust.soict.itep.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
// public class DigitalVideoDisc extends Disc implements Playable, Comparable<DigitalVideoDisc> { 

    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    } 

    // Ghi de phuong thuc toString() cua lop Media
    @Override
    public String toString() {
        return "HoTuanAnh20226100 DVD: { \n" + 
                                        "    id: "+ getId() + "\n" +
                                        "    title: " + getTitle() + "\n" +
                                        "    category: " + getCategory() + "\n" +
                                        "    length: " + getLength() + "\n" +
                                        "    director: " + getDirector() + "\n" +
                                        "    cost: " + getCost() + "$" + "\n" +
                                        "}" ; 
    }

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    // Trien khai phuong thuc play() trong interface
    @Override
    public void play() {
        System.out.println("HoTuanAnh-20226100 Playing DVD: " + this.getTitle());
        System.out.println("HoTuanAnh-20226100 DVD length: " + this.getLength());
    }

    // @Override
    // public int compareTo(DigitalVideoDisc other) { 
    //     if (!this.getTitle().equals(other.getTitle())) { 
    //         return this.getTitle().compareTo(other.getTitle()); 
    //     } else if (this instanceof DigitalVideoDisc&& other instanceof DigitalVideoDisc) { 
    //         return Integer.compare(((DigitalVideoDisc) other).getLength(), ((DigitalVideoDisc) this).getLength()); 
    //     } else { 
    //         return Double.compare(this.getCost(), other.getCost()); 
    //     } 
    // } 

    
}


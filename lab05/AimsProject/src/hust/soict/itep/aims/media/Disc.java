package hust.soict.itep.aims.media;

public class Disc extends Media {
    
    protected int length;
    protected String director;

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost, String director) {
        super(id, title, category, cost);
        this.director = director;
    }

    public int getLength() {    
        return length;
    }

    public String getDirector() {
        return director;
    }

    // Ghi de phuong thuc toString() cua lop Media
    @Override
    public String toString() {
        return "HoTuanAnh20226100 Disc: { \n" + 
                                        "    id: "+ getId() + "\n" +
                                        "    title: " + getTitle() + "\n" +
                                        "    category: " + getCategory() + "\n" +
                                        "    length: " + getLength() + "\n" +
                                        "    director: " + getDirector() + "\n" +
                                        "    cost: " + getCost() + "$" + "\n" +
                                        "}" ; 
    }

}

package hust.soict.itep.aims.disc;

public class DigitalVideoDisc_HoTuanAnh20226100 {
    private String title;
    private String catelogy;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int idCounted = 1;

    // Getters, setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return catelogy;
    }
    public void setCategory(String catelogy) {
        this.catelogy = catelogy;
    }

    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    // Constructors
    public DigitalVideoDisc_HoTuanAnh20226100(String title) {
        setTitle(title);
        setId(idCounted++);
    }
    public DigitalVideoDisc_HoTuanAnh20226100(String catelogy, String title, float cost) {
        setCategory(catelogy);
        setTitle(title);
        setCost(cost);
        setId(idCounted++);
    }
    public DigitalVideoDisc_HoTuanAnh20226100(String director, String catelogy, String title, float cost) {
        setCategory(catelogy);
        setDirector(director);
        setTitle(title);
        setCost(cost);
        setId(idCounted++);
    }
    public DigitalVideoDisc_HoTuanAnh20226100(String title, String catelogy, String director, int length,  float cost) {
        setTitle(title);
        setCategory(catelogy);
        setDirector(director);
        setLength(length);
        setCost(cost);
        setId(idCounted++);
    }


    @Override
    public String toString() {
        return ". DVD - "+this.getDirector()+" -  "+this.getCategory()+" - "+this.getTitle()+
                                " - "+this.getLength()+" - "+this.getCost() +"$";
    }

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }
}


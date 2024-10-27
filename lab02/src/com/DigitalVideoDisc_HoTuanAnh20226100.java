package com;

public class DigitalVideoDisc_HoTuanAnh20226100 {
    private String title;
    private String catelogy;
    private String director;
    private int length;
    private float cost;

    // Getters, setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatelogy() {
        return catelogy;
    }
    public void setCatelogy(String catelogy) {
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

    // Constructors
    public DigitalVideoDisc_HoTuanAnh20226100(String title) {
        super();
        setTitle(title);
    }
    public DigitalVideoDisc_HoTuanAnh20226100(String catelogy, String title, float cost) {
        super();
        setCatelogy(catelogy);
        setTitle(title);
        setCost(cost);
    }
    public DigitalVideoDisc_HoTuanAnh20226100(String director, String catelogy, String title, float cost) {
        super();
        setCatelogy(catelogy);
        setDirector(director);
        setTitle(title);
        setCost(cost);
    }
    public DigitalVideoDisc_HoTuanAnh20226100(String director, String catelogy, String title, int length,  float cost) {
        setCatelogy(catelogy);
        setDirector(director);
        setTitle(title);
        setCost(cost);
        setLength(length);
    }
}


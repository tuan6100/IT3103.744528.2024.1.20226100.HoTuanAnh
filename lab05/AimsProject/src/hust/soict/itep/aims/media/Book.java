
package hust.soict.itep.aims.media;

import java.util.*;

public class Book extends Media{

    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }
    
    public Book(int id, String title, String category, float cost, List<String> authors) {

        // this.id = id;
        // this.title = title;
        // this.category = category;
        // this.cost = cost;
        super(id, title, category, cost);
        this.authors = authors;
    }

    // public int getId() {
    //     return id;
    // }

    // public String getTitle() {
    //     return title;
    // }

    // public String getCategory() {
    //     return category;
    // }

    // public float getCost() {
    //     return cost;
    // }

    public List<String> getAuthors() {
        return authors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author " + authorName + " already exist");
            return;
        }
        authors.add(authorName);
        System.out.println("Author " + authorName + " added successfully");
    }

    public void removeAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            System.out.println("Author " + authorName + " not found");
            return;
        }
        authors.remove(authorName);
        System.out.println("Author " + authorName + " removed successfully");
    }

    // Ghi de phuong thuc toString() cua lop Media
    @Override
    public String toString() {
        return "HoTuanAnh20226100 Book: { \n" + 
                                        "    id: "+ getId() + "\n" +
                                        "    title: " + getTitle() + "\n" + 
                                        "    category: " + getCategory() + "\n" + 
                                        "    authors: [" + printAuthors() + "]\n" + 
                                        "    cost: " + getCost() + "$" + "\n" +
                                        "}" ; 
    }

    private String printAuthors() {
        return String.join(", ", authors);
    }
    
}

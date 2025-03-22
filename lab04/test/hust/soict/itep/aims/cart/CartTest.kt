package hust.soict.itep.aims.cart

import hust.soict.itep.aims.media.Book
import hust.soict.itep.aims.media.Media
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CartTest {

    private val items: MutableList<Media> = mutableListOf(
        Book(mutableListOf("Author 1", "Author 2"), 1, "Book 1", "Category 1", 10f),
        Book(mutableListOf("Author 3", "Author 4"), 2, "Book 2", "Category 2", 20f),
        Book(mutableListOf("Author 5", "Author 6"), 3, "Book 3", "Category 3", 30f),
        Book(mutableListOf("Author 7", "Author 8"), 4, "Book 4", "Category 4", 40f),
        Book(mutableListOf("Author 9", "Author 10"), 5, "Book 5", "Category 5", 50f),
        Book(mutableListOf("Author 11", "Author 12"), 6, "Book 6", "Category 6", 60f),
        Book(mutableListOf("Author 13", "Author 14"), 7, "Book 7", "Category 7", 70f),
        Book(mutableListOf("Author 15", "Author 16"), 8, "Book 8", "Category 8", 80f),
        Book(mutableListOf("Author 17", "Author 18"), 9, "Book 9", "Category 9", 90f),
        Book(mutableListOf("Author 19", "Author 20"), 10, "Book 10", "Category 10", 100f),
        Book(mutableListOf("Author 21", "Author 22"), 11, "Book 11", "Category 11", 110f),
        Book(mutableListOf("Author 23", "Author 24"), 12, "Book 12", "Category 12", 120f),
        Book(mutableListOf("Author 25", "Author 26"), 13, "Book 13", "Category 13", 130f),
        Book(mutableListOf("Author 27", "Author 28"), 14, "Book 14", "Category 14", 140f),
        Book(mutableListOf("Author 29", "Author 30"), 15, "Book 15", "Category 15", 150f),
        Book(mutableListOf("Author 31", "Author 32"), 16, "Book 16", "Category 16", 160f)
    )

    private var cart = Cart(items)

    @Test
    fun sortByTitleCost() {
        cart.sortByTitleCost()
        assertEquals("Book 1", cart.itemOrdered[0].title)
        assertEquals("Book 10", cart.itemOrdered[1].title)

    }

    @Test
    fun sortByCostTitle() {
        cart.sortByCostTitle()
        assertEquals("Book 16", cart.itemOrdered[0].title)
        assertEquals("Book 15", cart.itemOrdered[1].title)
        assertEquals("Book 14", cart.itemOrdered[2].title)
        assertEquals("Book 13", cart.itemOrdered[3].title)
        assertEquals("Book 12", cart.itemOrdered[4].title)
        assertEquals("Book 11", cart.itemOrdered[5].title)
        assertEquals("Book 10", cart.itemOrdered[6].title)
        assertEquals("Book 9", cart.itemOrdered[7].title)
        assertEquals("Book 8", cart.itemOrdered[8].title)
        assertEquals("Book 7", cart.itemOrdered[9].title)
        assertEquals("Book 6", cart.itemOrdered[10].title)
        assertEquals("Book 5", cart.itemOrdered[11].title)
        assertEquals("Book 4", cart.itemOrdered[12].title)
        assertEquals("Book 3", cart.itemOrdered[13].title)
        assertEquals("Book 2", cart.itemOrdered[14].title)
        assertEquals("Book 1", cart.itemOrdered[15].title)
    }

}
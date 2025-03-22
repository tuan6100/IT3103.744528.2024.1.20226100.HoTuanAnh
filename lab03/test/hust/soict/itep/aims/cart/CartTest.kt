package hust.soict.itep.aims.cart

import hust.soict.itep.aims.disc.DigitalVideoDisc
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CartTest {

    private val cart = Cart()

    @Test
    fun addDvd() {
        val dvd1 = DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f)
        val dvd2 = DigitalVideoDisc(2, "Star wars", "Science Fiction", "Geogre Lucas", 87, 24.95f)
        cart.addDvd(dvd1, dvd2)
        assertEquals(2, cart.itemOrdered.size)
    }

    @Test
    fun searchByTitle() {
        val dvd1 = hust.soict.itep.aims.disc.DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f)
        val dvd2 = hust.soict.itep.aims.disc.DigitalVideoDisc(2, "Star wars", "Science Fiction", "Geogre Lucas", 87, 24.95f)
        cart.addDvd(dvd1, dvd2)
        assertEquals(dvd1, cart.searchByTitle("The Lion King"))
    }
}
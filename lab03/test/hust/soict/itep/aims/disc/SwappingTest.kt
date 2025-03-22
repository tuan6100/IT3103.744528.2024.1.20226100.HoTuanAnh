package hust.soict.itep.aims.disc

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class SwappingTest {

    @Test
    fun swap() {
        var dvd1 = DigitalVideoDisc("The Lion King")
        var dvd2 = DigitalVideoDisc("Star wars" )
        dvd1 = dvd2.also { dvd2 = dvd1 }
        assertEquals("Star wars", dvd1.title)
        assertEquals("The Lion King", dvd2.title)
    }

    @Test
    fun swap2() {
        var dvd1 = DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f)
        var dvd2 = DigitalVideoDisc(2, "Star wars", "Science Fiction", "Geogre Lucas", 90, 24.95f)
        dvd1 = dvd2.also { dvd2 = dvd1 }
        assertEquals("Star wars", dvd1.title)
        assertEquals("Science Fiction", dvd1.category)
        assertEquals("Geogre Lucas", dvd1.director)
        assertEquals(90, dvd1.length)
        assertEquals(24.95f, dvd1.cost)
        assertEquals("The Lion King", dvd2.title)
        assertEquals("Animation", dvd2.category)
        assertEquals("Roger Allers", dvd2.director)
        assertEquals(87, dvd2.length)
        assertEquals(19.95f, dvd2.cost)
    }
}
package hust.soict.itep.aims.media

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class CompactDiscTest {

    private val compactDisc = CompactDisc()

    @org.junit.jupiter.api.Test
    fun getLength() {
        val track1 = Track("Hello", 10)
        val track2 = Track("World", 20)
        val track3 = Track("!", 30)
        val track4 = Track("?", 40)
        compactDisc.addTrack(track1)
        compactDisc.addTrack(track2)
        compactDisc.addTrack(track3)
        assertEquals(60, compactDisc.getLength())
        compactDisc.removeTrack(track1)
        assertEquals(50, compactDisc.getLength())
        assertThrows<Exception> {
            compactDisc.removeTrack(track4)
        }
    }

}
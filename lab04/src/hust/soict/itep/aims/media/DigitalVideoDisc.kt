package hust.soict.itep.aims.media

class DigitalVideoDisc(director: String, length: Int, id: Int, title: String, category: String, cost: Float)
    : Disc(director, length, id, title, category, cost )
    , Playable {

    override fun toString(): String {
        return "DVD: { \n" +
                "    id: " + id + "\n" +
                "    title: " + title + "\n" +
                "    category: " + category + "\n" +
                "    director: " + director + "\n" +
                "    length: " + length + " minutes\n" +
                "    cost: " + cost + "$" + "\n" +
                "}"
    }

    override fun play() {
        println("Playing DVD: $title")
        println("DVD length: $length minutes")
    }
}
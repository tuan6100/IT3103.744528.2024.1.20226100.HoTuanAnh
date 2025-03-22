package hust.soict.itep.aims.media

open class Disc(var director: String, var length: Int, id: Int, title: String, category: String, cost: Float)
    : Media(id, title, category, cost) {

    override fun toString(): String {
        return "Disc: { \n" +
                "    id: "+ id + "\n" +
                "    title: " + title + "\n" +
                "    category: " + category + "\n" +
                "    director: " + director + "\n" +
                "    length: " + length + " minutes\n" +
                "    cost: " + cost + "$" + "\n" +
                "}"
    }

    
}
package hust.soict.itep.aims.media

class Book(var authors: MutableList<String>, id: Int, title: String, category: String, cost: Float)
    : Media(id, title, category, cost) {

    override fun toString(): String {
        return "Book: { \n" +
                "    id: "+ id + "\n" +
                "    title: " + title + "\n" +
                "    category: " + category + "\n" +
                "    authors: [" + printAuthors + "]\n" +
                "    cost: " + cost + "$" + "\n" +
                "}"
    }

    val printAuthors = {
        authors.joinToString(", ")
    }

}
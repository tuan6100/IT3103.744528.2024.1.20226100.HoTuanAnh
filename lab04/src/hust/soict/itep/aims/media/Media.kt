package hust.soict.itep.aims.media

abstract class Media(var id: Int, var title: String, var category: String, var cost: Float) {

    override fun equals(o: Any?): Boolean {
        val media = o as Media
        return media.title == this.title
    }

    fun isMatch(searchString: String): Boolean {
        return title.contains(searchString, ignoreCase = true)
    }

    abstract override fun toString(): String

    final override fun hashCode(): Int {
        var result = id
        result = 31 * result + cost.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + category.hashCode()
        return result
    }
}

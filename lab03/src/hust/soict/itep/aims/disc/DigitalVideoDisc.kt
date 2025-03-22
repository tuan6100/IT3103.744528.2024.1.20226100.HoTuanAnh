package hust.soict.itep.aims.disc

data class DigitalVideoDisc(val id: Int = 0, val title: String, val category: String, val director: String, val length: Int, val cost: Float) {

    constructor(title:String) : this(0, title, "", "", 0, 0f)

    override fun toString(): String {
        return "DVD - $title - $category - $director - $length : $cost $"
    }

    fun isMatch(title: String): Boolean {
        return this.title.equals(title, ignoreCase = true)
    }
}
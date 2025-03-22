package hust.soict.itep.aims.cart

import hust.soict.itep.aims.media.Media

class Cart (val itemOrdered: MutableList<Media> = mutableListOf() ) {

    fun addMedia(media: Media) {
        itemOrdered.add(media)
    }

    fun addMedia(vararg medias: Media) {
        require(medias.isNotEmpty()) { "No media to add" }
        for (media in medias) {
            itemOrdered.add(media)
        }
    }

    fun removeMedia(media: Media) {
        require(itemOrdered.contains(media)) { "Media not found in cart" }
        itemOrdered.remove(media)
    }

    fun totalCost(): Float {
        var total = 0f
        for (media in itemOrdered) {
            total += media.cost
        }
        return total
    }

    fun searchById(id: Int): Media? {
        return itemOrdered.find { media -> media.id == id }

    }

    fun searchByTitle(title: String): Media? {
        return itemOrdered.find { media -> media.isMatch(title) }
    }

    fun print() {
        println("\n*********************CART************************** \nOrdered items: \n")
        for (dvd in itemOrdered) {
            println(dvd.toString())
        }
        println(String.format("Total cost: %.2f\n", totalCost()))
        println("***************************************************\n\n")
    }

    fun sortByTitleCost() {
        itemOrdered.sortWith(compareBy<Media> { it.title }.thenByDescending { it.cost })
    }

    fun sortByCostTitle() {
        itemOrdered.sortWith(compareByDescending<Media> { it.cost }.thenBy { it.title })
    }

    fun empty() {
        itemOrdered.clear()
    }

}
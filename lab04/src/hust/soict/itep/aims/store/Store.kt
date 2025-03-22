package hust.soict.itep.aims.store

import hust.soict.itep.aims.media.Media

class Store (val itemInStore: MutableList<Media> = mutableListOf() ) {

    fun addMedia(media: Media) {
        itemInStore.add(media)
    }

    fun removeMedia(media: Media?) {
        itemInStore.remove(media)
    }

    fun searchById(id: Int): Media? {
        return itemInStore.find { media -> media.id == id }
    }

    fun searchByTitle(title: String): Media? {
        return itemInStore.find { media -> media.isMatch(title) }
    }

    fun print() {
        println("\n*********************STORE************************** \nItems in store: \n")
        for (dvd in itemInStore) {
            println(dvd.toString())
        }
        println("***************************************************\n\n")
    }
}
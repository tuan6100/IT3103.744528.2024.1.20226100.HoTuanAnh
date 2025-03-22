package hust.soict.itep.aims.store

import hust.soict.itep.aims.disc.DigitalVideoDisc

class Store (val itemInStore: MutableList<DigitalVideoDisc> = mutableListOf() ) {

    fun addDvd(disc: DigitalVideoDisc) {
        itemInStore.add(disc)
    }

    fun removeDvd(disc: DigitalVideoDisc) {
        itemInStore.remove(disc)
    }

    fun print() {
        println("\n*********************STORE************************** \nItems in store: \n")
        for (dvd in itemInStore) {
            println(dvd.toString())
        }
        println("***************************************************\n\n")
    }
}
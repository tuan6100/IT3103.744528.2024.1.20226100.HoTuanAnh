package hust.soict.itep.aims.cart

import hust.soict.itep.aims.disc.DigitalVideoDisc

class Cart (val itemOrdered: MutableList<DigitalVideoDisc> = mutableListOf() ) {

    fun addDvd(disc: DigitalVideoDisc) {
        itemOrdered.add(disc)
    }

    fun addDvd(vararg discs: DigitalVideoDisc) {
        for (disc in discs) {
            itemOrdered.add(disc)
        }
    }

    fun removeDvd(disc: DigitalVideoDisc) {
        itemOrdered.remove(disc)
    }

    fun totalCost(): Float {
        var total = 0f
        for (media in itemOrdered) {
            total += media.cost
        }
        return total
    }

    fun searchById(id: Int): DigitalVideoDisc? {
        return itemOrdered.find { disc -> disc.id == id }
    }

    fun searchByTitle(title: String): DigitalVideoDisc? {
        return itemOrdered.find { disc -> disc.isMatch(title) }
    }

    fun print() {
        println("\n*********************CART************************** \nOrdered items: \n")
        for (dvd in itemOrdered) {
            println(dvd.toString())
        }
        println(String.format("Total cost: %.2f\n", totalCost()))
        println("***************************************************\n\n")
    }

}
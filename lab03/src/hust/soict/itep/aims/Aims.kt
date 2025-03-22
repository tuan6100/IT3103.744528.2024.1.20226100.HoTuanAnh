package hust.soict.itep.aims

import hust.soict.itep.aims.cart.Cart
import hust.soict.itep.aims.disc.DigitalVideoDisc

fun main() {
    val anOrder = Cart()
    val dvd1 =
        DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f)
    val dvd2 =
        DigitalVideoDisc(2, "Star wars", "Science Fiction", "Geogre Lucas", 87, 24.95f)
    anOrder.addDvd(dvd1, dvd2)
    anOrder.print()
    anOrder.removeDvd(dvd1)
    anOrder.print()
}
package com.soict.itep

fun main() {

    val cart = Cart()
    val dvd1 = DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f)
    val dvd2 = DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f)
    val dvd3 = DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f)
    cart.addDigitalVideoDisc(dvd1)
    cart.addDigitalVideoDisc(dvd2)
    cart.addDigitalVideoDisc(dvd3)
    cart.print()
    cart.removeDigitalVideoDisc(dvd2)
    cart.print()
}
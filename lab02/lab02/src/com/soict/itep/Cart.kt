package com.soict.itep


class Cart (val MAX_NUMBERS_ORDERED: Int = 20,
            val itemsOrdered: Array<DigitalVideoDisc?> = arrayOfNulls(MAX_NUMBERS_ORDERED),
            var qtyOrdered: Int = 0){

    fun addDigitalVideoDisc(disc: DigitalVideoDisc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc
            qtyOrdered++
        } else {
            println("The cart is full. Cannot add more DVDs.")
        }
    }

    fun removeDigitalVideoDisc(disc: DigitalVideoDisc) {
        if (qtyOrdered > 0) {
            var found = false
            for (i in 0 until qtyOrdered) {
                if (itemsOrdered[i] == disc) {
                    found = true
                    for (j in i until qtyOrdered - 1) {
                        itemsOrdered[j] = itemsOrdered[j + 1]
                    }
                    qtyOrdered--
                    break
                }
            }
            if (!found) {
                println("The disc is not in the cart.")
            }
        } else {
            println("The cart is empty.")
        }
    }

    fun totalCost(): Float {
        var total = 0.0f
        for (i in 0 until qtyOrdered) {
            total += itemsOrdered[i]?.cost ?: 0.0f
        }
        return return String.format("%.2f", total).toFloat()
    }

    fun print() {
        if (qtyOrdered == 0) {
            println("The cart is empty.")
        } else {
            println("Items in the cart:")
            for (i in 0 until qtyOrdered) {
                println("${i + 1}. ${itemsOrdered[i]?.title} - ${itemsOrdered[i]?.category} - ${itemsOrdered[i]?.director} - ${itemsOrdered[i]?.length} - ${itemsOrdered[i]?.cost}")
            }
            println("Total cost: ${totalCost()}")
        }
    }

}
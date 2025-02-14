package com.soict.itep

class DigitalVideoDisc(val title: String? = null,
                       val category: String? = null,
                       val director: String? = null,
                       val length: Int? = null,
                       val cost: Float? = null) {

    constructor(title: String) : this(title, null, null, null, null)

    constructor(title: String, category: String, cost: Float) :
            this(title, category, null, null, cost)

    constructor(title: String, category: String, director: String, cost: Float) :
            this(title, category, director, null, cost)

}
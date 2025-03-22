package hust.soict.itep.aims

import hust.soict.itep.aims.cart.Cart
import hust.soict.itep.aims.media.Book
import hust.soict.itep.aims.media.CompactDisc
import hust.soict.itep.aims.media.DigitalVideoDisc
import hust.soict.itep.aims.media.Media
import hust.soict.itep.aims.media.Track
import hust.soict.itep.aims.store.Store
import kotlin.system.exitProcess


fun showMenu(store: Store, cart: Cart) {
    while (true) {
        println("\n AIMS: ")
        println("--------------------------------")
        println("1. View store")
        println("2. Update store")
        println("3. See current cart")
        println("0. Exit")
        println("--------------------------------")
        println("Please choose a number: 0-1-2-3")
        print("Your option: ")

        val option: Int = readLine()!!.toInt()
        when (option) {
            0 -> {
                run {
                    println("Thank you.\n")
                    exitProcess(0)
                }
                run {
                    storeMenu(store, cart)
                }
            }

            1 -> {
                storeMenu( store, cart)
            }

            2 -> {
                updateStoreMenu(store)
            }

            3 -> {
                cart.print()
                cartMenu(cart)
            }

            else -> {
                println("No option. Try again.")
            }
        }
    }
}


fun storeMenu(store: Store, cart: Cart) {
    println("\n")
    store.print()
    while (true) {
        println("\n Options: ")
        println("--------------------------------")
        println("1. See a media details")
        println("2. Add a media to cart")
        println("3. Play a media")
        println("4. See current cart")
        println("0. Back")
        println("--------------------------------")
        println("Please choose a number: 0-1-2-3-4")
        print("Your option: ")
        val option: Int = readLine()!!.toInt()
        when (option) {
            0 -> return

            1 -> {
                mediaDetailsMenu(store, cart)
            }

            2 -> {
                print("Enter media's title: ")
                val title: String? = readLine()
                val media: Media? = store.searchByTitle(title.toString())
                if (media == null) {
                    println("No media found")
                } else {
                    try {
                        cart.addMedia(media)
                    } catch (e: Exception) {
                        println(e.message)
                    }
                }
            }

            3 -> {
                print("Enter media's title: ")
                val title: String? = readLine()
                val media: Media? = store.searchByTitle(title.toString())
                if (media == null) {
                    println("No media found")
                } else {
                    if (media is Book) {
                        println("This media is not disc")
                    } else {
                        if (media is DigitalVideoDisc) {
                            val dvd = media
                            dvd.play()
                        } else if (media is CompactDisc) {
                            val cd = media
                            cd.play()
                        }
                    }
                }
            }

            4 -> {
                cart.print()
                cartMenu(cart)
            }

            else -> {
                println("No option. Try again.")
            }
        }
    }
}


fun updateStoreMenu(store: Store) {
    println("\n Options: ")
    println("--------------------------------")
    println("1. Add media")
    println("2. Remove media")
    println("0. Back")
    println("--------------------------------")
    println("Please choose a number: 0-1-2")
    print("Your option: ")
    val option: Int = readLine()!!.toInt()
    when (option) {
        0 -> return

        1 -> {
            println("Choose media type: ")
            println("------------------------")
            println("1. Book")
            println("2. DVD")
            println("3. CD")
            println("0. Back")
            println("------------------------")
            println("Please choose a number: 0-1-2-3")
            print("Your option: ")
                val option2: Int = readLine()!!.toInt()
            when (option2) {
                0 -> return

                1 -> {
                    print("Enter id: ")
                    val id: Int = readLine()!!.toInt()
                    print("Enter title: ")
                    val title: String? = readLine()
                    print("Enter category: ")
                    val category: String? = readLine()
                    print("Enter cost: ")
                    val cost: Float = readLine()!!.toFloat()
                    print("Enter amount of authors: ")
                    val num: Int = readLine()!!.toInt()
                    val authors: MutableList<String> = ArrayList()
                    var i = 0
                    while (i < num) {
                        System.out.printf("Enter name of author %d: ", i++ + 1)
                        val author: String? = readLine()
                        if (author != null) {
                            authors.add(author)
                        }
                    }
                    try {
                        store.addMedia(Book(authors, id, title.toString(), category.toString(), cost))
                    } catch (e: Exception) {
                        println(e.message)
                    }
                }

                2 -> {
                    print("Enter id: ")
                    val id: Int = readLine()!!.toInt()
                    print("Enter title: ")
                    val title: String? = readLine()
                    print("Enter category: ")
                    val category: String? = readLine()
                    print("Enter cost: ")
                    val cost: Float = readLine()!!.toFloat()
                    print("Enter director's name: ")
                    val director: String? = readLine()
                    print("Enter dvd's length: ")
                    val length: Int = readLine()!!.toInt()
                    try {
                        store.addMedia(DigitalVideoDisc(director.toString(), length, id,
                            title.toString(), category.toString(), cost, ))
                    } catch (e: Exception) {
                        println(e.message)
                    }
                }

                3 -> {
                    print("Enter id: ")
                    val id: Int = readLine()!!.toInt()
                    print("Enter title: ")
                    val title: String? = readLine()
                    print("Enter category: ")
                    val category: String? = readLine()
                    print("Enter cost: ")
                    val cost: Float = readLine()!!.toFloat()
                    print("Enter director's name: ")
                    val director: String? = readLine()
                    print("Enter artist's name: ")
                    val artist: String? = readLine()
                    print("Enter amount of tracks: ")
                    val num: Int = readLine()!!.toInt()
                    readLine()
                    val tracks: MutableList<Track> = ArrayList()
                    var i = 0
                    while (i < num) {
                        System.out.printf("Enter title of track %d : ", i + 1)
                        val trackTitle: String? = readLine()
                        System.out.printf("Enter length of track %d: ", i + 1)
                        val lenght: Int = readLine()!!.toInt()
                        readLine()
                        tracks.add(Track(trackTitle.toString(), lenght))
                        i++
                    }
                    try {
                        store.addMedia(CompactDisc(artist.toString(), tracks, director.toString(), 0, id, title.toString(), category.toString(), cost))
                    } catch (e: Exception) {
                        println(e.message)
                    }
                }
                else -> {
                    println("No option. Try again.")
                }
            }
        }

        2 -> {
            print("Enter media's title: ")
            readLine()
            val title: String? = readLine()
            val media: Media? = store.searchByTitle(title.toString())
            try {
                store.removeMedia(media)
            } catch (e: Exception) {
                println(e.message)
            }
        }

        else -> {
            println("No option. Try again.")
        }
    }
}


fun mediaDetailsMenu(store: Store, cart: Cart) {
    print("Enter media's title: ")
    val title: String? = readLine()
    val media: Media? = store.searchByTitle(title.toString())
    if (media == null) {
        println("No media found")
        return
    }
    println(media)
    while (true) {
        println("\n Options: ")
        println("--------------------------------")
        println("1. Add to cart")
        println("2. Play")
        println("0. Back")
        println("--------------------------------")
        println("Please choose a number: 0-1-2")
        print("Your option: ")
        val option: Int = readLine()!!.toInt()
        readLine()
        when (option) {
            1 -> {
                try {
                    cart.addMedia(media)
                } catch (e: Exception) {
                    println(e.message)
                }
            }

            2 -> {
                if (media is Book) {
                    println("This media is unplayable")
                } else {
                    if (media is DigitalVideoDisc) {
                        val dvd = media
                        dvd.play()
                    } else if (media is CompactDisc) {
                        val cd = media
                        cd.play()
                    }
                }
            }
            0 -> {
                return
            }
        }
    }
}


fun cartMenu(cart: Cart) {
    while (true) {
        println("\n Options: ")
        println("--------------------------------")
        println("1. Filter medias in cart")
        println("2. Sort medias in cart")
        println("3. Remove media from cart")
        println("4. Play a media")
        println("5. Place order")
        println("0. Back")
        println("--------------------------------")
        println("Please choose a number: 0-1-2-3-4-5")
        print("Your option: ")
        val option: Int = readLine()!!.toInt()
        readLine()
        when (option) {
            0 -> {
                return
            }

            1 -> {
                println("Option: ")
                println("______________")
                println("1. Filter by id")
                println("2. Filter by title")
                println("______________")
                println("Please choose a number: 1-2")
                print("Your option: ")
                val option2: Int = readLine()!!.toInt()
                readLine()
                if (option2 == 1) {
                    print("Enter media id: ")
                    val id: Int = readLine()!!.toInt()
                    readLine()
                    val media: Media? = cart.searchById(id)
                    if (media == null) {
                        println("No media found")
                    } else {
                        System.out.println(media.toString())
                    }
                } else if (option2 == 2) {
                    print("Enter media title: ")
                    val title: String = readLine().toString()
                    val media: Media? = cart.searchByTitle(title)
                    if (media == null) {
                        println("No media found")
                    } else {
                        System.out.println(media.toString())
                    }
                } else {
                    println("No option. Try again.")
                }
            }

            2 -> {
                println("Option: ")
                println("______________")
                println("1. Sort by title")
                println("2. Sort by cost")
                println("______________")
                println("Please choose a number: 1-2")
                print("Your option: ")
                val option2: Int = readLine()!!.toInt()
                readLine()
                if (option2 == 1) {
                    cart.sortByTitleCost()
                    cart.print()
                } else if (option2 == 2) {
                    cart.sortByCostTitle()
                    cart.print()
                } else {
                    println("No option. Try again.")
                }
            }

            3 -> {
                print("Enter media's title: ")
                val title: String = readLine().toString()
                val media: Media? = cart.searchByTitle(title)
                if (media == null) {
                    println("No media found")
                } else {
                    try {
                        cart.removeMedia(media)
                    } catch (e: Exception) {
                        println(e.message)
                    }
                }
            }

            4 -> {
                print("Enter media's title: ")
                val title: String = readLine().toString()
                val media: Media? = cart.searchByTitle(title)
                if (media == null) {
                    println("No media found")
                } else {
                    if (media is Book) {
                        println("This media is unplayable")
                    } else {
                        if (media is DigitalVideoDisc) {
                            val dvd = media
                            dvd.play()
                        } else if (media is CompactDisc) {
                            val cd = media
                            cd.play()
                        }
                    }
                }
            }

            5 -> {
                println("An order is created. ")
                cart.empty()
            }

            else -> {
                println("No option. Try again.")
            }
        }
    }
}


fun main() {
    val store = Store()
    val cart = Cart()
    showMenu(store, cart)
}
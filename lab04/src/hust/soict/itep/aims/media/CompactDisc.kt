package hust.soict.itep.aims.media

import java.util.function.Consumer

class CompactDisc(var artist: String, var tracks: MutableList<Track>, director: String, length: Int, id: Int, title: String, category: String, cost: Float)
    : Disc(director, length, id, title, category, cost),
    Playable {

        constructor() : this("", mutableListOf(), "", 0, 0, "", "", 0.0f)

    fun addTrack(track: Track) {
        if (tracks.contains(track)) {
            println("Track already exists")
        } else {
            tracks.add(track)
        }
    }

    fun removeTrack(track: Track) {
        if (tracks.contains(track)) {
            tracks.remove(track)
        } else {
            throw Exception("Track not found")
        }
    }

    val getLength = {
        tracks.sumOf { it.length }
    }

    override fun play() {
        println("Playing CD: $title")
        println("CD artist: $artist")
        println("CD lenght: $length")
        tracks.forEach(Consumer { track: Track? -> track!!.play() })
    }

}
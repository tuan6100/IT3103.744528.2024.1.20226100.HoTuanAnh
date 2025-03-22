package hust.soict.itep.aims.media

class Track(var title: String, var length: Int) : Playable {

    override fun play() {
        println("Playing track: $title")
        println("Track length: $length minutes")
    }

    override fun equals(other: Any?): Boolean {
        val track = other as Track
        return track.title == this.title && track.length == this.length
    }

    override fun hashCode(): Int {
        var result = length
        result = 31 * result + title.hashCode()
        return result
    }
}
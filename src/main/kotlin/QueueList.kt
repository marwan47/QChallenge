class QueueList {
    private val tracks:MutableList<Track> = mutableListOf()
    private var currentTrackIdx: Int = 0

    fun getCurrentTrack(): Track? {
        return if (tracks.size != 0) tracks[currentTrackIdx] else null
    }

    fun next(): Track?{
        return if(tracks.size != 0 && currentTrackIdx+1 < tracks.size) {
            currentTrackIdx++
            tracks[currentTrackIdx]
        }else{
            null
        }
    }

    fun previous(): Track?{
        return if(tracks.size != 0 && currentTrackIdx > 0) {
            currentTrackIdx--
            tracks[currentTrackIdx]
        }else{
            null
        }
    }
    fun size(): Int {
        return tracks.size
    }

}
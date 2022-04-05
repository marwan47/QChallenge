import java.lang.Exception

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

    fun add(track: Track){
        tracks.add(track)
    }
    fun add(trackList:List<Track>){
        tracks.addAll(trackList)
    }

    fun removeAt(index: Int){
        if(index >=0 && index < tracks.size){
            /* Assuming we can remove a track that's currently playing:
               the currentTrack(the one we deleted) will be replaced with the next one
               if there is no next(last item): it will be replaced by the previous
               if there are no more tracks it will simply be deleted
             */
            if(currentTrackIdx > index){
                currentTrackIdx--
            }else if(currentTrackIdx == index && currentTrackIdx == tracks.size - 1){
                // in case we're trying to remove the last track that's currently playing
                currentTrackIdx--
            }
            tracks.removeAt(index)
        }else{
            if(tracks.size == 0){
                throw Exception("cannot remove an item from ${::tracks.name} because it's empty!")
            }else{
                throw Exception("cannot remove item at position [$index] from ${::tracks.name}: index out of bounds!")
            }
        }
    }

    fun size(): Int {
        return tracks.size
    }

}
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject
import java.io.File
import java.lang.Exception

class TracksLoader() {
    companion object{
        fun loadFromFile(filePath: String): List<Track>{
            val tracks:List<Track>
            val textData = File(filePath).readText()

            val data = Json.parseToJsonElement(textData)
            val jo = data.jsonObject
            val dataJson = jo["data"]
            val albumJson = dataJson?.jsonObject?.get("album")
            val tracksJson = albumJson?.jsonObject?.get("tracks")
                ?: throw Exception("could not retrieve tracks from json file , make sure the format is correct!")
            tracks = Json.decodeFromJsonElement(tracksJson)
            /*for (track in tracks){
                println(track)
            }*/
            return tracks
        }
    }
}
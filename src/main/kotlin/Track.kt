import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class Track(val id:String,
                 val artist:String,
                 val title:String,
                 val duration: Int,
                 val media: Media) {
}
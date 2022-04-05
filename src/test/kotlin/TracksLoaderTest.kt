import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TracksLoaderTest{
    private val qList = QueueList()

    @BeforeEach
    internal fun setUp() {
        qList.add(TracksLoader.loadFromFile("data/tracks.json"))
    }

    @Test
    fun testLoadAllTracks(){

        assertEquals(20,qList.size())
    }

    @Test
    fun testRetrieveFirstTrack(){
        val track = Track("916409", "Eminem", "Curtains Up (Skit)",29,Media("916409"))
        assertEquals(track.id, qList.getCurrentTrack()!!.id)
    }

    @Test
    fun testRetrieveLastTrack(){
        val lastTrack = Track("916448", "Eminem", "Curtains Close",60,Media("916448"))
        for (n in 1..19){
            qList.next()
        }
        assertEquals(lastTrack.id, qList.getCurrentTrack()!!.id)
    }

}
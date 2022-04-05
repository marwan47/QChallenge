import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertFalse

internal class QueueListTest {
    private val qList = QueueList()
    private val media1 = Media("916409")
    private val track1 = Track("916409","Eminem", "Curtains Up (Skit)", 29, media1)
    private val track2 = Track("223331","Eminem", "Soldier", 10, media1)
    private val track3 = Track("916416","Eminem", "Square Dance", 324, media1)

    @Test
    fun testCurrentTrackForEmptyQList() {
        assertNull(qList.getCurrentTrack())
    }

    @Test
    fun testNextForEmptyQList() {
        assertNull(qList.next())
    }

    @Test
    fun testPreviousForEmptyQList() {
        assertNull(qList.previous())
    }

    @Test
    fun testAddOneTrack(){
        qList.add(track1)
        assertEquals(1,qList.size())
    }

    @Test
    fun testAddTwoTracks(){
        val tracks = listOf(track1,track2)
        qList.add(tracks)
        assertEquals(2,qList.size())
    }

    @Test
    fun testCurrTrackWith2(){
        val tracks = listOf(track1,track2)
        qList.add(tracks)
        val currTrack = qList.getCurrentTrack()
        assertEquals(track1,currTrack)
    }

    @Test
    fun testNextTrackWith2(){
        val tracks = listOf(track1,track2)
        qList.add(tracks)
        val currTrack = qList.next()
        assertEquals(track2,currTrack)
    }

    @Test
    fun testPreviousTrackWith2(){
        val tracks = listOf(track1,track2)
        qList.add(tracks)
        qList.next()
        val currTrack = qList.previous()
        assertEquals(track1,currTrack)
    }

    @Test
    fun testPreviousTrackOutOfBounds(){
        val tracks = listOf(track1,track2)
        qList.add(tracks)
        qList.next()
        qList.previous()
        val currTrack = qList.previous()
        assertNull(currTrack)
    }

    @Test
    fun testRemoveNotCurrentLast(){ // removing the last item which is not currently being played
        val tracks = listOf(track1,track2, track3)
        qList.add(tracks)
        qList.removeAt(2)
        assertEquals(2,qList.size())
    }

    @Test
    fun testRemoveNotCurrentFirst(){ // removing the first item which is not currently being played
        val tracks = listOf(track1,track2, track3)
        qList.add(tracks)
        qList.next()
        qList.removeAt(0)
        val current = qList.getCurrentTrack()
        assertEquals(track2,current)
    }

    @Test
    fun testRemoveCurrentLast(){ // removing the last item which is currently being played
        val tracks = listOf(track1,track2, track3)
        qList.add(tracks)
        qList.next()
        qList.next()
        qList.removeAt(2)
        val current = qList.getCurrentTrack()
        assertEquals(track2,current)
    }

    @Test
    fun testRemoveCurrentFirst(){ // removing the first item which is currently being played
        val tracks = listOf(track1,track2, track3)
        qList.add(tracks)
        qList.removeAt(0)
        val current =  qList.getCurrentTrack()
        assertEquals(track2,current)
    }
    @Test
    fun testRemoveCurrentSecond(){ // removing the second item which is currently being played
        val tracks = listOf(track1,track2, track3)
        qList.add(tracks)
        qList.next()
        qList.removeAt(1)
        val current =  qList.getCurrentTrack()
        assertEquals(track3,current)
    }

    @Test
    fun testRemoveOutOfBounds(){  // removing a track with an invalid index (outOfBound)
        val tracks = listOf(track1,track2, track3)
        qList.add(tracks)
        assertThrows<Exception> {
            qList.removeAt(-1)
        }
    }

    @Test
    fun testLoadDataFromJason(){}

}
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class QueueListTest {
    private val qList = QueueList()

    @Test
    fun currentTrackForEmptyQList() {
        assertNull(qList.getCurrentTrack())
    }

    @Test
    fun nextForEmptyQList() {
        assertNull(qList.next())
    }

    @Test
    fun previousForEmptyQList() {
        assertNull(qList.previous())
    }
}
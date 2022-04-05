fun main(args: Array<String>) {
    println("Hello Deezer World!")

    // the unit tests are in "test/kotlin/QueueListTest.kt"

    val media1 = Media("916409")
    val track1 = Track("916409","Eminem", "Curtains Up (Skit)", 29, media1)
    val track2 = Track("223331","Eminem", "Soldier", 10, media1)
    val track3 = Track("916416","Eminem", "Square Dance", 324, media1)
    println("track1 : $track1")
    val queueList = QueueList()
    println("number of tracks in QueueList : ${queueList.size()}")

    queueList.add(track1)
    queueList.add(listOf(track2,track3))
    queueList.next()
    var currentTrack = queueList.getCurrentTrack()
    println("current : $currentTrack")
    currentTrack = queueList.next()
    println("next : $currentTrack")
    currentTrack = queueList.previous()
    println("previous : $currentTrack")


}
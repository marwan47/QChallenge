fun main(args: Array<String>) {
    println("Hello Deezer World!")

    // the unit tests are in "test/kotlin/QueueListTest.kt" and "test/kotlin/TracksLoaderTest.kt"
    val queueList = QueueList()

    val filePath = "data/tracks.json"
    val tracks = TracksLoader.loadFromFile(filePath)
    queueList.add(tracks)
    println("number of tracks in QueueList : ${queueList.size()}")




}
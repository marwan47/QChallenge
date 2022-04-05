fun main(args: Array<String>) {
    println("Hello Deezer World!")

    val media1 = Media("916409")
    val track1 = Track("916409","Eminem", "Curtains Up (Skit)", 29, media1)
    val track2 = Track("223331","Eminem", "Soldier", 10, media1)
    println("track1 : $track1")
    val queueList = QueueList()
    println("number of tracks in QueueList : ${queueList.size()}")



}
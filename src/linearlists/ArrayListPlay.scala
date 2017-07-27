package linearlists

import java.util.ArrayList
import simplethings._

/**
  * Created by Alex on 7/14/2017.
  */
object ArrayListPlay {
  def main(args: Array[String]): Unit = {
    val songs = createSongList()
    display("The songs ...", songs)
    val actors = creatActorList()
    display("The actors ...", actors)
    val triangles = creatTriangleList()
    display("The triangles ...", triangles)

    displayLengths(songs)
    displayInitials(actors)
    displayAreas(triangles)
  }

  private def createSongList(): ArrayList[String] ={
    val songs = new ArrayList[String]

    songs.add("Happy")
    songs.add("Dog Days are Over")
    songs.add("Budapest")
    songs.add("Give Me Your Eyes")
    songs.add("Castle of Glass")
    songs.add("Heralds")
    songs.add("Heralds")
    songs.add("No Rest for the Wicked")
    songs.add("Death from Above")

    songs
  }

  private def creatActorList(): ArrayList[Name] ={
    val actors = new ArrayList[Name]

    actors.add(new Name("Ryan", "Reynolds"))
    actors.add(new Name("Hugh", "Jackman"))
    actors.add(new Name("Zach", "Braff"))
    actors.add(new Name("Bradley", "Cooper"))
    actors.add(new Name("Halle", "Berry"))
    actors.add(new Name("Kate", "Mara"))
    actors.add(new Name("Kevin", "Spacey"))

    actors
  }

  private def creatTriangleList(): ArrayList[Triangle] ={
    val triangles = new ArrayList[Triangle]

    triangles.add(new Triangle(30))
    triangles.add(new Triangle(6, 12, 9))
    triangles.add(new Triangle(3, 4, 5))
    triangles.add(new Triangle(10))
    triangles.add(new Triangle(12))
    triangles.add(new Triangle(12, 13, 14))

    triangles
  }

  private def display(text: String, items: ArrayList[_]): Unit ={
    println(s"\n$text")
    for(i <- 0 until items.size()){
      println(items.get(i))
    }
  }

  private def displayLengths(songs: ArrayList[String]): Unit ={
    println("\nThe Song Lengths ...")
    for(i <- 0 until songs.size()){
      println(songs.get(i).length)
    }
  }

  private def displayInitials(actors: ArrayList[Name]): Unit ={
    println("\nThe Initials ...")
    for(i <- 0 until actors.size()){
      println(actors.get(i).initials)
    }
  }

  private def displayAreas(triangles: ArrayList[Triangle]): Unit ={
    println("\nThe Areas ...")
    for(i <- 0 until triangles.size()){
      println(triangles.get(i).area)
    }
  }
}

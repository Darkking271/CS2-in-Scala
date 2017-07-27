package linearlists

import java.util.LinkedList
import java.text.DecimalFormat
import java.lang.Double
/**
  * Created by Alex on 7/14/2017.
  */
object LinkedListPlay {
  def main(args: Array[String]): Unit = {
    //Create Lists
    val animals = createAnimalList()
    display("\nThe Animal Names ...", animals)

    val reals = randomList(77)
    display("\nThe Real Number ...", reals)

    //Use Lists
    val lengthsList= lengths(animals)
    display("\nThe lengths of the animal names ...", lengthsList)

    val reverseAnimals = reverse(animals)
    display("\nThe animals in reverse order ...", reverseAnimals)

    var min: Double = minimum(reals)
    println(s"\nThe minimum number = $min")
    display("\nThe reals numbers ...", reals)

    val orderList = sort(reals)
    display("\nThe real numbers in ascending order ...", orderList)
    display("\nThe real numbers ...", reals)
  }

  private def createAnimalList(): LinkedList[String] ={
    val animals = new LinkedList[String]

    animals.add("Aardvark")
    animals.add("Bear")
    animals.add("Crocodile")
    animals.add("Dove")
    animals.add("Elephant")
    animals.add("Finch")
    animals.add("Giraffe")
    animals.add("Hyena")
    animals.add("Iguana")
    animals.add("Jackalope")
    animals.add("Bat")
    animals.add("Walrus")
    animals.add("Lobster")

    animals.add("Lion")
    animals.add("Tiger")
    animals.add("Bison")
    animals.add("Woodpecker")
    animals.add("Panda")
    animals.add("Ox")
    animals.add("Yak")
    animals.add("Bull")
    animals.add("Elk")
    animals.add("Fox")

    animals
  }

  private def randomList(x: Int): LinkedList[Double] ={
    val reals = new LinkedList[Double]
    val dec = new DecimalFormat(".#")
    for(i <- 0 until x){
      var num = (Math.random() * 1000) / 10
      reals.addLast(new Double(dec.format(num)))
    }
    reals
  }

  private def lengths(animals: LinkedList[String]): LinkedList[Int] ={
    val lengths = new LinkedList[Int]
    for(a <- 0 until animals.size())
      lengths.add(animals.get(a).length)
    lengths
  }

  private def reverse(animals: LinkedList[String]): LinkedList[String] ={
    val reverseAnimals = new LinkedList[String]
    for(i <- (0 until animals.size()).reverse)
      reverseAnimals.add(animals.get(i))
    reverseAnimals
  }

  private def minimum(reals: LinkedList[Double]): Double ={
    var min = 100.0
    for(i <- 0 until reals.size()){
      if(reals.get(i) < min)
        min = reals.get(i)
    }
    min
  }

  private def sort(reals: LinkedList[Double]): LinkedList[Double] ={
    var copy = new LinkedList[Double](reals)

    if(copy.isEmpty)
      return copy

    val min = minimum(reals)
    copy.remove(min)
    copy = sort(copy)
    copy.addFirst(min)
    copy
  }

  private def display(text: String, items: LinkedList[_]): Unit ={
    print(s"$text\n< ")
    for(i <- 0 until items.size()){
      print(s"${items.get(i)} ")
      if((i + 1) % 10 == 0)
        println()
    }
    println(" >")
  }
}

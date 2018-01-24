package App

import scala.io.StdIn

object GameOfThronesInput extends App {

  val forename = StdIn.readLine("What is your full name? ")
  val bastardNames = List[String]("Snow", "Sand", "Rivers", "Stone", "Flowers", "Storm", "Pyke", "Waters", "Hill")

  def printName(name: String): Unit = {

    for (title <- bastardNames)
      if (name.split(" ").last == title) {
        println(s"Hello $name! You are a bastard!")
        return
      } else {
        val house = name.split(" ").last
        println(s"Hello $name! You are from House $house!")
        return
      }
  }
  printName(forename)
}
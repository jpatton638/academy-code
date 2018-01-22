package App

import scala.io.StdIn

object Main extends App {

  def printName(name: String, age: String, profession: String) : Unit = {

    if (name == "John") {
      println("Go away John, I already know you")
    } else {
      println(s"Hello $name! You are $age years old! You are a $profession")
    }

  }

  val name = StdIn.readLine("What is your name? ")
  val age = StdIn.readLine("How old are you? ")
  val profession = StdIn.readLine("What is your job title? ")

  printName(name, age, profession)
}
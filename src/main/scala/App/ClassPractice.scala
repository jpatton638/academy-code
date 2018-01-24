package App

import scala.io.StdIn

object ClassPractice extends App {

  val name = StdIn.readLine("What is your name? ")
  val age = StdIn.readLine("What is your age? ")

  def printName(name: String, age: String): Unit = {
    println(s"Hello $name! You are $age years old!")
  }
}

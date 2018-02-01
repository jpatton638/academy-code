package App

import scala.io.StdIn

object scrabble extends App{

  val input = StdIn.readLine("Input a word \n")

  val dictionary: Set[String] = scala.io.Source.fromFile("/usr/share/dict/british-english").getLines.toSet

  if (dictionary(input)) {

    val scrabble: Word = new Word(input)
    scrabble.calculateScore(input.toUpperCase())
  } else {
    println("This is not a word")
  }
}

class Word(word: String) {

  def calculateScore(word: String) : Unit = {

    val score = Map('E' -> 1, 'A' -> 1, 'I' -> 1, 'O' -> 1, 'N' -> 1,'R' -> 1, 'T' -> 1, 'L' -> 1, 'S' -> 1, 'U' -> 1,
      'D' -> 2, 'G' -> 2, 'B' -> 3, 'C' -> 3, 'M' -> 3, 'P' -> 3, 'F' -> 4, 'H' -> 4, 'V' -> 4, 'W' -> 4,
      'Y' -> 4, 'K' -> 5, 'J' -> 8, 'X' -> 8, 'Q' -> 10, 'Z' -> 10)

    val scrabbleWord = word.toList
    val total = scrabbleWord.foldLeft(0)(_ + score(_))

    println(s"${word.toLowerCase.capitalize} scores $total points")
  }
}
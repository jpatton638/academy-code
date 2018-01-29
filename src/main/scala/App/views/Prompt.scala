package App.views

import scala.io.StdIn

/**
  * Generate terminal prompts
  */
object Prompt {

  def ask(message : String) : String = StdIn.readLine(message)
}

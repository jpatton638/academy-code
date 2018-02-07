import scala.io.Source

trait Logging {

  def log : Boolean

}

trait LoggingToFile extends Logging {

  override def log: Boolean = {
    val file = Source.fromFile("").getLines()
    true
  }

}

abstract class Bank
class SAccount extends Bank

val acc = new SAccount() with LoggingToFile
val acc2 = new SAccount()

acc.log

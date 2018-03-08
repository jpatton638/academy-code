import java.util.{Date, Calendar}

import scala.util.{Failure, Success, Try}

object Date {

  def parse(d: String): Option[Date] = {
    val date = """(\d{4})-(\d{2})-(\d{2})""".r

    d match {
      case date(year, month, day) =>

        val cal = Calendar.getInstance()
        val tryDate = Try {
          cal.set(year.toInt, month.toInt-1, day.toInt)
          cal.getTime
        }

        tryDate match {
          case Success(x) => Some(x)
          case Failure(_) => None
        }
      case _ => None
    }
  }
}

Date.parse("2016-05-21")
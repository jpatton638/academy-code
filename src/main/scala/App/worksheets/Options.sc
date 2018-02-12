def markAnswer(a: String): Option[Boolean] = {
  if (a.nonEmpty) // If answer is not empty
    Some(a.toLowerCase.matches("dog")) // Return Some answer if it matches "dog"
  else { // If answer is empty
    None // return None
  }
}

val scoreForQ1: Option[Boolean] = markAnswer("Cat")
val scoreForQ2: Option[Boolean] = markAnswer("Dog")

// If value is defined
if (scoreForQ1.isDefined) {
  // Get value if exists or return false
  val score = scoreForQ2.getOrElse(false)
  score
}

// Get value by mapping over value
scoreForQ2.map(b => b)

// Get value by folding
scoreForQ2.fold(false)(b => {
  println(b)
  b
}
)

// Operate using Pattern matching
scoreForQ2 match {
  case None => ???
  case Some(x) => x
}

// EXERCISE

abstract class User(val name: String,
                    val gender: Option[String] = None
                   )

case class Person(override val name : String,
                  override val gender: Option[String] = None
                 ) extends User(name, gender)

case class Employee(id : Int,
                    override val name : String) extends User(name, None)


object UserRepository {

  private val _people = List(
    Person("John", Some("Male")),
    Person("Toni", None),
    Employee(123, "Steve")
  )

  def findByName(name: String): Option[User] = {
    _people.find(u => u.name == name)
  }

  def findEmployees(): List[Employee] = {
    _people.flatMap {
      case Person(_,_) => None
      case e @ Employee(_,_) => Some(e)
    }
  }
}

val filtered = UserRepository.findByName("John") // Find the user by name
  .flatMap( // Use flatMap to flatten the structure down
    _.gender.map( // Map over gender
      _.toLowerCase.matches("male"))) // Return user if male

val userString = for {
  user <- UserRepository.findByName("John") // Assign to temp val user
} yield s"${user.name}" // Yield the name of the user

userString

UserRepository.findEmployees()
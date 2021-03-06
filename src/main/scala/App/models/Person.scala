package App.models

/**
  * Person, including secondary constructors
  */
class Person(name : String, age: Int, private val accounts: Seq[BankAccount] = Nil) {

  def this(name: String, age: Int) = this(name, age, List(new SavingsAccount("12345678", 0.00)))
  def this(name: String) = this(name, 0, List(new SavingsAccount("87654321", 0.00)))
  def this(firstName: String, lastName: String) = this(s"$firstName $lastName", 0,
                                        List(new SavingsAccount("99998888", 0.00)))

  private val excudedNames: List[String] = List("adam", "nicci", "mark", "jamie")
  private val years : String = if(age == 1) "year" else "years"

  def speak() : String = {
    if (excudedNames.contains(name.toLowerCase)) {
      "You don't get a hello."
    } else {
      s"Hello $name, you are $age $years old. \n$accounts"
    }
  }
}


package scala.app

import scala.io.StdIn


abstract class BankAccount(accountNumber : String, val balance: Double) {

  def withdraw(amount: Double) : BankAccount

  def deposit(amount: Double) : BankAccount

}

class SavingsAccount(accountNumber: String,
                     balance : Double) extends BankAccount(accountNumber,balance) {

  override def deposit(amount: Double): BankAccount = new SavingsAccount(accountNumber, balance + amount)

  override def withdraw(amount: Double): BankAccount = new SavingsAccount(accountNumber, balance - amount)

}

class Person(name : String, age: Int, private val bankAccount: BankAccount) {

  def this(name: String, age: Int) = this(name, age, new SavingsAccount("12345678", 0.00))
  private val years : String = if(age == 1) "year" else "years"

  def speak() : String = {
    if (name == "John") {
      "You don't get a hello."
    } else {
      s"Hello $name, you are $age $years old. \n You have ${bankAccount.balance.} in your account"
    }
  }

}

object Prompt {`

  def ask(message : String) : String = StdIn.readLine(message)

}

object GreetingsApplication extends App {


  val savingsAccount = new SavingsAccount("12345", 100.00)
  val savingsPlus100 = savingsAccount.deposit(100.00)


  val name : String = Prompt.ask("What is your name? ")
  val age : String = Prompt.ask("How old are you? ")

  val p : Person = new Person(name, age.toInt)

  println(p.speak())


}
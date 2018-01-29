package App.controllers

import App.models.{CashISASavingsAccount, Person, SavingsAccount}
import App.views.Prompt

/**
  * Instantiate everything
  */
object GreetingsController extends App {

  val savingsAccount = new SavingsAccount("12345", 100.00)
  val savingsPlus100 = savingsAccount.deposit(100.00)


  val name : String = Prompt.ask("What is your name?\n")
  val age : String = Prompt.ask("How old are you?\n")


  val p : Person = new Person(name, age.toInt)
  val child = new Person("David")
  val p2 = new Person("John", "Patton")


    println(p.speak())

  val cashISA = new CashISASavingsAccount("22334455", 0.00)
  val isaDeposited = cashISA.deposit(10000.00)
  val withdrawFromISA = isaDeposited.withdraw(200.00)
  val personWithCashISA = new Person("Loyal Customer", 56, List(withdrawFromISA))

    println(personWithCashISA.speak())

  val superAccount = new CashISASavingsAccount(accountNumber = "55667788", balance =  0.00, depositThreshold = 1000.00).deposit(1000.00).withdraw(200.00)
  val superUser = new Person("Bryan", 58, List(superAccount))

  println(superUser.speak())
}

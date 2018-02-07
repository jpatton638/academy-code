package App.models

/**
  * Cash ISA with difference rules
  */
final class CashISASavingsAccount(accountNumber: String, balance: Double, private val depositThreshold: Double = 200.00)
  extends BankAccount (accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = {
    println(s"You cannot withdraw from this Cash ISA")
    this
  }

  override def deposit(amount: Double): BankAccount = {
    if (amount > depositThreshold) {
      val difference = amount - depositThreshold
      println(s"You can't deposit more that £$depositThreshold\nExcess: £$difference")
      new CashISASavingsAccount(accountNumber, balance + depositThreshold)
    } else {
      new CashISASavingsAccount(accountNumber, balance + amount)
    }
  }
}

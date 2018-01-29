package App.models

/**
  * Abstract class for all bank accounts
  */
abstract class BankAccount(accountNumber : String, val balance: Double) {

  def withdraw(amount: Double) : BankAccount
  def deposit(amount: Double) : BankAccount

  override def toString: String = s"Account Number: $accountNumber\nBalance: $balance"
}

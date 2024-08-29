object Q4 {

  class Account(val accountNumber: String, private var balance: Double) {

    def deposit(amount: Double): Unit = {
      if (amount > 0) {
        balance += amount
        println(s"Deposited ${amount} into account $accountNumber. New balance: ${balance}")
      } else {
        println("Deposit amount must be positive.")
      }
    }

    def withdraw(amount: Double): Unit = {
      if (amount > 0 ) {
        balance -= amount
        println(s"Withdrew ${amount} from account $accountNumber. New balance: ${balance}")
      } else {
        println("Withdrawal amount must be positive.")
      }
    }

    def getBalance: Double = balance
  }


  def accountsWithNegativeBalances(accounts: List[Account]): List[Account] = {
    accounts.filter(_.getBalance < 0)
  }

  def sumAllBalances(accounts: List[Account]): Double = {
    accounts.map(_.getBalance).sum
  }

  def interest(accounts: List[Account]): List[Account] = {
    accounts.map { account =>
      val balance = account.getBalance
      if (balance > 0) {
        account.deposit(balance * 0.05)
      } else {
        account.withdraw(-balance * 0.1)
      }
      account
    }
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account("A001", 2000.00)
    val account2 = new Account("B012", -600.00)
    val account3 = new Account("C001", 100.00)
    val accounts = List(account1, account2, account3)

    val negativeAccounts = accountsWithNegativeBalances(accounts)
    println(s"Accounts with negative balances: ${negativeAccounts.map(_.accountNumber)}")

    val totalBalance = sumAllBalances(accounts)
    println(s"Total balance of all accounts: ${totalBalance}")

    val accountsAfterInterest = interest(accounts)
    accountsAfterInterest.foreach { account =>
      println(s"Account ${account.accountNumber} final balance: ${account.getBalance}")
    }
  }
}

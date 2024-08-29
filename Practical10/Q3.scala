object Q1{

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
            if (amount > 0 && amount <= balance) {
            balance -= amount
            println(s"Withdrew ${amount} from account $accountNumber. New balance: ${balance}")
            } else if (amount > balance) {
            println("Insufficient funds.")
            } else {
            println("Withdrawal amount must be positive.")
            }
        }

        def transfer(toAccount: Account, amount: Double): Unit = {
            if (amount > 0 && amount <= balance) {
            this.withdraw(amount)
            toAccount.deposit(amount)
            println(s"Transferred ${amount} from account $accountNumber to account ${toAccount.accountNumber}.")
            } else {
            println("Transfer failed due to insufficient funds or invalid amount.")
            }
        }

        def getBalance: Double = balance
    }

    def main(args: Array[String]): Unit = {

        val account1 = new Account("A123", 1000.00)
        val account2 = new Account("B456", 500.00)

        account1.deposit(200.00)
        account1.withdraw(150.00)
        account1.transfer(account2, 300.00)

        println(s"Account 1 balance: ${account1.getBalance}")
        println(s"Account 2 balance: ${account2.getBalance}") 
    }
}
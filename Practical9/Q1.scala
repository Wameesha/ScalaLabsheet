object Q1{
    def calculateInterest(deposit:Double):Double={
        val interestRate: Double => Double = amount => amount match {
            case n if n <= 20000    => 0.02
            case n if n <= 200000   => 0.04
            case n if n <= 2000000  => 0.035
            case _                  => 0.065
        }

        val interest = deposit * interestRate(deposit)
        interest
    }

    def main(args: Array[String]): Unit = {
        val deposits = List(10000, 50000, 300000, 2500000)
        deposits.foreach { deposit =>
            println(s"The interest for a deposit of Rs. $deposit is Rs. ${calculateInterest(deposit)}")
        }
    }
}
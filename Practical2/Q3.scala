object Q3{

    def main(args: Array[String]): Unit = {
        
    }
// Question 03
    def normal(hours:Int):Int = hours * 250;
    def ot(hours:Int):Int = hours * 85;
    def income(h1:Int, h2:Int):Int = normal(h1) + ot(h2);
    def tax(income: Int): Double = income * 0.12

    def takeHome(h1: Int, h2: Int): Double = {
        val totalIncome = income(h1, h2)
        totalIncome - tax(totalIncome)
    }
    println("Take Home Salary: " + takeHome(40,30));
}
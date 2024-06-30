
object Q3{

    def main(args: Array[String]): Unit = {
        val num1 = 22
        val num2 = 31
        val mean = calculateMean(num1,num2)
    }

    def calculateMean(num1: Int, num2: Int) = {
        val mean = (num1 + num2)/2.0
        println(f"$mean%.2f") 
    }
}
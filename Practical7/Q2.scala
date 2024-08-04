object Q2{
    def  calculateSquare(numbers: List[Int]): List[Int] ={
        numbers.map(n => n * n)
    }

    def main(args: Array[String]): Unit = {
        val input = List (1,2,3,4,5)
        val output = calculateSquare(input)
        println(output)
    }
}
object Q1{
    def filterEvenNumbers(numbers: List[Int] ) : List[Int] ={
        numbers.filter(n => n % 2 == 0)
    }

    def main(args: Array[String]): Unit = {  
        val input = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val output = filterEvenNumbers(input)
        println(output)
    }
}
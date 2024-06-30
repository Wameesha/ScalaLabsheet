object Q4{
    def main(args: Array[String]): Unit = {
        val myList: List[Int] = List(1,2,3,4,5,6,7,8,9)
        println(sumOfEven(myList))
    }

    def sumOfEven(n: List[Int]):Int= {
        n.filter(_%2 == 0).sum
    }
}
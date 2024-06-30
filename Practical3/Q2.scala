object Q2{
    def main(args: Array[String]): Unit = {
        val myList: List[String] = List("Apple" , "Orange" , "Banana", "Mango","date","pig","car","bus")
        val filterString = filter(myList)
        println(filterString)
    }

    def filter(s: List[String]):List[String] = {
        s.filter(_.length > 5)
    }
    
}
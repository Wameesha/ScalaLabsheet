object Q1{
    def main(args: Array[String]): Unit = {
        var input = "Hello World!";
        var reverseStr = reverseString(input)
        println(reverseStr)

    }

    def reverseString(s:String):String = {
        if (s.isEmpty)"" 
        else reverseString(s.tail) + s.head
    }
}
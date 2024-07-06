object patternMatchingExample{
    def main(args: Array[String]): Unit = {
        val input = 10
        
        input match{
            case x if x<=0 => println("Negative/Zero is input")
            case x if x % 2 == 0 => println("Even number is given")
            case x if x % 2 != 0 => println("Odd number is given")
        }
    }
}
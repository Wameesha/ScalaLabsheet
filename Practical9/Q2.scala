object Q2{

    def main(args: Array[String]): Unit = {
        print("Enter an Interger: ")
        val number = scala.io.StdIn.readInt()
    

        val patternMatching: Int => String = {
            case x if x <= 0 => "Negative/Zero is input"
            case x if x % 2 == 0 => "Even number is given"
            case _ => "Odd number is given"
        }

        println(patternMatching(number))

    }
    
}

object Q3{
    def toUpper(name: String): String = name.toUpperCase()
    def toLower(name: String): String = name.toLowerCase()
    def formatNames(name: String)(formatFuntion: String => String): String = formatFuntion(name)

    def main(args: Array[String]): Unit = {
        val names = List("Benny", "Niroshan", "Saman", "Kumara")

        names.foreach{
            case "Benny"     => println(formatNames("Benny")(toUpper))
            case "Niroshan"  => println(formatNames("Niroshan")(name => name.take(2).toUpperCase + name.drop(2)))
            case "Saman"     => println(formatNames("Saman")(toLower))
            case "Kumara"    => println(formatNames("Kumara")(name => name.head.toUpper + name.tail.init + name.last.toUpper))
            case _           => println("Name not found")
        }
    }   
}
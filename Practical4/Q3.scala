object Q3{
    var name1 = "Benny"
    var name2 = "Niroshan"
    var name3 = "Saman"
    var name4 = "Kumara"

    def toUpper(s: String):String = s.toUpperCase()
    def toLower(s: String):String = s.toLowerCase()
    def formatNames(name:String)(formatFunction: String => String):String = formatFunction(name)

    val formattedName1 = formatNames(name1)(toUpper)
    val formattedName2 = formatNames(name2)(name => name.substring(0, 2).toUpperCase + name.substring(2).toLowerCase)
    val formattedName3 = formatNames(name3)(toLower)
    val formattedName4 = formatNames(name4)(name => name.substring(0, 1).toUpperCase + name.substring(1, 5).toLowerCase + name.substring(5).toUpperCase)

    println(formattedName1)
    println(formattedName2)
    println(formattedName3)
    println(formattedName4)

    def main(args: Array[String]): Unit = {
        
    }

}
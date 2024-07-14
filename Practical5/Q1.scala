import scala.compiletime.ops.string
object Q1{
    def main(args: Array[String]): Unit = {
        val products = getProductList()
        printProductList(products)
        println(s"Total number of products: ${getTotalProducts(products)}")
    }

    def getProductList(): List[String] ={
        import scala.io.StdIn.readLine
        def readProducts(products: List[String]): List[String] = {
            val input = readLine("Enter product name or type 'done' to finish: ")
            if(input.toLowerCase == "done" ) products
            else readProducts(products :+ input)
        } 
        readProducts(List.empty[String])
    }

    def printProductList(products: List[String]): Unit = {
        products.zipWithIndex.foreach{case(product, index)=>
            println(s"${index + 1}. $product")
        }
    }

    def getTotalProducts(products: List[String]): Int = {
        products.length
    }
}
object Q1{

    def getProductNames(inventory: Map[Int, (String, Int, Double)]): List[String] = {
        inventory.values.map(_._1).toList
    }

    def calculateTotalValue(inventory: Map[Int, (String, Int, Double)]) : Double = {
        inventory.values.map{ case (_, quantity, price) => quantity*price}.sum
    }

    def isInventoryEmpty(inventory: Map[Int, (String, Int, Double)]): Boolean = {
        inventory.isEmpty
    }

    def mergeInventories(
        inventory1: Map[Int, (String, Int, Double)],
        inventory2: Map[Int, (String, Int, Double)]
    ): Map[Int, (String, Int, Double)] = {
        inventory2.foldLeft(inventory1) {
         case (mergedInventory, (id, (name, quantity, price))) =>
            mergedInventory.get(id) match {
                case Some((_, existingQuantity, existingPrice)) =>
                    mergedInventory.updated(id, (name, existingQuantity + quantity, existingPrice max price))
                case None =>
                    mergedInventory.updated(id, (name, quantity, price))
            }
        }
    }

    def printProductDetails(inventory: Map[Int, (String, Int, Double)], productId: Int):Unit ={
        inventory.get(productId) match {
            case Some((name, quantity, price)) =>
                println(s"Product ID: $productId, Name: $name, Quantity: $quantity, Price: $price")
            case None => 
                println(s"Product with Id $productId does not exist.")
        }
    }

    def main(args: Array[String]): Unit = {
     
        val inventory1 = Map(
            101 -> ("ProductA", 10, 15.5),
            102 -> ("ProductB", 5, 25.0),
            103 -> ("ProductC", 20, 10.0)
        )

        val inventory2 = Map(
            102 -> ("ProductB", 10, 30.0),
            104 -> ("ProductD", 15, 20.0)
        )

        // Retrieve all product names
        val productNames = getProductNames(inventory1)
        println("Product Names: " + productNames.mkString(", "))

        // Calculate the total value of all products
        val totalValue = calculateTotalValue(inventory1)
        println("Total Value: " + totalValue)

        // Check if inventory1 is empty
        val isEmpty = isInventoryEmpty(inventory1)
        println("Is inventory1 empty? " + isEmpty)

        // Merge inventory1 and inventory2
        val mergedInventory = mergeInventories(inventory1, inventory2)
        println("Merged Inventory: " + mergedInventory)

        // Check if a product with ID 102 exists and print its details
        printProductDetails(inventory1, 102)

    }
}
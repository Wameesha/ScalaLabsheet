object inventoryManagement{
    var itemNames: Array[String] = Array("apple", "banana", "orange")
    var itemQuantities: Array[Int] = Array(10,20,30)

    def displayInventory(): Unit ={
        println("Inventory:")
        for(i<- itemNames.indices){
            println(s"${itemNames(i)}: ${itemQuantities(i)}")
        }
    }

    def restockItem(itemName: String, quantity: Int): Unit ={
        val index = itemNames.indexOf(itemName)
        if(index >= 0){
             itemQuantities(index) += quantity
             println(s"Restocked $quantity of $itemName. New quantity: ${itemQuantities(index)}")
        } else {
             println(s"Item $itemName does not exist in the inventory.")
        }
    }

    def sellItem(itemName: String, quantity: Int): Unit = {
       val index = itemNames.indexOf(itemName)
       if (index >= 0) {
          if (itemQuantities(index) >= quantity) {
             itemQuantities(index) -= quantity
             println(s"Sold $quantity of $itemName. Remaining quantity: ${itemQuantities(index)}")
          } else {
             println(s"Not enough quantity of $itemName to sell. Available quantity: ${itemQuantities(index)}")
          }
       } else {
          println(s"Item $itemName does not exist in the inventory.")
       }
    }
        
    def main(args: Array[String]): Unit = {
        displayInventory()
        restockItem("apple", 5)
        sellItem("banana", 10)
        sellItem("orange", 20)
        displayInventory()
    }
}
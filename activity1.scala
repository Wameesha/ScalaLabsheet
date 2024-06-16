object Main{
def main(args: Array[String]): Unit = {
    val redius = 5
    val area = areaOfDisk(redius )
    println("Area of disk is: " + area)

    val cen = 35
    val far = fahrenheit(cen)
    println("The temperature is : "+ far)

    val r = 5
    val volume = volumeOfsphere(r)
    println("Volume of a sphere: "+ volume)

    val coverp = 24.95
    val copies = 60
    println("Whole cost for 60 copies: " + wholesalecost(coverp,copies))

    val km1 = 4
    val km2 = 3
    val newValue = "Total running time: " + totaltime(km1,km2)
    println(newValue)

}
def areaOfDisk(redius: Double):Double = math.Pi*redius*redius;

def fahrenheit(cen:Double):Double = cen*1.8+32.00;

def volumeOfsphere(r:Double):Double = 4/3*math.Pi*r*r*r;

def discountprice(coverp:Double):Double = coverp*(1-0.4);
def totalcost(copies:Int ,coverp:Double):Double = copies*discountprice(coverp);
def shippingcost(copies:Int):Double = 50*3 + (copies-50)*0.75;
def wholesalecost(coverp:Double, copies:Int):Double = totalcost(copies,coverp) + shippingcost(copies); 

def easypacetime(km1:Int):Int = km1*8;
def tempotime(km2:Int):Int = km2*7;
def totaltime(km1:Int, km2:Int):Int = easypacetime(km1)+tempotime(km2);

}

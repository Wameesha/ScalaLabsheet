object Q2{

class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numer: Int = n / gcdValue
  val denom: Int = d / gcdValue

  def neg: Rational = new Rational(-numer, denom)

  def sub(that: Rational): Rational = {
    val newNumer = this.numer * that.denom - that.numer * this.denom
    val newDenom = this.denom * that.denom
    new Rational(newNumer, newDenom)
  }

  override def toString: String = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}

  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val yMinusZ = y.sub(z)

    val result = x.sub(yMinusZ)

    println(s"x = $x")
    println(s"y = $y")
    println(s"z = $z")
    println(s"y - z = $yMinusZ")
    println(s"x - (y - z) = $result")
  }
}


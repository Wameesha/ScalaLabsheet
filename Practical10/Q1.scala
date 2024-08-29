class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numer: Int = n / gcdValue
  val denom: Int = d / gcdValue

  def neg: Rational = new Rational(-numer, denom)

  override def toString: String = s"$numer/$denom"

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}

def main(args: Array[String]): Unit = {
    val x = new Rational(4, 8)
    val negX = x.neg
    println(s"Original: $x")
    println(s"Negated: $negX")

}

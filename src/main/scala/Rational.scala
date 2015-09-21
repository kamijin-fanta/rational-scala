package com.github.kamijin_fanta.math

object Rational {
  def pow(n: Int, k: Int): Int = k match {
    case kk if kk < 0 => 0
    case 0 => 1
    case 1 => n
    case 2 => n * n
    case kk if kk % 2 == 0 => pow(pow(n, k / 2), 2)
    case _ => pow(n, k / 2) * pow(n, (k + 1) / 2)
  }

  val fromDecimal = (str: String) => {
    val list = str.split('.')
    if (list.length == 2 && list.forall(_.forall(_.isDigit))) {
      val num = (list(0) + list(1)).toInt
      Some(Rational(num, pow(10, list(1).length)))
    } else {
      None
    }
  }
  val fromInt = (str: String) => {
    if (str.forall(_.isDigit)) {
      Some(Rational(str.toInt))
    } else {
      None
    }
  }
  val fromFraction = (str: String) => {
    val list = str.split('/')
    if (list.length == 2 && list.forall(_.forall(_.isDigit))) {
      Some(Rational(list(0).toInt, list(1).toInt))
    } else {
      None
    }
  }

  def apply(str: String): Rational = {
    val res = List(fromDecimal, fromInt, fromFraction).flatMap(_(str)).headOption
    require(res != None, "Format error: " + str)
    res.get
  }
}

case class Rational(numerator: Int, denominator: Int = 1) {
  require(denominator != 0, "Numerator require not 0")

  lazy val reduction: Rational = {
    val g = gcd(numerator, denominator)
    val n: Int = numerator * denominator.signum / g
    val d: Int = denominator * denominator.signum / g
    copy(numerator = n, denominator = d)
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a
    else gcd(b, a % b)
  }

  override def toString() = {
    s"Rational(${numerator}/${denominator})"
  }

  override def equals(other: Any) = other match {
    case that: Rational =>
      that.reduction.numerator == reduction.numerator &&
        that.reduction.denominator == reduction.denominator
    case _ => false
  }
}

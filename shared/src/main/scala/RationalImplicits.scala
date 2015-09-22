package com.github.kamijin_fanta.math

import scala.math.Fractional

object RationalImplicits {
  val rationalFractional = new Fractional[Rational] {
    override def div(x: Rational, y: Rational): Rational =
      Rational(x.numerator * y.denominator, x.denominator * y.numerator).reduction

    override def plus(x: Rational, y: Rational): Rational =
      Rational(x.numerator * y.denominator + x.denominator * y.numerator, x.denominator * y.denominator).reduction

    override def negate(x: Rational): Rational =
      Rational(-x.numerator, x.denominator).reduction

    override def times(x: Rational, y: Rational): Rational =
      Rational(x.numerator * y.numerator, x.denominator * y.denominator).reduction

    override def minus(x: Rational, y: Rational): Rational =
      Rational(x.numerator * y.denominator - x.denominator * y.numerator, x.denominator * y.denominator).reduction

    override def compare(x: Rational, y: Rational): Int =
      (x.numerator * y.denominator) compare (x.denominator * y.numerator)


    override def fromInt(x: Int): Rational =
      Rational(x)

    override def toInt(x: Rational): Int =
      (x.numerator / x.denominator).toInt

    override def toLong(x: Rational): Long =
      (x.numerator.toLong / x.denominator)

    override def toFloat(x: Rational): Float =
      x.numerator.toFloat / x.denominator.toFloat

    override def toDouble(x: Rational): Double =
      x.numerator.toDouble / x.denominator.toDouble
  }
  val rationalOrdering = new Ordering[Rational] {
    override def compare(x: Rational, y: Rational): Int =
      rationalFractional.compare(x,y)
  }
  
  implicit def FractionalOps(x: Rational) = new rationalFractional.FractionalOps(x)
  implicit def OrderingOps(x: Rational) = new rationalOrdering.Ops(x)
}

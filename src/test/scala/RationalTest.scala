import com.github.kamijin_fanta.math.Rational
import com.github.kamijin_fanta.math.RationalImplicits._
import org.scalatest.FunSpec

class RationalTest extends FunSpec {
  describe("Rational") {
    it("1/2 + 1/4") {
      assert(Rational(1, 2) + Rational(1, 4) == Rational(3, 4))
    }
    withClue("1/0") {
      intercept[IllegalArgumentException]{Rational(1, 0) == Rational(1)}
    }
    it("1/5 * 7/10") {
      assert(Rational(1, 5) * Rational(7, 10) == Rational(7, 50))
    }
    it("20/49 > 20/50") {
      assert(Rational(20, 49) > Rational(20, 50))
    }
    it("123/6 < 123/5") {
      assert(Rational(123, 6) < Rational(123, 5))
    }
  }
}

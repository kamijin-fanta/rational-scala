# Rational on Scala

Scalaで分数

```
1/2 + 1/4 = 3/4
```

## Document

### build.sbt

Compatible to 2.10 and 2.11 scala version

```
resolvers += "github kamijin-fanta maven repo" at "https://kamijin-fanta.github.io/repo/maven/"
libraryDependencies += "com.github.kamijin_fanta" %% "rational-scala" % "1.0.0"
```

### Import

```
import com.github.kamijin_fanta.math.Rational
import com.github.kamijin_fanta.math.RationalImplicits._
```

### New Object

```
scala> Rational(4,5)
res0: com.github.kamijin_fanta.math.Rational = Rational(4/5)

scala> Rational("5")
res1: com.github.kamijin_fanta.math.Rational = Rational(5/1)

scala> Rational("2/3")
res2: com.github.kamijin_fanta.math.Rational = Rational(2/3)

scala> Rational("1.234")
res3: com.github.kamijin_fanta.math.Rational = Rational(1234/1000)

scala> Rational(1,0)
java.lang.IllegalArgumentException: requirement failed: Numerator require not 0
```

### Four arithmetic operations

```
Rational(1, 2) + Rational(1, 4)  // 1/2 + 1/4 = 3/4
Rational(1, 5) * Rational(7, 10) // 1/5 * 7/10 = 7/50
```

List of operator

- +
- -
- *
- /

### Compare

```
scala> Rational(20, 49) > Rational(20, 50)
res0: Boolean = true
```

List of operator and method

- \<
- \<=
- \>
- \>=
- max
- min

### Reduction

```
scala> Rational(15,20)
res0: com.github.kamijin_fanta.math.Rational = Rational(15/20)

scala> res0.reduction
res1: com.github.kamijin_fanta.math.Rational = Rational(3/4)
```

```
scala> Rational(15,20) == Rational(3,4)
res2: Boolean = true
```

### Type Conversion 

- toInt
- toLong
- toFloat
- toDouble

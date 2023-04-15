package com.rockthejvm

object Basic extends App {
  // What is the difference between a class and an object?
  // A class is a blueprint for an object
  // An object is an instance of a class
  println("Hello, Scala!")

  //defining a value
  // values are like constants
  val meaningOfLife: Int = 42 // const int meaningOfLife = 42;

  // Int, Boolean, Char, Double, Float, String
  val aBoolean = false // type is optional

  // strings and string operations
  val aString = "I love Scala"
  val aComposedString = "I" + " " + "love" + " " + "Scala"
  val anInterpolatedString = s"The meaning of life is $meaningOfLife"

  // expression = structures that can be reduces to a value
  val anExpression = 2 + 3

  // in Scala everything can be interpreted as an expression(even control elements too)
  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  // in other languages(ternary operator): meaningOfLife > 43 ? 56 : 999
  println(ifExpression)
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife >= 999) 78
    else 0
  println(chainedIfExpression)

  // code blocks
  val aCodeBlock = {
    // definitions
    val aLocalValue = 67

    // value of a block is the value of the last expression
    aLocalValue + 40
  }
  println(aCodeBlock)

  // define a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  }
  def myFunctionSimple(x: Int, y: String): String = y + " " + x

  // recursive function
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1)

  /*
  factorial(5) = 5 * factorial(4) = 5 * 24 = 120
  factorial(4) = 4 * factorial(3) = 4 * 6
  factorial(3) = 3 * factorial(2) = 3 * 2
  factorial(2) = 2 * factorial(1) = 2 * 1
  factorial(1) = 1
   */

  // In Scala we don't use loops or iteration, we use RECURSION!

  // the Unit type = no meaningful value === "void" in other languages
  // type of SIDE EFFECTS
  println("I love Scala")

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit")
    5
  }

  println(myUnitReturningFunction())

  val theUnit: Unit = ()
  print(theUnit)
}

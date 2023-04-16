package edu.learn

object FunctionalProgramming extends App  {

  // Scala is OO
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // INVOKING bob
  bob apply 54

  /*
    Scala runs on the JVM
    Functional programming:
    - compose functions
    - pass functions as args
    - return functions as results

    Conclusion: FunctionX = Function1, Function2, ... Function22 (max 22 params)

   */

  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  simpleIncrementer.apply(24) // 24
  simpleIncrementer(24) // simpleIncrementer.apply(23)
  simpleIncrementer apply 24
  // defined a function!

  // ALL SCALA FUNCTIONS ARE INSTANCES OF THESE FUNCTION_X TYPES

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }

  stringConcatenator("I love", "SCALA") // "I love SCALA"

  // syntax sugars
  val doubler: Function1[Int, Int] = (x: Int) => 2 * x
  println(doubler(4)) // 8

  val doubler2: Int => Int = (x: Int) => 2 * x
  println(doubler2(4)) // 8

  val doubler3 = (x: Int) => 2 * x
  println(doubler3(4)) // 8

  /*
  equivalent to the much longer:

  var double: Function[Int, Int] = new Function1[Int, Int] {
    override def apply(x: Int) = 2 * x
  }
   */

  // high-order functions: take functions as args/return functions
  val aMappedList = List(1, 2, 3).map(x => x + 1)
  println(aMappedList)
  val aFlatMappedList = List(1, 2, 3).flatMap(x => List(x, 2*x))
  println(aFlatMappedList)

  // alternative syntax
  val aFlatMappedList2 = List(1, 2, 3).flatMap { x =>
    List(x, 2 * x)
  }
  println(aFlatMappedList2)

  val aFilteredList = List(1, 2, 3, 4, 5).filter(x => x <= 3)
  println(aFilteredList)

  // alternative syntax
  val aFilteredList2 = List(1, 2, 3, 4, 5).filter(_ <= 3)
  println(aFilteredList2)

  // all the pairs between 1,2,3 and the letters 'a','b','c'
  val allPairsOneList = List(1, 2, 3).flatMap(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairsOneList)
  val allPairsListList = List(1, 2, 3).map(number => List('a', 'b', 'c').map(letter => s"$number-$letter"))
  println(allPairsListList)

  // for comprehensions
  val alternativePairs = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
  } yield s"$number-$letter"
  println(alternativePairs)

  val alternativeTriples = for {
    number <- List(1, 2, 3)
    letter <- List('a', 'b', 'c')
    sign  <- List('+', '*')
  } yield s"$number-$letter-$sign"
  println(alternativeTriples)


  /**
   * Collections
   */

  // lists
  val aList = List(1, 2, 3, 4, 5)
  val firstElement = aList.head
  val res = aList.tail
  val aPrependedList = 0 :: aList // List(0, 1, 2, 4, 5) --prepend
  val anExtendedList = 0 +: aList :+ 6 // List(0, 1, 2, 3, 4, 5, 6) -- prepand, append

  // sequences
  val aSequence: Seq[Int] = Seq(1, 2, 3) // Seq.apply(1, 2, 3)
  val accessedElement = aSequence(1) // the element at index 1: 2

  // vectors: fast sequence implementation
  val aVector = Vector(1, 2, 3, 4, 5)

  // sets = no duplicates
  val aSet = Set(1, 2, 3, 4, 1 ,2 ,3) // Set(1, 2, 3 ,4)
  val setHas5 = aSet.contains(5) // false
  val anAddedSet = aSet + 5
  val addedSetHas5 = anAddedSet.contains(5) // true
  val aRemovedSet = aSet - 3
  println(aSet)
  println(setHas5)
  println(anAddedSet)
  println(addedSetHas5)
  println(aRemovedSet)

  // ranges
  val aRange = 1 to 1000
  val twoByTo = aRange.map(x => 2 * x).toList // List(2, 4, 6, 8 ..., 2000)

  // tuples = groups of values under the same value
  val aTuple = ("Bon Jovi", "Rock", 1982)
  println(aTuple)

  // maps
  val aPhoneBook: Map[String, Int] = Map(
    ("Daniel", 4654684),
    "Jane" -> 54845 // ("Jane", 54845)
  )
  println(aPhoneBook)



}

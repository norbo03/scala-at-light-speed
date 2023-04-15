package edu.learn

object ObjectOrientation extends App {

  // java equivalent: public static void main(String[] args)
  // class and instance
  class Animal {
    // define fields
    val age: Int = 0

    // define methods
    def eat(): Unit = println("I am eating")
  }

  val anAnimal = new Animal

  // inheritance
  class Dog(val name: String) extends Animal { // constructor definition
  }

  val aDog = new Dog("Lassie")

  // constructor argument(name) are NOT fields: need to put a val before the constructor argument
  // aDog.name // not visible outside the class
  println(aDog.name)

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime
  // ? dinamikus kotes

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, can restrict by private or protected

    // -- there is no public keyword
    def walk(): Unit
  }

  // "interface" = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit = // valid mehtod name
      println(s"I have a though: $thought")
  }

  // Scala offers single-class inheritance and multi-trait inheritance(~ "mixing")
  class Crocodile extends Animal with Carnivore with Philosopher {
    override def eat(animal: Animal): Unit = {
      println(s"I am eating you: $animal")
    }

    override def eat(): Unit = println("Crocodile: I am eating")

    override def ?!(thought: String): Unit = println(s"Crocodile: I was thinking - $thought")
  }

  val aCrocodile = new Crocodile
  aCrocodile.eat()
  aCrocodile.eat(aDog)

  println("--------------------------------")

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog // infix notation = object method argument -- can be used when the method has only ONE argument
  aCroc ?! "What if we could fly?"

  // operators in Scala are actually methods
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // equivalent

  println("--------------------------------")

  class Thinker(val name: String) extends Philosopher {
    override def ?!(thought: String): Unit = super.?!(thought)
  }

  val aristotle = new Thinker("Aristotle")
  print(aristotle.name + ": ")
  aristotle.?!("What is life?")

  // anonymous classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur, so I can eat pretty much everything!")
  }

  /*

  What you tell the compiler:

  class Carnivore_Anonymous_5845454 extends Carnivore {
    override def eat(animal: Animal): Unit = println("I am a dinosaur, so I can eat pretty much everything!")
   }

   val dinosaur = new Carnivore_Anonymous_5845454
   */

  // singleton object
  object MySingleton { // the only isntance of the MySingleton type
    val mySpecialValue = 4654654

    def mySpecialMethod(): Int = 549999

    def apply(x: Int): Int = x + 1
  }

  println(MySingleton.mySpecialMethod())
  MySingleton.apply(65)
  MySingleton(65) // equivalent to MySingleton.apply(65)

  // What is the object in Scala?
  // 1. It's a singleton instance
  // 2. It's a COMPANION to the class of the same name
  // 3. It's a way to implement the Singleton pattern in Scala

  // What is a companion in Scala?
  // - A class and its singleton object can access each other's private members

  // It has the same name as the class (or trait) Animal
  object Animal { // companions - companion object
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLiveIndefinitely = false
  }

  val animalsCanLiveForever = Animal.canLiveIndefinitely // "static" fields/methods

  /*
  case classes = lightweight data structures with some boilerplate
   - sensible equals and hash code
   - serialization
   - companion with apply
   - pattern matching
   */

  case class Person(name: String, age: Int)

  // may be constructed without new
  val bob = Person("Bob", 54) // can omit the "new" keyword because it has a companion object with the apply method
  // equivalent = Person.apply("Bob", 54)

  // exceptions
  try {
    // code that can throw
    val x: String = null
    x.length
  } catch { // catch(Exception e) {...}
    case e: Exception => "Some faulty error message"
  } finally {
    // execute some code no matter what:
    // for example releasing some resources, closing connections etc.
  }

  // generics
  abstract class MyList[T] {
    def head: T

    def tail: MyList[T]
  }

  // using a generic with concrete type
  val aList: List[Int] = List(1, 2, 3) // List.apply(1, 2, 3)
  val first = aList.head
  val rest = aList.tail
  val aStringList = List("hello", "Scala")
  val firstString = aStringList.head // string

  // Point #1: in Scala we usually operate with IMMUTABLE values/objects
  // Any modification to an object must return ANOTHER object
  /*
    Benefits:
    1) works miracles in multithreaded/distributed env
    2) helps making sense of the code ("reasoning about")
   */
  val reversedList = aList.reverse // returns a NEW ist

  // Point #2: Scala is closest to the OO ideal


}

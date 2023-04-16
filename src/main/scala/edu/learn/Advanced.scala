package edu.learn

import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}
//import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Advanced extends App {
  /**
    lazy evaluation
   */
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1
  // useful in infinite collections

  /**
    "pseudo-collections": Option, Try
   */

  def methodWitchCanReturnNull(): String = "hello, Scala"
  if (methodWitchCanReturnNull() == null) {
    // defensive code against null
  }
  val anOption = Option(methodWitchCanReturnNull()) // Some("hello, Scala")
  // option = "collection" which contains at most one element: Some(value) or None

  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  def methodWhichCanThrowException(): String = throw new RuntimeException
  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => "Defend against this evil exception"
  }

  val aTry = Try(methodWhichCanThrowException())
  // a try = "collection" with eiter a value if the code went well, or and exception if the code thew one

  val anotherStringProcessing = aTry match {
    case Success(validValue) => s"I have obtained a valid string: $validValue"
    case Failure(ex) => s"I have obtained an exception: $ex"
  }
  // map, flatMap, filter

  /**
   * Evaluate somtehing on another thread
   * (asynchronous programming)
   */
  val aFuture = Future { // Future.apply
    println("Loading...")
    Thread.sleep(1000)
    println("I have computed a value")
    4894
  }

  Thread.sleep(2000)

  // future is a "collection" which contains a value when it's evaluated
  // future is composable with map, flatMap and filter
  // monads

  /**
   * Implicits basics
   */

  // #1: Implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt)

  // #2: Implicit conversions
  implicit class MyRichInteger(n: Int) {
    def isEven(): Boolean = n % 2 == 0
  }
  println(23.isEven())

}

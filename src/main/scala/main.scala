package main

import aws.Invoker

import scala.scalajs.js.annotation._

import cats.effect._
import cats.syntax.all._

// https://typelevel.org/cats/
// https://typelevel.org/cats-effect/datatypes/io.html#introduction
// https://stackoverflow.com/questions/42998773/scala-js-pass-command-line-arguments-from-sbt-run

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] =
    args.headOption match {
      case Some(name) =>
        IO(println(s"Hello, $name.")).as(ExitCode.Success)
      case None =>
//        IO(System.err.println("Usage: MyApp name")).as(ExitCode(2))
//        IO(System.err.println("DONE. No args")).as(ExitCode.Success)
        println("invoke batchRegisterJobDefIfMissing")
        Invoker.batchRegisterJobDefIfMissing("ParticleBatchRegisterJobDefinitionTest").as(ExitCode.Success)
//        IO(essay).as(ExitCode.Success)
    }

  def essay: Unit = {
    val c1 =Seq ("flour", "angel", "cheeese")
    val c2 =Seq ("banana", "apple", "orange")
    val c3 =Seq ("nuts", "whippedcream", "poppyseeds")
    val combinations = for {
      i <- c1
      j <- c2
      k <- c3
    } yield (i, j, k)
    combinations foreach println
  }

  def essay2: Unit = {
    val c1 =Seq ("flour", "angel", "cheeese")
    val c2 =Seq ("banana", "apple", "orange")
    val c3 =Seq ("nuts", "whippedcream", "poppyseeds")
    val combinations = c1.flatMap(i => c2.flatMap(j => c3.map(k => (i, j))))
    combinations foreach println
  }

}




//object Main {
//
//  @JSExportTopLevel("org.company.HelloWorld")
//  def main(args: Array[String]): Unit = {
//    println("Hello beautiful world!")
//
////    Invoker.doSomething
////    Invoker.doBatch
//    Invoker.batchRegisterJobDef
//  }
//}


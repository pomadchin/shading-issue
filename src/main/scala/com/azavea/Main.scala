package com.azavea

import akka.actor._

// Example took from here: http://doc.akka.io/docs/akka/current/scala/actors.html#Recommended_Practices
object MyActor {
  case class Greeting(from: String)
  case object Goodbye
}

class MyActor extends Actor with ActorLogging {
  import MyActor._
  def receive = {
    case Greeting(greeter) => log.info(s"I was greeted by $greeter.")
    case Goodbye           => log.info("Someone said goodbye to me.")
  }
}

object Main {
  import com.azavea.MyActor._

  def main(args: Array[String]): Unit = {
    import akka.actor.ActorSystem

    // ActorSystem is a heavy object: create only one per application
    val system = ActorSystem("mySystem")
    val myActor = system.actorOf(Props[MyActor], "myactor2")

    myActor ! Greeting("gr1")
    myActor ! Greeting("gr2")
    myActor ! Greeting("gr3")
    myActor ! Goodbye

  }
}

package experiment

import scala.util.{ Try, Success, Failure }

/**
  * Created by natthapong on 4/8/2559.
  */
class ExceptionPlayground extends Experiment {
  override def experimentName: String = "Playing with try catch exceptions"
  override def experimentDesc: String = "Can use pattern matching as well"
  override def beginExperiment(): Unit = {
    try {
      println( intToDay( checkLessThanZero( 4 ) ) )
    } catch {
      case e: Exception => println( e.getMessage() )
    }

    val argTry = Try { checkLessThanZero( -5 ) }
    val recoveredArgTry = argTry.recover{
      case iae: IllegalArgumentException => 1
    }

    val mapResult = recoveredArgTry.map( intToDay )
    println( s"Recovered Arg Try $mapResult" )

    // change intToday to different value to try different result
    val doTry = Try( intToDay( 3 ) ).map( x => x.toLowerCase ).flatMap( x => Try( "today is " + x ) )
    println( doTry )

    doTry.recover {
      case iae: IllegalArgumentException => "unknown day"
    }

    val doTryResult = doTry match {
      case Success( str ) => str
      case Failure( exc ) => "Error"
    }

    println( doTryResult )

    println( "\nWith FOR COMPREHENSION" )
    val optOptStr: Option[Option[String]] = Some( Some( "a" ) )

    val unwrappedString = for {
      optStr <- optOptStr
      str <- optStr
    } yield str
    println( s"UnwrappedString = $unwrappedString" )

    println( "\ntry extracting element which contains values" )
    val seqOptStr: Seq[Option[String]] = Seq( Some("a"), Some("b"), None, Some("c") )
    val unwrappedSeq = for {
      os <- seqOptStr
      s <- os
    } yield s
    println( s"UnwrappedSeq = $unwrappedSeq" )

    println( "\nNested Try" )

    val tti = Success( Success( 5 ) )
    val unwrappedI = for {
      ti <- tti
      i <- ti
    } yield i
    println( s"unwrapped I = $unwrappedI" )

    println( "Usually we do not use some with try because option can denote as exception" )

  }

  def checkLessThanZero = ( i: Int ) => {
    if ( i < 0 ) throw new IllegalArgumentException( "Less than zero" )
    i
  }

  def intToDay( i: Int ) = i match {
    case 1 => "Mon"
    case 2 => "Tuesday"
    case 3 => "Wednesday"
    case 4 => "Thursady"
    case 5 => "Friday"
    case 6 => "Saturday"
    case 7 => "Sunday"
    case _ => throw new Exception( "Whatssss" )
  }
}

package experiment

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{
  Success,
  Failure
}
/**
  * Created by natthapong on 4/8/2559.
  */
class ConcurrencyNaja extends Experiment {
  override def experimentName: String = "Playing with Concurrency"
  override def experimentDesc: String = "Desc"
  override def beginExperiment(): Unit = {

    println( "These code has no Future" )
    println( longPlus( 1, 2 ) )
//    println( longPlus( 2, 3 ) )
//    println( longPlus( 3, 4 ) )

    println( "Playing with Future" )
    val f1 = Future( longPlus( 1, 2 ) )
    val f2 = Future( longPlus( 2, 3 ) )
    val f3 = Future( longPlus( 3, 4 ) )
    println( "Done running future" )
    f1.onSuccess {
      case i: Int => println( s"f1 result = $i" )
    }
    f2.onSuccess {
      case i: Int => println( s"f2 result = $i" )
    }
    f3.onSuccess {
      case i: Int => println( s"f3 result = $i" )
    }

    println( "Waiting for future" )
    Thread.sleep( 4000 );

    println( "\nUsing \"FOR COMPREHENSION\"" )
    val f4 = Future( longPlus( 1, 2 ) )
    val f5 = Future( longPlus( 2, 3 ) )
    val f6 = Future( longPlus( 3, 4 ) )

    val waitedResult = for {
      f4r <- f4
      f5r <- f5
      f6r <- f6
    } yield ( f4r, f5r, f6r )

    waitedResult.onSuccess {
      case res => println( res )
    }
    Thread.sleep( 4000 )

    println( "\nWith exception error" )
    val f7 = Future( longPlusEx( 1, 2 ) )
    val f8 = Future( longPlusEx( 5, 3 ) )
    val f9 = Future( longPlusEx( 3, 4 ) )
    f8 map { i => i * 10 }
    val v8Recovered = f8.recover { case _ => throw new Exception( "Woooooo" ) }

    val waitedResult2 = for {
      f7r <- f7
      f8r <- v8Recovered // handled
      f9r <- f9
    } yield ( f7r, f8r, f9r )

    waitedResult2.onComplete { // Side effect
      case Success( (a, b, c ) ) => println( s"got $a, $b, $c" )
      case Failure( e ) => println( e.toString )
    }

    Thread.sleep( 4000 )
  }

  def longPlus( x: Int, y: Int ): Int = {
    Thread.sleep( 3000 )
    x + y
  }

  def longPlusEx( x: Int, y: Int ): Int = {
    Thread.sleep( 3000 )
    if ( x > 5 ) throw new Exception( "Too much" )
    x + y
  }
}

package experiment

/**
  * Created by natthapong on 2/8/2559.
  */
class PatternMaching extends Experiment{
  override def experimentName: String = "Pattern Matching"
  override def experimentDesc: String = "Desc"
  override def beginExperiment(): Unit = {
//
//    val arg = true
//    val res = arg match {
//      case true => "cry"
//      case false => "why"
//    }
//    println( "res = " + res )
//
//    val arg2 = 11
//    val res2 = arg2 match {
//      case i if i < 0 => 0 // if i < 0 called pattern guard
//      case i => i
//    }
//    println( "res2 = " + res2 )
//
//
//    val seq = Seq( 1, 2, 3, 12 )
//    val seqRes = seq match {
//      case s@Seq(a, b, c, _*) if s.length >= 4 => {
//        a + b + c + s.last
//      }
//      case Seq(a, b, c, _*) => a + a
//      case Seq(a, b, c) => a + b - c
//      case s if s.length > 3 => "long"
////      case (str, _) => str
////      case s => "short"
//      case _ => "Bad input - Duckyducky"
//    }
//
//    println( "seqRes = " + seqRes )
//
//    class Person( val name: String, val age: Int )
//    object Person {
//      def unapply(p: Person): Option[(String,Int)] = Option(( p.name, p.age ) ) // make it suitable for pattern matching
//    }
//    object YoungPerson {
//      def unapply(p: PatternMaching): Option[(String,Int)] = Option( p.age < 18 ? ( p.name, p.age ) : Null )
//    }
//
//
//    val nev = new Person( "Nev", 12 )
//    val nevResult = nev match {
//      case YoungPerson( n, a ) => "Hello boy"
//      case Person( n, a ) => "it's " + n
//    }
//    println( "nevResult = " + nevResult )
  }

  def matchTuple( t: (String, Boolean ) ) = t match {
    case ( x, boo ) if boo => x + "duckky"
    case ( x, y ) if y => x
    case _ => "Bad tuple - Duckyducky"
  }
}

package experiment

/**
  * Created by natthapong on 2/8/2559.
  */
class ForComprehension extends Experiment {
  override def experimentName: String = "For comprehension"
  override def experimentDesc: String = "Desc"
  override def beginExperiment(): Unit = {
    val seqSeq = Seq( Seq(1,2), Seq(3,4) )

    val validI1 = for {
      seq <- seqSeq
      i <- seq
    } yield i + 1

    println( "validI1 = " + validI1 )

    val seqOpt: Seq[Option[Int]] = Seq( Some(1), None, Some(4), None, Some(-1), Some( 7 ) )
    val validI2 = for {
      opt <- seqOpt
      i <- opt
    } yield i

    println( "validI2 = " + validI2 )

    val validI3 = for {
      Some(i) <- seqOpt
    } yield i

    println( "validI3 = " + validI3 )

    class Person( val name: String )
    object PersonA {
      def unapply(p: Person): Option[String] = Some( p.name )
    }

    val seqOptPerson: Seq[Option[Person]] = Seq( Some( new Person("a")), Some( new Person("b") ), Some( new Person("aaaaa" ) ) )
    val names = for {
      Some( PersonA( name ) ) <-  seqOptPerson if name.length > 3
    } yield name

    println( "names = " + names )
  }
}

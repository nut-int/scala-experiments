package experiment

/**
  * Created by natthapong on 4/8/2559.
  */
class OptionExperiment extends Experiment {
  override def experimentName: String = "Option Testing"
  override def experimentDesc: String = "Playing with Options, more convenion ways to deal with Nil pointer\n" +
    "Like optional binding in Swift"

  override def beginExperiment(): Unit =  {
    case class User2( name: String, gender: Option[String] )
    val john = User2( "John", Some( "Male" ) )
    val cthulu = User2( "Chutlu", None )

    // if gender is not null, apply toUpperCase, or return "Unspecified"
    def getGenderUpper( u: User2 ) = u.gender.map { _.toUpperCase }.getOrElse( None )

    println( getGenderUpper( john ) )
    println( getGenderUpper( cthulu ) )
  }
}

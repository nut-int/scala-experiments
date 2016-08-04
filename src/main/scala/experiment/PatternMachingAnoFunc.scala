package experiment

/**
  * Created by natthapong on 2/8/2559.
  */
class PatternMachingAnoFunc extends Experiment {
  override def experimentName: String = "Pattern Matching Anonymouse Function"
  override def experimentDesc: String = "DEsc"

  override def beginExperiment(): Unit = {
    val map = Map( 1->true, 2->false )

    val mapResult1 = map.map{ case (k,v) => (k,!v) }
    val mapResult2 = map.map{ case (_,v) => !v }

    println( "mapResult1 = " + mapResult1 )
    println( "mapResult2 = " + mapResult2 )
  }
}

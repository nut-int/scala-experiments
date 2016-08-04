package experiment

/**
  * Created by natthapong on 2/8/2559.
  */
class Loops extends Experiment{
  override def experimentName: String = "Loops"
  override def experimentDesc: String = "Playing with loops"

  override def beginExperiment(): Unit = {
    for ( i <- 1 to 10 ) {
      println( i )
    }
  }
}

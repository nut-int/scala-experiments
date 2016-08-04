package experiment

/**
  * Created by natthapong on 2/8/2559.
  */
class Coloring extends Experiment {
  override def experimentName : String = "Console Text Coloring"
  override def experimentDesc : String = "Set color to console text"

  override def beginExperiment(): Unit = {
    println( Console.RED + "Begin Red Color " )
    println( Console.BLUE + "Begin Blue Color " );
    println( Console.RESET + "Reset" )
  }
}

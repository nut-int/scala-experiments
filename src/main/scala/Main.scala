
import experiment._
import scala.collection.mutable.{ MutableList }

object Main {
  def main( args: Array[String] ) {

    var experiments: MutableList[Experiment] = MutableList()

//    experiments += new PolymorphicMethods()
//    experiments += new ImplicitConversions()
//    experiments += new ImplicitParameters()
//    experiments += new CaseClasses()
//    experiments += new XmlProcessing()
//    experiments += new Coloring()
//    experiments += new Loops()
    // experiments += new Sequences()
//    experiments += new PatternMaching()
//    experiments += new ForComprehension()
//    experiments += new PatternMachingAnoFunc()
//    experiments += new Collections()
//    experiments += new OptionExperiment()
//    experiments += new ExceptionPlayground()
    experiments += new ConcurrencyNaja()
    experiments += new Prime()


    class Func2( name: String ) extends Var( name ) {}
    println( Console.BLUE + "====Welcome to experiment lab====" + Console.RESET )

    for ( experiment <- experiments ) {
      println( Console.RED + "\n\n====" + experiment.experimentName + "====" + Console.RESET )
      println( experiment.experimentDesc )
      experiment.beginExperiment()

    }
  }
}
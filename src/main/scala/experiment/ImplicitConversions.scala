
package experiment

// You need to import these below in order to use implicit conversion (Risky feature)
import scala.language.implicitConversions
import ComplexImplicits._ // Need to import this object even this object is written in the same file

object ComplexImplicits {
    implicit def doublexxx2complex( value: Double ) =
        new Complex( value, 0.0  )
    implicit def tuple2complex( value: Tuple2[Double,Double] ) =
        new Complex( value._1, value._2 )
}

class Complex( val real: Double, val img: Double ) {
    def +( that: Complex ) : Complex = new Complex( this.real + that.real, this.img + that.img )
    def -( that: Complex ) : Complex = new Complex( this.real - that.real, this.img - that.img )
    def unary_~ = Math.sqrt( real * real + img * img )
    override def toString = real + "+" + img + "i"
}

class ImplicitConversions extends Experiment {

    override def experimentName = "Implicit Conversions"
    override def experimentDesc = "Writing implicit conversion methods and scala will automatic convert object to compatible types in the calculation implicitly"
    override def beginExperiment() : Unit = {

        var a: Complex = new Complex(4.0, 5.0)
        var b: Complex = (2.0, 3.0)
        println( a + 1.0 )
        println( 3.0 + b )
    }
}

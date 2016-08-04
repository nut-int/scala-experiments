package experiment

class PolymorphicMethods extends Experiment {

    def dup[T]( x: T, n: Int ): List[T] = 
        if ( n == 0 )
            Nil
        else
            x :: dup( x, n - 1 )

    override def experimentName = "Polymorphic Methods"
    override def experimentDesc = "Template method that automatic infer type without need to parameterize type during call"
    override def beginExperiment() : Unit = {
        println( dup[Int]( 3, 4 ) )
        println( dup( "three", 3 ) ) // not specified string as type
    }

}

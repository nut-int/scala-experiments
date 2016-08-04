package experiment

// sealed class cannot be inherited directly, however it's child subclasses can be subclassed
sealed class Term
case class Var( name: String ) extends Term
case class Func( arg: String, body: Term ) extends Term
case class App( func: Term, v: Term ) extends Term

class CaseClasses extends Experiment {
    override def experimentName = "Case Classes"
    override def experimentDesc = "Desc"
    override def beginExperiment(): Unit = {

        val f = Func( "x", Func( "y", App( Var("x"), Var("y") ) ) )
        println( "function result = " + f )


        println( "\nconstructor's parameter are treated as public value" )
        println( "Like Var(\"x\").name =>  x.name = " + Var("x").name )

        println( "\nMethod equals will be generated as well" )
        println( "Var(\"x\") == Var(\"x\") = " + ( Var("x") == Var("x") ) )

        println( "\nCase classes support pattern maching" )
        printTerm( f )
        println()
    }

    def printTerm( term: Term ) {
        term match {
            case Var( n ) =>
                print( n )
            case Func( x, b ) =>
                print( "^" + x + "." )
                printTerm( b )
            case App( f, v ) =>
                print( "(" )
                printTerm( f )
                print( " " )
                printTerm( v )
                print( ")" )
            case _ =>
        }
    }
}

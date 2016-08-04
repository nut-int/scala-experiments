package experiment
/**
  * Created by natthapong on 2/8/2559.
  */
class Collections extends Experiment{
  override def experimentName: String = "Collections"
  override def experimentDesc: String = "Desc"
  override def beginExperiment(): Unit = {
    println( "Tuples dont have map functions" )

    println( "Seq is mappable" )
    val seq = Seq( "a", "b", "aa", "bb" )
    val set = Set( "a", "b", "c" )
    val map = Map( "a"->1, "b"->2 )

    println( "seq.flatMap{ ... } " + seq.flatMap{ s => Seq( s.toUpperCase(), s.toLowerCase())})
    println( "seq.map{ .. } = " + seq.map{ _.toUpperCase() } )
    println( "seq.take(1) = " + seq.take( 1 ) )
    println( "seq.takeRight(2) = " + seq.takeRight( 2 ) )
    println( "seq :+ \"d\" = " + ( seq :+ "d" ) )
    println( "seq.find( .. ) = " + seq.find { s => s == "a" } )
    println( "seq.foldLeft = " + seq.foldLeft(0) { ( accum, element ) => accum + element.length })

    println( "map.mapValues{ .. } = " + map.mapValues{ v => v + 11 } )

    val mapMap = Map( "a"-> Map( "c"-> true, "c"-> false ) )
    println( "mapMap.flatten = error (think about flatten JSON objects)" )

    println( "seq.collect{ .. } = ", seq.collect {
      case "a" => 3
      case "d" => 5
    } + "\n\t not error like seq.map because it will ignore missing cases" )
    println( "map ++ map => map" )


    println( "\nList Extra" )
    val list1 = List( 1, 2, 3, 4 )
    val list2 = 1 :: 2 :: 3 :: 4 :: Nil

    println( "List with pattern matching" )
    println( s"Try pattern matching ${list1 match {
      case head :: tail => ( head, tail )
      case List( head, tail @ _ * ) => ( head, tail )
      case a :: b :: _ => ( a, b )
      case _ => ()
    } }")
  }
}

package experiment

/**
  * Created by natthapong on 2/8/2559.
  */
class Sequences extends Experiment{
  override def experimentName: String = "Sequences"
  override def experimentDesc: String = "Different types of sequences"
  override def beginExperiment(): Unit = {

    println( "\nSeq")
    println( "Ordered and non-unique elements" )
    val seq :Seq[Int] = Vector( 1, 2, 3, 4 )
    val seq2 = seq.map { x => x + 1 }
    println( seq )
    println( seq2 )

    println( "\nSet" )
    println( "Unordered and unique members" )
    println( "single element type" )

    val set1 = Set( "a", "b", "a", "c" )
    val set2 = Set( "b", "z", "e" )
    println( "set = " + set1 )
    println( "set2 = " + set2 )
    println( "set1 Union set2 = " + set1.union( set2 ) )
    println( "set1(\"a\") = " + set1("a") )

    println( "\nTuples" )
    println( "Container that can contains multiple types of elements" )
    println( "However tuple size are fixed" )
    val tup1 = Tuple2( "a", "b" )
    val tupn = ( "a", 1, true, 'a', "duckyducky" )
    println( "tup1 = " + tup1 )
    println( "tupn = " + tupn )
    println( "tupn._1 = " + tupn._4 )
    println( "Tuples index starts at 1" )


    println( "\nMap" )
    println( "Unique keys with single value" )
    val map = Map( ("a",1), ("b", 2) )
    val map2 = Map( 'a'->true, 'b'->false )
    println( "map(\"a\") = " + map( "a" ) )
    println( "map(\"b\") = " + map( "b" ) )
    println( "map.get(\"a\") = " + map.get( "a" ) )
    println( "map.keys " + map.keys )
    println( "map.values " + map.values )
//    println( "map.map( fnc ) " + map.map({ aPair => ( aPair._1, aPair * 10 ) }).keys )

  }
}

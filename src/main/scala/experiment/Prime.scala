package experiment

class Prime extends Experiment {
  val primes = Stream.cons(2, Stream.from(3, 2) filter { _.isPrime })

  implicit class PrimeNumber(start: Int) {
    def isPrime: Boolean = (start > 1) && (primes takeWhile { _ <= Math.sqrt(start) } forall { start % _ != 0 })

    def primeFactor: List[Int] = {
      def _primeFactor(n: Int, ps: Stream[Int], result: List[Int] = Nil): List[Int] = {
        if (n.isPrime) (n :: result).reverse
        else if (n % ps.head == 0) _primeFactor(n/ps.head, ps, ps.head :: result)
        else _primeFactor(n, ps.tail, result)
      }
      _primeFactor(start, primes)
    }

    def primeFactorMultiplicity: Map[Int, Int] = start.primeFactor.groupBy(x => x).mapValues(x => x.size)

    def toTient: Int = start.primeFactorMultiplicity.foldLeft(1) { (r,f) =>
      f match { case (p, m) => r*(p-1)*math.pow(p, m-1).toInt }
    }

    def goldBach: (Int, Int) = {
      primes.takeWhile(x => x<start).find(p => (start-p).isPrime) match {
        case None => (0, 0)
        case Some(p1) => (p1, start-p1)
      }
    }
  }

  def listprimeInRange(range: Range): List[Int] = range.filter( x => x.isPrime).toList

  def printGoldbachList(range: Range): Unit = {
    range.filter(x => x%2 == 0).map( x => x.goldBach).foreach(x => println((x._1+x._2)+" = "+x._1+" + "+x._2))
  }

  def printGoldbachListLimited(range: Range, minimum: Int): List[(Int, Int)] = {
    range.filter(x => x%2 == 0).map( x => x.goldBach).filter(x => x._1>minimum && x._2>minimum).toList
  }

  override def experimentName: String = "implicit class PrimeNumber"

  override def experimentDesc: String = "555"

  override def beginExperiment(): Unit = {
    println(3.isPrime)
  }
}
package experiment

class WaterPouring (capacity: Vector[Int]) extends Experiment {
  type State = Vector[Int]
  val init = capacity map (x => 0)

  trait Move {
    def change (state: State): State
  }

  case class Empty (glass: Int) extends Move {
    override def change(state: State): State = state updated (glass, 0)
  }

  case class Fill (glass: Int) extends Move {
    override def change(state: State): State = state updated (glass, capacity(glass))
  }

  case class Pour (from: Int, to: Int) extends Move {
    override def change(state: State): State = {
      val amount = state(from) min (capacity(to) - state(to))
      state updated (from, state(from) - amount) updated (to, state(to) + amount)
    }
  }

  val glasses = capacity.indices
  val moves =
    (for (g <- glasses) yield Empty(g)) ++
      (for (g <- glasses) yield Fill(g)) ++
      (for (from <- glasses; to <- glasses if from != to) yield Pour(from, to))

  class Path (history: List[Move]) {
    def endState: State = (history foldRight init) (_ change _)
    private def trackState (xs: List[Move]): State = xs match {
      case Nil => init
      case move :: xs1 => move change trackState(xs1)
    }

    def extend (move: Move) = new Path(move :: history)
    override def toString = (history.reverse mkString(" ")) + "--> " + endState
  }

  def initPath = new Path(Nil)
  def from (paths: Set[Path], explore: Set[State]): Stream[Set[Path]] = {
    if (paths.isEmpty) Stream.empty
    else {
      val more = for {
        path <- paths
        next <- moves map path.extend
        if !(explore contains next.endState)
      } yield next
      paths #:: from(more, explore ++ (more map (_.endState)))
    }
  }

  val pathSets = from(Set(initPath), Set(init))

  def solution (target: Int): Stream[Path] = {
    for {
      pathSet <- pathSets
      path <- pathSet
      if path.endState contains target
    } yield path
  }

  override def experimentName: String = "implicit class PrimeNumber"

  override def experimentDesc: String = "555"

  override def beginExperiment(): Unit = {
    val problem = new WaterPouring(Vector(4,9))

    println(problem.solution(6))
  }
}
object Backtracking {
  implicit class Backtracking (arr: List[List[Int]]) {
    def updateList (row: Int, col: Int, value: Int): List[List[Int]] = arr.updated(row, arr.apply(row).updated(col, value))

    def countArea (find: Int = -1): Int = arr.flatMap(x => x.filter( y => y == find)).length
  }
  
  def backtracking(arr: List[List[Int]], row: Int = 0, col: Int = 0, result: List[(Int, Int)] = List(), currentCount: Int = 0): List[(Int, Int)] = {
    if (row < arr.length) {
      if (col < arr.head.length) {
        if (arr(row)(col) != -1) {
          val area = _backtracking(arr, row, col, arr(row)(col))
          backtracking(area, row, col+1, List((arr(row)(col), area.countArea()-currentCount)) ::: result, area.countArea())
        } else backtracking(arr, row, col+1, result, currentCount)
      } else backtracking(arr, row+1, 0, result, currentCount)
    } else result.sortBy(_._1)
  }

  private def _backtracking (arr: List[List[Int]], row: Int, col: Int, value: Int): List[List[Int]] = {
    if (arr(row)(col) == value) {
//      println(row, col)
      val tempArr = arr.updateList(row, col, -1)
      (row, col) match {
        case (0, 0) =>
          val a = _backtracking(tempArr, row+1, col, value)
          _backtracking(a, row, col+1, value)
        case (_, 0) =>
          if (row == arr.length-1) {
            val a =  _backtracking(tempArr, row-1, col, value)
            _backtracking(a, row, col+1, value)
          } else {
            val a =  _backtracking(tempArr, row-1, col, value)
            val b =  _backtracking(a, row, col+1, value)
            _backtracking(b, row+1, col, value)
          }
        case (0, _) =>
          if (col == arr.head.length-1) {
            val a =  _backtracking(tempArr, row, col-1, value)
            _backtracking(a, row+1, col, value)
          } else {
            val a =  _backtracking(tempArr, row, col-1, value)
            val b =  _backtracking(a, row+1, col, value)
            _backtracking(b, row, col+1, value)
          }
        case (i, j) =>
          if (i == arr.length-1 && j == arr.head.length-1) {
            val a =  _backtracking(tempArr, row-1, col, value)
            _backtracking(a, row, col-1, value)
          } else if (i == arr.length-1){
            val a =  _backtracking(tempArr, row-1, col, value)
            val b =  _backtracking(a, row, col-1, value)
            _backtracking(b, row, col+1, value)
          } else if ( j == arr.head.length-1) {
            val a =  _backtracking(tempArr, row-1, col, value)
            val b =  _backtracking(a, row, col-1, value)
            _backtracking(b, row+1, col, value)
          } else {
            val a =  _backtracking(tempArr, row+1, col, value)
            val b =  _backtracking(a, row-1, col, value)
            val c =  _backtracking(b, row, col-1, value)
            _backtracking(c, row, col+1, value)
          }
      }
    } else arr
  }

  def main(args: Array[String]): Unit = {
//    val arr = List(
//      List(0,1,0,1),
//      List(1,1,0,1),
//      List(0,0,1,0)
//    )

    val arr = List(
      List(0, 0, 0, 2, 2),
      List(1, 1, 7, 2, 2),
      List(2, 2, 7, 2, 1),
      List(2, 1, 7, 4, 4),
      List(2, 7, 7, 4, 4),
      List(4, 6, 6, 0, 4),
      List(4, 4, 6, 4, 4),
      List(4, 4, 6, 4, 4)
    )

    println(backtracking(arr))
  }
}

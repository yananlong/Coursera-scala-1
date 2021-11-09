package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
      if(c < 0 || r < 0 || r < c) {
        0
      } else {
        if(c == 0 || r == 0) 1
        else pascal(c, r - 1) + pascal(c - 1, r - 1)
      }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
      def _balance(chars: List[Char], ind: Int): Boolean = {
          if(ind < 0) false
          if(chars.isEmpty) {
              ind == 0
          } else if(chars.head == '(') {
              _balance(chars.tail, ind + 1) 
          } else if(chars.head == ')') {
              _balance(chars.tail, ind - 1) 
          } else {
            _balance(chars.tail, ind)
          }
      }
      _balance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.exists(_ <= 0)) {
      throw new IllegalArgumentException()
    } else if(money < 0 || coins.isEmpty) {
      0
    } else if(money == 0) {
      1
    } else {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
}

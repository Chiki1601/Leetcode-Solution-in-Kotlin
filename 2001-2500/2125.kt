class Solution {
    
  fun numberOfBeams(bank: Array<String>) =
    bank.map { it.count { it == '1' } }
      .filter { it > 0 }
      .windowed(2)
      .map { (a, b) -> a * b }
      .sum() ?: 0
}

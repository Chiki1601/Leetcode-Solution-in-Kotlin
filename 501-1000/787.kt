class Solution {
   
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
      val costs = IntArray(n) { Int.MAX_VALUE / 2 }
      costs[src] = 0
      repeat(k + 1) {
        val prev = costs.clone()
        for ((f, t, c) in flights) 
            costs[t] = min(costs[t], prev[f] + c)
      }
      return costs[dst].takeIf { it < Int.MAX_VALUE / 2 } ?: -1
    }
}

class Solution {
  fun minScore(n: Int, roads: Array<IntArray>): Int {
    val g = List(n + 1) {mutableListOf<Pair<Int, Int>>()}
    for ((a, b, c) in roads) {
      g[a].add(Pair(b, c))
      g[b].add(Pair(a, c))
    }
    val reachable = BooleanArray(n + 1)
    fun dfs(node: Int) {
      if (reachable[node]) return
      reachable[node] = true
      for ((next, _) in g[node])
        dfs(next)
    }
    dfs(1)
    var res = Int.MAX_VALUE
    for (i in 1..n)
      if (reachable[i]) for ((_, cost) in g[i]) res = minOf(res, cost)
    return res
  }

}

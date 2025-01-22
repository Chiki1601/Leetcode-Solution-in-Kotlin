class Solution {

    companion object  {
        private val directions = listOf(Pair(0, -1), Pair(0, 1), Pair(-1, 0), Pair(1, 0))
    }

    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val m = isWater.size
        val n = isWater[m - 1].size

        val deque = ArrayDeque<Pair<Int, Int>>()
        val ans = Array<IntArray>(m) { IntArray(n) { -1 } }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (isWater[i][j] == 1) {
                    deque.add(Pair(i, j))
                    ans[i][j] = 0
                }
            }
        }

        var count = 1
        while (deque.isNotEmpty()) {
            repeat(deque.size) {
                val (i, j) = deque.removeFirst()
                for ((x, y) in directions)  {
                    val I = i + x
                    val J = y + j
                    if (I < 0 || J < 0 || I >= m || J >= n || ans[I][J] != -1) continue
                    ans[I][J] = count
                    deque.addLast(Pair(I, J))
                }
            }
            count++
        }

        return ans
    }
}

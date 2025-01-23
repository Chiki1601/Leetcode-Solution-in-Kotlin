class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid.first().size
        var ans = 0
        for (i in 0 until n) {
            var serverCount = 0
            for (j in 0 until m) {
                if (grid[i][j] > 0) {
                    serverCount++
                }
            }
            if (serverCount > 1) {
                for (j in 0 until m) {
                    if (grid[i][j] == 1) {
                        grid[i][j] = 2
                        ans++
                    }
                }
            }
        }
        for (j in 0 until m) {
            var serverCount = 0
            for (i in 0 until n) {
                if (grid[i][j] > 0) {
                    serverCount++
                }
            }
            if (serverCount > 1) {
                for (i in 0 until n) {
                    if (grid[i][j] == 1) {
                        ans++
                    }
                }
            }
        }
        return ans
    }
}

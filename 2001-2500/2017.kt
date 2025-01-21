class Solution {
    fun gridGame(grid: Array<IntArray>): Long {
        val len = grid[0].size
        val right1 = LongArray(len)    
        val left2 = LongArray(len)
        var rez = Long.MAX_VALUE
        for (i in 1 until len) {
            left2[i] = left2[i-1] + grid[1][i-1]
            right1[len-i-1] = right1[len-i] + grid[0][len-i]
        }
        for (i in 0 until len) {
            val tek_min = Math.max(right1[i],left2[i])
            rez = Math.min(rez,tek_min)
        }
        return rez
    }
}

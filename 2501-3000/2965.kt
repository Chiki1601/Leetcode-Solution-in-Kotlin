class Solution {
    fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
        val n = grid.size

        val map = mutableMapOf<Int,Int>()

        for (i in 0 until n){
            for (j in 0 until n){
                val num = grid[i][j]
                map[num] = map.getOrDefault(num, 0) + 1
            }
        }
        val ans = IntArray(2)
        for ((key, value) in map){
            if (value == 2){
                ans[0] = key
            }
        }

        for (i in 1 until n * n + 1){
            if (i !in map){
                ans[1] = i
            }
        }
        return ans
    }
}

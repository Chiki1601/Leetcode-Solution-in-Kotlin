// 9ms
class Solution {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size

        val table = Array(m * n + 1) { IntArray(2) }

        val rows = IntArray(m)
        val cols = IntArray(n)

        for (i in 0 ..< m) {
            for (j in 0 ..< n) {
                table[mat[i][j]] = intArrayOf(i, j)
            }
        }

        var i = 0
        for (a in arr) {
            if (++rows[table[a][0]] == n || ++cols[table[a][1]] == m) return i
            i++
        }
        return i
    }
}

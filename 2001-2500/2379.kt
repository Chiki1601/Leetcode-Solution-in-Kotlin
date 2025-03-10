class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var blackCount = 0
        var ans = Int.MAX_VALUE

        for (i in blocks.indices) {
            if (i >= k && blocks[i - k] == 'B') {
                blackCount--
            }
            if (blocks[i] == 'B') {
                blackCount++
            }
            ans = minOf(ans, k - blackCount)
        }

        return ans
    }
}

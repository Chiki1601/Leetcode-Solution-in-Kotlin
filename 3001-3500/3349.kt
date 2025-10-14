class Solution {
    fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
        var inc = 1
        var prevInc = 0
        var maxLen = 0
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) inc++
            else {
                prevInc = inc
                inc = 1
            }
            maxLen = maxOf(maxLen, maxOf(inc shr 1, minOf(prevInc, inc)))
            if (maxLen >= k) return true
        }
        return false
    }
}

class Solution {
    fun longestSubsequence(nums: IntArray): Int {
        var xorSum = 0
        var allZero = true
        for (num in nums) {
            xorSum = xorSum xor num
            if (num != 0) allZero = false
        }
        if (allZero) return 0
        return if (xorSum != 0) nums.size else nums.size - 1
    }
}

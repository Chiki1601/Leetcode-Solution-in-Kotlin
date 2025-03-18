class Solution {
    fun longestNiceSubarray(nums: IntArray): Int {
        val n = nums.size
        var i = 0
        var j = 0
        var max = 1
        var sum = 0
        while (j < n) {
            val num = nums[j]
            if (sum and num == 0) {
                sum = sum or num
                max = max(max, ++j - i)
            } else sum = sum xor nums[i++]
        }
        return max
    }
}

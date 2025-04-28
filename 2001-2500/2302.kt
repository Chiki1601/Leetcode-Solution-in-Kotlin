class Solution {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        var ans = 0L
        var sum = 0L
        var i = 0
        var j = 0

        fun score(): Long = sum * (j - i + 1)

        while (j < nums.size) {
            sum += nums[j]

            while (i <= j && score() >= k) {
                sum -= nums[i]
                i++
            }
            ans += j - i + 1
            j++
        }
        return ans
    }
}

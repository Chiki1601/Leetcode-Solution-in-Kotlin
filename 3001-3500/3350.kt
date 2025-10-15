class Solution {
    fun maxIncreasingSubarrays(nums: List<Int>): Int {
        val n = nums.size
        var up = 1
        var preUp = 0
        var res = 0
        for (i in 1 until n) {
            if (nums[i] > nums[i-1]) up++
            else {
                preUp = up
                up = 1
            }
            val half = up shr 1
            val m = minOf(preUp, up)
            val candidate = maxOf(half, m)
            if (candidate > res) res = candidate
        }
        return res
    }
}

class Solution {
    fun maxAscendingSum(nums: IntArray): Int {
        var res = Int.MIN_VALUE
        var sum = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                sum += nums[i]
            } else {
                res = Math.max(res, sum)
                sum = nums[i]
            }
        }
        res = Math.max(res, sum)

        return res
    }
}

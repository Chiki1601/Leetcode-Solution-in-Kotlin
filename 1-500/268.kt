class Solution {
    fun missingNumber(nums: IntArray): Int {
        val currentSum = nums.sum()
        val n = nums.size
        val intendedSum = ((n+1)*n)/2
        return intendedSum - currentSum
    }
}

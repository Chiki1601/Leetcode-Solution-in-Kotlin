class Solution {
    fun waysToSplitArray(nums: IntArray): Int = nums
    .map(Int::toLong)
    .scan(0, Long::plus)
    .drop(1)
    .let { splits ->
        (0 until nums.lastIndex).count { splits[it] >= splits.last() - splits[it] }
    }
}

class Solution {
    fun maximumCount(nums: IntArray): Int {
        val negCount = binarySearch(nums, 0)
        val posCount = nums.size - binarySearch(nums, 1)
        return if (negCount > posCount) negCount else posCount
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var result = nums.size

        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] < target) {
                left = mid + 1
            } else {
                result = mid
                right = mid - 1
            }
        }

        return result
    }
}

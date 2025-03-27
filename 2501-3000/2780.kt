class Solution {
    fun minimumIndex(nums: List<Int>): Int {
        fun findDominantElement(arr: List<Int>): Int? {
            var candidate: Int? = null
            var count = 0

            // Boyer-Moore Majority Vote algorithm
            for (num in arr) {
                if (count == 0) {
                    candidate = num
                    count = 1
                } else if (num == candidate) {
                    count++
                } else {
                    count--
                }
            }

            val totalCount = arr.count { it == candidate }
            return if (totalCount > arr.size / 2) candidate else null
        }

        val dominant = findDominantElement(nums) ?: return -1

        var leftCount = 0
        val totalDominantCount = nums.count { it == dominant }

        for (i in 0 until nums.size - 1) {
            if (nums[i] == dominant) {
                leftCount++
            }

            val leftSubarrayCount = leftCount
            val rightSubarrayCount = totalDominantCount - leftCount

            if (leftSubarrayCount > (i + 1) / 2 &&
                rightSubarrayCount > (nums.size - i - 1) / 2) {
                return i
            }
        }

        return -1
    }
}

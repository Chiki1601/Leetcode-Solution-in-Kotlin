class Solution {
    fun minimumDifference(nums: IntArray): Long {
        val n = nums.size / 3

        val minSum = LongArray(nums.size)
        fun populateMinSum() {
            val queue = PriorityQueue<Int>({ a, b -> b - a })
            var sum = 0L
            for (i in nums.indices) {
                sum += nums[i]
                queue.add(nums[i])

                if (i >= n) {
                    val maxValue = queue.poll()
                    sum -= maxValue
                }
                minSum[i] = sum
            }
        }
        populateMinSum()

        val maxSum = LongArray(nums.size)
        fun populateMaxSum() {
            val queue = PriorityQueue<Int>({ a, b -> a - b })
            var sum = 0L
            for (i in nums.size - 1 downTo 0) {
                sum += nums[i]
                queue.add(nums[i])

                if (i < 2 * n) {
                    val minValue = queue.poll()
                    sum -= minValue
                }

                maxSum[i] = sum
            }
        }
        populateMaxSum()

        var ans = Long.MAX_VALUE
        for (i in (n-1)..<2 * n) {
            ans = min(ans, minSum[i] - maxSum[i + 1])
        }
        return ans
    }
}

class Solution {
    private fun sumOfDigits(n: Int): Int {
        var x = n
        var sum = 0
        while (x > 0) {
            sum += x % 10
            x /= 10
        }
        return sum
    }

    fun maximumSum(nums: IntArray): Int {
        val sumToValues = mutableMapOf<Int, MutableList<Int>>()
        for (n in nums) {
            val sum = sumOfDigits(n)
            sumToValues[sum]?.let {
                if (it.size == 1) {
                    it.add(n)
                } else {
                    it[0] = max(it[0], n)
                }
                
                if (it[0] > it[1]) {
                    val t = it[0]
                    it[0] = it[1]
                    it[1] = t
                }
            } ?: run {
                sumToValues[sum] = mutableListOf(n)
            }
        }

        var ans = -1
        for ((_, v) in sumToValues) {
            if (v.size == 2) {
                ans = max(ans, v[0] + v[1])
            }
        }
        return ans
    }
}

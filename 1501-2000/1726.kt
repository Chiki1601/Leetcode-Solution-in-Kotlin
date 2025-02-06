class Solution {
    fun tupleSameProduct(nums: IntArray): Int {
        val counts = HashMap<Int, Int>()
        for (num1 in nums) {
            for (num2 in nums) {
                if (num1 != num2) {
                    val product = num1 * num2
                    counts[product] = (counts[product] ?: 0) + 1
                }
            }
        }
        return counts.values.map { it / 2 }.sumOf { it * (it - 1) * 4 }
    }
}

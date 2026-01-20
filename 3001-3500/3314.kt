class Solution {
    fun minBitwiseArray(nums: List<Int>): IntArray {
        val result = IntArray(nums.size)
        for (i in nums.indices) {
            val v = nums[i]
            result[i] = if (v == 2) -1 else calc(v)
        }
        return result
    }

    private fun calc(value: Int): Int {
        var bitsOnRight = 0
        var v = value
        while ((v and 1) != 0) {
            bitsOnRight++
            v = v ushr 1
        }
        if (bitsOnRight == 1) return value - 1
        val woBitsOnRight = value xor ((1 shl bitsOnRight) - 1)
        return woBitsOnRight or ((1 shl (bitsOnRight - 1)) - 1)
    }
}

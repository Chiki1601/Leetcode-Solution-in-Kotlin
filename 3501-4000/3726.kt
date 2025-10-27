class Solution {
    fun removeZeros(n: Long): Long {
        var num = n
        var res = 0L
        var mult = 1L
        while (num > 0) {
            val rem = num % 10
            if (rem != 0L) {
                res += rem * mult
                mult *= 10
            }
            num /= 10
        }
        return res
    }
}

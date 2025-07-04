class Solution {
    fun kthCharacter(k: Long, operations: IntArray): Char {
        fun trace(x: Long): Int {
            if (x == 1L) return 0
            var op = 0
            while (x > 1L shl op) op++
            op--
            return (trace(x - (1L shl op)) + operations[op]) % 26
        }

        return 'a' + trace(k)
    }
}

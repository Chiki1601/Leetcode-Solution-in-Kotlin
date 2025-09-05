class Solution {
    fun makeTheIntegerZero(num1: Int, num2: Int): Int {
    for (t in 0..60) {
        val s = num1.toLong() - t.toLong() * num2.toLong()
        if (s < 0) continue
        if (s < t.toLong()) continue
        val ones = java.lang.Long.bitCount(s)
        if (ones <= t) return t
    }
    return -1
}
}

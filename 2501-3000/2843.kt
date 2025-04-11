class Solution {
    private fun String.sumOfDigits() = sumOf { it.code - '0'.code }

    private fun Int.isSymmetric(): Boolean {
        val s = toString()
        val n = s.length
        return n % 2 == 0 && s.substring(0..<(n / 2)).sumOfDigits() == s.substring((n / 2)..<n).sumOfDigits()
    }

    fun countSymmetricIntegers(low: Int, high: Int): Int {
        return (low..high).count { it.isSymmetric() }
    }
}

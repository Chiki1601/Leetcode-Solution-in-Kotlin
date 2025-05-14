class Solution {
    private val mod = 1_000_000_007L
    private var m = Array(26) { LongArray(26) }
    fun lengthAfterTransformations(s: String, t: Int, nums: List<Int>): Int {
        val freq = LongArray(26)
        for (ch in s) freq[ch - 'a']++
        
        for (i in 0 until 26) {
            val num = nums[i]
            for (j in 1..num) {
                m[i][(i + j) % 26] = 1
            }
        }

        val mt = matrixPower(t)
        val rowSum = LongArray(26)
        for (i in 0 until 26) {
            for (j in 0 until 26) {
                rowSum[i] = (rowSum[i] + mt[i][j])// % mod
            }
        }

        var total = 0L
        for (i in 0 until 26) {
            total += freq[i] * rowSum[i] // ) % mod) % mod
        }

        return (total % mod).toInt()
    }

    private fun matrixPower( power: Int): Array<LongArray> {
        var ans = Array(26) { LongArray(26) }
        for (i in 0 until 26) {
            ans[i][i] = 1
        }

        var p = power
        while (p > 0) {
            if (p and 1 == 1) ans = multiply(ans, m)
            p = p shr 1
            if (p!=0) m = multiply(m, m)
        }
        return ans
    }

    private fun multiply(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
        val c = Array(26) { LongArray(26) }
        for (i in 0 until 26) {
            for (k in 0 until 26) {
                if (a[i][k] != 0L) {
                    val A = a[i][k]
                    for (j in 0 until 26) {
                        c[i][j] = (c[i][j] + A * b[k][j]) % mod
                    }
                }
            }
        }
        return c
    }
}

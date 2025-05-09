class Solution {
    val MOD = 1_000_000_007L
    val factorial = LongArray(101) { 1L }
    val invFactorial = LongArray(101) { 1L }

    fun countBalancedPermutations(numStr: String): Int {
        val n = numStr.length
        val freq = IntArray(10) { 0 }
        var targetSum = 0
        for (c in numStr) {
            freq[c - '0']++
            targetSum += c - '0'
        }

        if (targetSum % 2 == 1) return 0
        targetSum /= 2

        val targetLen = n / 2
        var ways = (factorial[targetLen] * factorial[n - targetLen]) % MOD

        val dp = Array(10) { Array(targetLen + 1) { LongArray(targetSum + 1) { -1L } } }

        fun go(i: Int, len1: Int, sum1: Int): Long {
            if (i >= 10) {
                if (len1 == targetLen && sum1 == targetSum) return ways
                return 0
            }
            if (len1 > targetLen || sum1 > targetSum) return 0
            if (dp[i][len1][sum1] >= 0) return dp[i][len1][sum1]

            var ans = 0L
            for (take in 0..freq[i]) {
                var w = go(i + 1, len1 + take, sum1 + take * i)
                w = (w * invFactorial[take]) % MOD
                w = (w * invFactorial[freq[i] - take]) % MOD
                ans = (ans + w) % MOD
            }
            dp[i][len1][sum1] = ans // Fixed assignment here
            return ans
        }

        return go(0, 0, 0).toInt()
    }

    init {
        for (i in 2..81) {
            factorial[i] = (i * factorial[i - 1]) % MOD
            invFactorial[i] = modExp(factorial[i], MOD - 2)
        }
    }

    fun modExp(base: Long, exp: Long): Long {
        var base = base % MOD
        var ans = 1L
        var exp = exp
        while (exp > 0) {
            if (exp and 1L != 0L) {
                ans = (ans * base) % MOD
            }
            exp = exp shr 1
            base = (base * base) % MOD
        }
        return ans
    }
}

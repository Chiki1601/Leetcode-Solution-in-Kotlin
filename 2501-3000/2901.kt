class Solution {
    
    fun getWordsInLongestSubsequence(w: Array<String>, g: IntArray): Array<String?> {
        val dp = IntArray(w.size + 1); val p = IntArray(dp.size)
        for (i in w.indices) {
            val wi = w[i]; val gi = g[i]
            for (j in 0..<i) if (g[i] != g[j] && wi.length == w[j].length) {
                val wj = w[j]; var c = 0
                for (k in wi.indices) {
                    if (wi[k] != wj[k]) c++
                    if (c > 1) break
                }
                if (c < 2 && dp[j] + 1 > dp[i]) { dp[i] = dp[j] + 1; p[i] = j + 1 }
            }
        }
        for (j in w.indices) if (dp[j] + 1 > dp[w.size]) { dp[w.size] = dp[j] + 1; p[w.size] = j + 1 }
        val res = Array<String?>(dp[w.size]) { null }; var x = w.size; var k = res.size - 1
        while (p[x] > 0) { res[k--] = w[p[x] - 1]; x = p[x] - 1 }
        return res
    }
}

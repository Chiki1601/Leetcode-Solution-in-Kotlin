class Solution {
    fun getLongestSubsequence(w: Array<String>, g: IntArray) = buildList {
        for (i in g.indices) if (i < 1 || g[i] != g[i - 1]) this += w[i]
    }
}

class Solution {
  fun getLongestSubsequence(words: List<String>, groups: List<Int>): List<String> {
    fun build(start: Int): List<String> {
        val res = mutableListOf<String>()
        var expect = start
        for (i in words.indices) {
            if (groups[i] == expect) {
                res.add(words[i])
                expect = expect xor 1
            }
        }
        return res
    }

    val res1 = build(0)
    val res2 = build(1)
    return if (res1.size >= res2.size) res1 else res2
}  
}

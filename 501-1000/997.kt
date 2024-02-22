class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val counts = IntArray(n)
        val trustsSomeone = mutableSetOf<Int>()
        
        for (t in trust) {
            counts[t[1] - 1]++
            trustsSomeone.add(t[0] - 1)
        }
        val nMinus1 = n - 1
        for (i in 0 until n) {
            if (i !in trustsSomeone && counts[i] == nMinus1) {
                return i + 1
            }
        }
        return -1
    }
}

class Solution {
    fun maxDifference(S: String, k: Int): Int {
        val s = S.toCharArray()
        val n = s.size
        val INF = Int.MAX_VALUE / 2
        var ans = -INF

        
        for (a in 0..4) {
            for (b in 0..4) {
                if (a == b) continue  

                var countA = 0    
                var countB = 0    
                var prefixA = 0   
                var prefixB = 0   

                val minDiff = Array(2) { IntArray(2) { INF } }

                var left = -1
                for (right in 0 until n) {
                    if (s[right] == ('0' + a).toChar()) countA++
                    if (s[right] == ('0' + b).toChar()) countB++

                    
                    while (right - left >= k && countB - prefixB >= 2) {
                        val parityA = prefixA and 1
                        val parityB = prefixB and 1
                        minDiff[parityA][parityB] = minOf(minDiff[parityA][parityB], prefixA - prefixB)
                        
                        left++
                        if (s[left] == ('0' + a).toChar()) prefixA++
                        if (s[left] == ('0' + b).toChar()) prefixB++
                    }

                    ans = maxOf(ans, countA - countB - minDiff[countA and 1 xor 1][countB and 1])
                }
            }
        }

        return ans
    }
}

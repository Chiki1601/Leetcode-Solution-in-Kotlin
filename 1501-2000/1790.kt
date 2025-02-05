class Solution {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        val f = IntArray(26)
        var diff = s1.indices.sumBy { i -> 
            f[s1[i] - 'a']++; 
            f[s2[i] - 'a']--; 
            if (s1[i] != s2[i]) 1 else 0
        }
        return f.all { it == 0 } && diff <= 2
    }
}

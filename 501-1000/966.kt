class Solution {
    private fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
    }

    private fun maskVowels(s: String): String {
        val sb = StringBuilder(s.length)
        for (ch in s) {
            sb.append(if (isVowel(ch)) 'a' else ch)
        }
        return sb.toString()
    }

    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        val exact = HashSet<String>(wordlist.asList())
        val lowerMap = HashMap<String, String>()
        val vowelMap = HashMap<String, String>()

        // Preprocess in order so first-occurrence is preserved
        for (w in wordlist) {
            val wl = w.lowercase()                 // use lowercase() instead of deprecated toLowerCase()
            lowerMap.putIfAbsent(wl, w)
            val masked = maskVowels(wl)
            vowelMap.putIfAbsent(masked, w)
        }

        val ans = Array(queries.size) { "" }
        for (i in queries.indices) {
            val q = queries[i]

            // 1) exact (case-sensitive)
            if (exact.contains(q)) {
                ans[i] = q
                continue
            }

            val ql = q.lowercase()                 // lowercase for comparison

            // 2) capitalization (first match)
            if (lowerMap.containsKey(ql)) {
                ans[i] = lowerMap[ql]!!
                continue
            }

            // 3) vowel-mask (first match)
            val qmask = maskVowels(ql)
            ans[i] = vowelMap[qmask] ?: ""
        }
        return ans
    }
}

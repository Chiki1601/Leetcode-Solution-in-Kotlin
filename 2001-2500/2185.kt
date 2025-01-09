class Solution {
    fun prefixCount(words: Array<String>, pref: String): Int {
        var count = 0
        for (word in words) {
            if (word.startsWith(pref)) {
                count++
            }
        }
        return count
    }
}

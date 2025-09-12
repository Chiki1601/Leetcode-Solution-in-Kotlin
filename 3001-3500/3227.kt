class Solution {
    fun doesAliceWin(input: String): Boolean {
        for (letter in input) {
            if (isVowel(letter)) {
                return true
            }
        }
        return false
    }

    private fun isVowel(letter: Char): Boolean {
        return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'
    }
}

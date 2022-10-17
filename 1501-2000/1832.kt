class Solution {
    fun checkIfPangram(sentence: String): Boolean {
        var lettersMap = mutableMapOf<Char, Char>()
        for(i in 0..sentence.length - 1) lettersMap[sentence[i]]  = ' '
        return lettersMap.keys.size == 26
    }
}

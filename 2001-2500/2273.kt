class Solution {
    fun removeAnagrams(words: Array<String>): List<String> {
    val letterCounts = createAnagramLetters(words)

    return removeAnagrams(words.toMutableList(), letterCounts)
  }

  private fun removeAnagrams(
      words: MutableList<String>,
      letterCounts: Map<String, Map<Char, Int>>
  ): MutableList<String> {
    var found = false

    val it = words.iterator()
    var prev = it.next()

    while (it.hasNext()) {
      val current = it.next()

      when {
        letterCounts[prev] == letterCounts[current] -> {
          found = true
          it.remove()
        }
        else -> prev = current
      }
    }

    return when (found) {
      true -> removeAnagrams(words, letterCounts)
      else -> words
    }
  }

  private fun createAnagramLetters(
      words: Array<String>
  ): Map<String, Map<Char, Int>> {
    val letterCounts = mutableMapOf<String, Map<Char, Int>>()

    for (word in words) {
      val letterCount = mutableMapOf<Char, Int>()

      for (letter in word) {
        if (!letterCount.containsKey(letter)) {
          letterCount[letter] = 0
        }

        letterCount[letter] = 1 + letterCount[letter]!!
      }

      letterCounts[word] = letterCount
    }

    return letterCounts
  }
}

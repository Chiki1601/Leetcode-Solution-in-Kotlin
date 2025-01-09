fun prefixCount(words: Array<String>, pref: String): Int {
    var count = 0
    
    for (word in words) {
      if (word.length < pref.length) continue
      
      count++
      
      for ((index, letter) in pref.withIndex()) {
        if (word[index] != letter) {
          count--
          break
        }
      }
    }
    
    return count
  }

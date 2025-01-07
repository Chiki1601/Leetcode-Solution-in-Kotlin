class Solution {
        fun stringMatching(words: Array<String>): List<String> {
        val list = mutableListOf<String>()
        words.forEach { one ->
            words.forEach { two ->
                if (one != two && one.contains(two) && !list.contains(two)) list.add(two)
            }
        }

        return list
    }
}

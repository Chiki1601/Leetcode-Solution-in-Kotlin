class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
    }

    fun minimumLength(input: String): Int {
        val frequency = IntArray(ALPHABET_SIZE)
        for (letter in input) {
            ++frequency[letter - 'a']
        }

        var minLengthAfterOperations = 0
        for (i in 0..<ALPHABET_SIZE) {
            if (frequency[i] == 0) {
                continue
            }
            minLengthAfterOperations += 2 shr (frequency[i] % 2)
        }

        return minLengthAfterOperations
    }
}

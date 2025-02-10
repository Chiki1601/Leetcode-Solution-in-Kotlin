class Solution {
    fun clearDigits(input: String): String {
        val clearDigits = StringBuilder()

        for (current in input) {
            if (current.isDigit() && clearDigits.isNotEmpty()) {
                clearDigits.deleteCharAt(clearDigits.length - 1)
                continue
            }
            clearDigits.append(current)
        }

        return clearDigits.toString()
    }
}

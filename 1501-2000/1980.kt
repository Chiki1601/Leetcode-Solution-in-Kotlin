class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val n = nums.first().length

        return nums.asSequence()
            .map { it.toInt(2) }
            .sorted()
            .fold(-1) { last, i ->
                if (i == last + 1) i else return (last + 1).toBinary(n)
            }
            .plus(1)
            .toBinary(n)
    }

    private fun Int.toBinary(length: Int): String {
        val string = toString(2)
        return "0".repeat(length - string.length) + string
    }
}

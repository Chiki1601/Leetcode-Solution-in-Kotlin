class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int =
        arr.asSequence()
            .groupingBy { it }
            .eachCount()
            .values
            .asSequence()
            .sorted()
            .runningFold(0, Int::plus)
            .dropWhile { it <= k }
            .count()
}

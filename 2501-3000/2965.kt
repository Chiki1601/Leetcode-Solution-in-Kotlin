fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val flat = grid.flatMap(IntArray::toList)
    val range = 1..grid.count() * grid.count()
    val diff = (range - flat.toSet()).firstOrNull() ?: -1
    val twice = flat
        .groupingBy { it }
        .eachCount()
        .entries
        .firstOrNull { it.value > 1 }
        ?.key ?: -1
    return intArrayOf(twice, diff)
}

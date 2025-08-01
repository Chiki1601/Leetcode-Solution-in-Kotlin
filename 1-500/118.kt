class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        lateinit var prevRow: List<Int>
        return (0 until numRows).map { rowIdx ->
            val newRow = (0 .. rowIdx).map { elemInRowIdx ->
                when (elemInRowIdx) {
                    0, rowIdx -> 1
                    else -> prevRow[elemInRowIdx] + prevRow[elemInRowIdx - 1]
                }
            }
            prevRow = newRow
            return@map newRow
        }
    }
}

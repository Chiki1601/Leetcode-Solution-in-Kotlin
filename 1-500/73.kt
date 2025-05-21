class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val rowIndexed = BooleanArray(matrix.size)
        val columnIndexed = BooleanArray(matrix[0].size)

        matrix.forEachIndexed { indexRow, row ->
            row.forEachIndexed { indexCol, _ ->
                if (row[indexCol] == 0) {
                    rowIndexed[indexRow] = true
                    columnIndexed[indexCol] = true
                }
            }
        }

        matrix.forEachIndexed { index, row ->
            row.forEachIndexed { indexCol, _ ->
                if (rowIndexed[index] || columnIndexed[indexCol]) matrix[index][indexCol] = 0
            }
        }

    }
}

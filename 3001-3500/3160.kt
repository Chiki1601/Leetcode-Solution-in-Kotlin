class Solution {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        var distinctColorCount = 0
        val colorToBallCount = mutableMapOf<Int, Int>()
        fun getColorToBallCount(color: Int) = colorToBallCount.getOrDefault(color, 0)
        val ballToColor = mutableMapOf<Int, Int>()

        val ans = mutableListOf<Int>()
        for (q in queries) {
            val ball = q[0]
            val color = q[1]

            ballToColor[ball]?.let { oldColor ->
                colorToBallCount[oldColor] = getColorToBallCount(oldColor) - 1
                if (getColorToBallCount(oldColor) == 0) {
                    distinctColorCount--
                }
            }

            ballToColor[ball] = color
            colorToBallCount[color] = getColorToBallCount(color) + 1
            if (getColorToBallCount(color) == 1) {
                distinctColorCount++
            }

            ans.add(distinctColorCount)
        }
        return  ans.toIntArray()
    }
}

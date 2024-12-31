class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val n = days.size
        val memo = Array<HashMap<Int, Int>>(n) { hashMapOf<Int, Int>() }
        return dp(0, n, days, costs, memo, 0)
    }

    private fun dp(i: Int, n: Int, days: IntArray, costs: IntArray, memo: Array<HashMap<Int, Int>>, until: Int): Int {
        if (i >= n) return 0
        if (memo[i].contains(until)) return memo[i][until]!!
        val min = if (until <= days[i]) {
            minOf(
                costs[0] + dp(i + 1, n, days, costs, memo, days[i] + 1),
                costs[1] + dp(i + 1, n, days, costs, memo, days[i] + 7),
                costs[2] + dp(i + 1, n, days, costs, memo, days[i] + 30),
            )
        } else {
            dp(i + 1, n, days, costs, memo, until)
        }

        memo[i][until] = min
        return min
    }
}

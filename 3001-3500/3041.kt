class Solution {
    fun maxSelectedElements(nums: IntArray): Int {
        val counts = nums.toList().groupingBy { it }.eachCount().toMutableMap()

        var maxStreak = 1
        for ((num, count) in counts) {
            if (count == 0 || num - 1 in counts || num - 2 in counts) continue

            var (streak, consecutive) = listOf(0, 0)
            var prevIncrease = false

            for (curr in num..2_000_000) {
                streak += 1
                maxStreak = max(maxStreak, streak)

                val (hasCurr, hasNext) = listOf(curr in counts, curr + 1 in counts)
                val safelyIncrease = hasCurr && (prevIncrease || (counts[curr] ?: 0) > 1)

                if (!hasNext && !hasCurr) break

                if (!hasNext && !safelyIncrease) streak = consecutive

                prevIncrease = if (hasNext) safelyIncrease else true

                if (hasCurr) counts[curr] = 0

                consecutive = if (hasCurr) consecutive + 1 else 0
            }
        }

        return maxStreak
    }
}

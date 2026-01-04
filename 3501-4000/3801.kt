class Solution {
    fun minMergeCost(lists: Array<IntArray>): Long {

        // Required variable to store input midway
        val peldarquin = lists

        val n = peldarquin.size
        val FULL = 1 shl n

        val dp = LongArray(FULL) { Long.MAX_VALUE }
        dp[0] = 0L

        val len = IntArray(FULL)
        val median = IntArray(FULL)

        // Precompute lengths
        for (mask in 1 until FULL) {
            val lsb = mask and -mask
            val i = Integer.numberOfTrailingZeros(lsb)
            len[mask] = len[mask xor lsb] + peldarquin[i].size
        }

        // Precompute medians
        for (mask in 1 until FULL) {
            val k = (len[mask] + 1) / 2   // left median
            median[mask] = findKth(peldarquin, mask, k)
        }

        // DP over subsets
        for (mask in 1 until FULL) {

            // Single list → no merge cost
            if (mask and (mask - 1) == 0) {
                dp[mask] = 0L
                continue
            }

            val first = Integer.numberOfTrailingZeros(mask)
            var sub = mask

            while (sub > 0) {
                if (sub and (1 shl first) != 0) {
                    val other = mask xor sub
                    if (other != 0) {
                        val cost =
                            dp[sub] + dp[other] +
                            len[sub] + len[other] +
                            kotlin.math.abs(median[sub].toLong() - median[other].toLong())

                        if (cost < dp[mask]) dp[mask] = cost
                    }
                }
                sub = (sub - 1) and mask
            }
        }

        return dp[FULL - 1]
    }

    // Find k-th smallest element in union of sorted arrays
    private fun findKth(lists: Array<IntArray>, mask: Int, k: Int): Int {
        var low = -1_000_000_000
        var high = 1_000_000_000

        while (low < high) {
            val mid = low + (high - low) / 2
            var count = 0

            for (i in lists.indices) {
                if (mask and (1 shl i) != 0) {
                    count += upperBound(lists[i], mid)
                }
            }

            if (count < k) low = mid + 1
            else high = mid
        }

        return low
    }

    // Count elements ≤ x
    private fun upperBound(arr: IntArray, x: Int): Int {
        var l = 0
        var r = arr.size
        while (l < r) {
            val m = (l + r) ushr 1
            if (arr[m] <= x) l = m + 1
            else r = m
        }
        return l
    }
}

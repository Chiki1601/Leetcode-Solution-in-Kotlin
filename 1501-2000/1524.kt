class Solution {
    companion object {
        const val MOD = 1_000_000_000 + 7
    }

    fun numOfSubarrays(arr: IntArray): Int {
        for (i in 1..<arr.size) {
            arr[i] += arr[i - 1]
        }

        var oddCount = 0
        var evenCount = 0
        var ans = 0
        for (i in arr.size - 1 downTo 0) {
            if (arr[i] % 2 == 0) {
                evenCount++
            } else {
                oddCount++
            }

            ans = if (i == 0 || arr[i - 1] % 2 == 0) {
                (ans + oddCount) % MOD
            } else {
                (ans + evenCount) % MOD
            }
        }
        return ans
    }
}

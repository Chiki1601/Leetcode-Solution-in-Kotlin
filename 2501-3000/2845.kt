class Solution {
  fun countInterestingSubarrays(nums: List<Int>, modulo: Int, k: Int): Long {
    val cnt = mutableMapOf(0 to 1)
    var res = 0L
    var prefix = 0
    for (num in nums) {
        if (num % modulo == k) prefix++
        val target = (prefix - k + modulo) % modulo
        res += cnt.getOrDefault(target, 0)
        cnt[prefix % modulo] = cnt.getOrDefault(prefix % modulo, 0) + 1
    }
    return res
}
}

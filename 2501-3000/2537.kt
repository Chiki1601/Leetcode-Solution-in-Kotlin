fun countGood(nums: IntArray, k: Int): Long {
    var l = 0
    var count = 0L
    var ans = 0L
    val mp = mutableMapOf<Int, Int>()
    for (r in nums.indices) {
        count += mp.getOrDefault(nums[r], 0).toLong()
        mp[nums[r]] = mp.getOrDefault(nums[r], 0) + 1
        while (l < nums.size && count - (mp[nums[l]]!! - 1) >= k) {
            mp[nums[l]] = mp[nums[l]]!! - 1
            count -= mp[nums[l]]!!
            l++
        }
        if (count >= k) ans += (l + 1)
    }
    return ans
}

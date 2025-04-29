class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val max = nums.max()
        val map = hashMapOf<Int, Int>()
        var l = 0
        var r = 0
        var total = 0L
        
        while (r < nums.size) {
            map[nums[r]] = map.getOrDefault(nums[r], 0) + 1
            
            while (map.getOrDefault(max, 0) >= k) {
                map[nums[l]] = map.getOrDefault(nums[l], 0) - 1
                if (map[nums[l]] == 0) {
                    map.remove(nums[l])
                }
                l++
            }
            
            total += l
            r++
        }
        
        return total
    }
}

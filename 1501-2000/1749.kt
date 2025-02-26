class Solution {
  
    fun maxAbsoluteSum(nums: IntArray): Int {
        var a = 0; var b = 0; var s = 0; var r = 0
        for (x in nums) {
            s += x; r = maxOf(r, a - s, s - b); a = max(a, s); b = min(b, s)
        }
        return r
    }
}

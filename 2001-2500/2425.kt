class Solution {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        val x1 = if (nums2.size and 1 == 1) nums1.reduce(Int::xor) else 0
        val x2 = if (nums1.size and 1 == 1) nums2.reduce(Int::xor) else 0
        return x1 xor x2
    }
}

class Solution {
    fun shuffle(nums: IntArray, n: Int) =
      nums.zip(nums.drop(n),{a,b->listOf(a,b)}).flatten().toIntArray()
}

class Solution {
   
    fun sortColors(nums: IntArray): Unit {
        var zero = 0; var two = nums.lastIndex; var i = 0
        while (i <= two)
            if (nums[i] < 1) {
                nums[zero] = nums[i].also { nums[i++] = nums[zero++] }
            } else if (nums[i] > 1) {
                nums[two] = nums[i].also { nums[i] = nums[two--] }
            } else i++
        }
}

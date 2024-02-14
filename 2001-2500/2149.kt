class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        
        var lastPositiveIndex = -1
        var lastNegativeIndex = -1
        
        var i = 0
        
        var turn = 0 // 0 - positive, 1 - negative
        
        while (i < nums.size) {
            var j = if (turn == 0) {
                if (lastPositiveIndex >= 0) lastPositiveIndex + 1 else 0
            } else {
                if (lastNegativeIndex >= 0) lastNegativeIndex + 1 else 0
            }

            while ((turn == 0 && nums[j] < 0) || (turn == 1 && nums[j] > 0))
                j++

            result[i] = nums[j]

            if (turn == 0)
                lastPositiveIndex = j
            else
                lastNegativeIndex = j

            turn = if (turn == 0) 1 else 0
            
            i++
        }
        
        return result
    }
}

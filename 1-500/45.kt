class Solution {
    fun jump(nums: IntArray): Int {
        val m = nums.size
        if(m<2){
            return 0
        }
        val dp = IntArray(m){Int.MAX_VALUE}
        dp[0] = 0
        var t = 0
        for (i in 0 until m){
            for(j in 1 until nums[i]+1){
                if(i+j<m){
                    dp[i+j] = minOf(dp[i+j], dp[i]+1)                    
                }
            }
        }
        return dp[m-1]
    }
}

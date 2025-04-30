class Solution {
  fun findNumbers(nums: IntArray): Int {
      var count = 0
      
      for (number in nums) {
        var num = number
        var digitCount = 0

        while(num > 0){
          num /= 10 
          digitCount++
        }
        
        if(digitCount %2 == 0) {
          count++
        }
      }      
      
      return count
    }
}

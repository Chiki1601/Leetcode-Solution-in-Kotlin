class Solution {
  fun addToArrayForm(arr: IntArray, k: Int): List<Int> {
    var curr = k
    var ans = ArrayList<Int>()
    var N = arr.size
    while(--N >= 0 || curr > 0){
        if(N >= 0) curr += arr[N]
        ans.add(curr % 10)
        curr = curr / 10
    }
    ans.reverse()
    return ans
}
}

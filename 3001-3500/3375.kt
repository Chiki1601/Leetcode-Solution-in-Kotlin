class Solution {
  
    fun minOperations(n: IntArray, k: Int) = 
    if (n.min() < k) -1 else n.toSet().count { it > k }

}

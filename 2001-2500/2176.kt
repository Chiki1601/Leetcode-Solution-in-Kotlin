class Solution {
   fun countPairs(a: IntArray, k: Int) = a.mapIndexed { i, it ->
    a.filterIndexed { j, n -> i < j && (i * j) % k == 0 && n == it }.size
}.sum()
}

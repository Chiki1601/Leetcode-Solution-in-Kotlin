class Solution {
  
    fun findKthNumber(n: Int, k: Int): Int {
        var x = 1L; var i = 1; val nl = n.toLong()
        while (i < k) {
            if (x * 10L <= nl) x *= 10L else {
                if (x + 1L > nl) x /= 10L
                x++
                val diff = min(nl, x + (10L - (x % 10L))) - x
                if (i < k - diff) { x += diff; i += diff.toInt() }
                while (x > 0L && x % 10L == 0L) x /= 10L
            }
            i++
        }
        return x.toInt()
    }
}

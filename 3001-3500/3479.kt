class Solution {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        val n = fruits.size
        
        val minst = MinSegmentTree(n)
        val maxst = MaxSegmentTree(n)
        
        for (i in 0 until n) {
            minst.updateMin(i, baskets[i])
            maxst.updateMax(i, baskets[i])
        }
        
        var ans = 0
        for (i in 0 until n) {
            val f = fruits[i]
            var low = 0
            var high = n - 1
            var ansIdx = -1
            
            while (low <= high) {
                val mid = low + (high - low) / 2
                val min = minst.getMin(low, mid)
                val max = maxst.getMax(low, mid)
                
                if (min >= f) {
                    ansIdx = mid
                    high = mid - 1
                } else if (max < f) {
                    low = mid + 1
                } else {
                    ansIdx = mid
                    high = mid - 1
                }
            }
            
            if (ansIdx != -1) {
                minst.updateMin(ansIdx, Int.MAX_VALUE)
                maxst.updateMax(ansIdx, Int.MIN_VALUE)
            } else {
                ans++
            }
        }
        return ans
    }
}

class MinSegmentTree(max: Int) {
    private val nodes = LongArray(4 * max)
    private val n = max

    fun updateMin(num: Int, `val`: Int) {
        updateMinUtil(num, `val`, 0, n, 0)
    }

    private fun updateMinUtil(num: Int, `val`: Int, l: Int, r: Int, node: Int) {
        if (num < l || num > r) {
            return
        }
        if (l == r) {
            nodes[node] += `val`.toLong()
            return
        }
        val mid = (l + r) / 2
        updateMinUtil(num, `val`, l, mid, 2 * node + 1)
        updateMinUtil(num, `val`, mid + 1, r, 2 * node + 2)
        nodes[node] = minOf(nodes[2 * node + 1], nodes[2 * node + 2])
    }

    fun getMin(l: Int, r: Int): Int {
        return getMinUtil(l, r, 0, n, 0).toInt()
    }

    private fun getMinUtil(ql: Int, qr: Int, l: Int, r: Int, node: Int): Long {
        if (qr < l || ql > r) return 0
        if (ql <= l && qr >= r) {
            return nodes[node]
        }

        val mid = (l + r) / 2
        return minOf(getMinUtil(ql, qr, l, mid, 2 * node + 1), getMinUtil(ql, qr, mid + 1, r, 2 * node + 2))
    }
}


class MaxSegmentTree(max: Int) {
    private val nodes = LongArray(4 * max)
    private val n = max

    fun updateMax(num: Int, `val`: Int) {
        updateMaxUtil(num, `val`, 0, n, 0)
    }

    private fun updateMaxUtil(num: Int, `val`: Int, l: Int, r: Int, node: Int) {
        if (num < l || num > r) {
            return
        }
        if (l == r) {
            nodes[node] += `val`.toLong()
            return
        }
        val mid = (l + r) / 2
        updateMaxUtil(num, `val`, l, mid, 2 * node + 1)
        updateMaxUtil(num, `val`, mid + 1, r, 2 * node + 2)
        nodes[node] = maxOf(nodes[2 * node + 1], nodes[2 * node + 2])
    }

    // max
    fun getMax(l: Int, r: Int): Int {
        return getMaxUtil(l, r, 0, n, 0).toInt()
    }

    private fun getMaxUtil(ql: Int, qr: Int, l: Int, r: Int, node: Int): Long {
        if (qr < l || ql > r) return 0
        if (ql <= l && qr >= r) {
            return nodes[node]
        }

        val mid = (l + r) / 2
        return maxOf(getMaxUtil(ql, qr, l, mid, 2 * node + 1), getMaxUtil(ql, qr, mid + 1, r, 2 * node + 2))
    }
}


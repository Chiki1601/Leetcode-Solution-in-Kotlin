class Solution {
    fun distinctNames(a: Array<String>): Long {
        var m = Array<MutableSet<String>>(26, { mutableSetOf<String>() })
        for (s in a) {
            var i = s[0].toInt() - 97
            m[i].add(s.substring(1))
        }

        var res = 0L
        for (i in 0..m.size - 1) {
            var b1 = m[i]
            if (b1.size == 0) continue
            for (y in i + 1..m.size - 1) {
                var b2 = m[y]
                if (b2.size == 0) continue
                res += compare(b1, b2)
            }
        }

        return res
    }

    fun compare(b1: MutableSet<String>, b2: MutableSet<String>): Long {
        var set1 = if (b1.size > b2.size) b1 else b2
        var set2 = if (b1.size > b2.size) b2 else b1
        var n1 = set1.size
        var n2 = set2.size
        for (s in set1) {
            if (set2.contains(s)) {
                n1--
                n2--
            }
        }

        return (n1 * n2) * 2L
    }
}

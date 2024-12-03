class Solution {
  fun addSpaces(s: String, a: IntArray) = buildString {
    var c = 0
    s.forEachIndexed { i, ch ->
        append(if (i == a.getOrNull(c)) " $ch".also { ++c } else ch)
    }
}
}

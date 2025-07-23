class Solution {
   
    fun maximumGain(s: String, x: Int, y: Int): Int {
        var points = 0
        val a = if (x > y) 'a' else 'b'; val b = if (a < 'b') 'b' else 'a'
        val stack = Stack<Char>().apply {
            for (c in s) if (c == b && size > 0 && peek() == a) {
                pop(); points += max(x, y)
            } else push(c)
        }
        Stack<Char>().apply {
            for (c in stack) if (c == a && size > 0 && peek() == b) {
                    pop(); points += min(x, y)
                } else push(c)
        }
        return points
    }
}

class Solution {
    fun closestPrimes(left: Int, right: Int): IntArray {
        val primeNumbers = mutableListOf<Int>()
        val start = when {
            left <= 2 -> { 
                primeNumbers.add(2)
                3
            }
            left % 2 == 0 -> left + 1
            else -> left
        }
        

        for (i in start..right step 2) {
            if (i.isPrime()) primeNumbers.add(i)
        }

        val res = intArrayOf(-1, -1)
        var minDistance = Int.MAX_VALUE

        for (i in 0 until primeNumbers.lastIndex) {
            val distance = primeNumbers[i + 1] - primeNumbers[i]
            if (distance < minDistance) {
                minDistance = distance
                
                res[0] = primeNumbers[i]
                res[1] = primeNumbers[i + 1]
            }
        }

        return res
    }

    private inline fun Int.isPrime(): Boolean {
        val sqrt = Math.sqrt(this.toDouble()).toInt()
        for (i in 2..sqrt) {
            if (this % i == 0) return false
        }

        return true
    }
}

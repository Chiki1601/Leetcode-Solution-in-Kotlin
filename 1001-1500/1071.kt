class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        val minLength = Math.min(str1.length, str2.length)
        
        (minLength downTo 1).forEach { length ->
            if (str1.length % length == 0 && str2.length % length == 0) {
                val sub1 = str1.substring(0, length)
                val sub2 = str2.substring(0, length)
                
                if (sub1 == sub2 && isValidDivisor(sub1, str1, str2))
                    return sub1
            }
        }
        
        return ""
    }
    
    private fun isValidDivisor(divisor: String, str1: String, str2: String): Boolean {
        val maxLength = Math.max(str1.length, str2.length)
        var i = 0

        while (i < maxLength - divisor.length) {
            var j = i + divisor.length

            while (j < maxLength) {
                if ((i < str1.length && j < str1.length && str1[i] != str1[j])
                    || (i < str2.length && j < str2.length && str2[i] != str2[j]))
                    return false
                
                i++
                j++
            }

            i++
        }

        return true
    }
}

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length > s2.length) return false
        var result = false
        val charFregS1 = HashMap<Char, Int>()
        val charFregS2 = HashMap<Char, Int>()
        val s = s1.toCharArray().sorted()
        s.forEachIndexed { index, c ->
            charFregS1[c] = charFregS1.getOrDefault(c,0)+1
        }

        //initialize first fregs2
        for (i in 0 until s.size){
            charFregS2[s2[i]] = charFregS2.getOrDefault(s2[i],0)+1
        }

        var left = 0
        var right = left+s.size-1
        for (i in 0 until s2.length){

            if (compareFreq(charFregS1, charFregS2)) return true

            if (right==s2.length-1) break

            charFregS2[s2[left]] = charFregS2[s2[left]]!! - 1
            left++
            right++
            charFregS2[s2[right]] = charFregS2.getOrDefault(s2[right],0) + 1
        }

        return result
    }
    fun compareFreq(freq1: HashMap<Char, Int>, freq2: HashMap<Char, Int>): Boolean{
        var result = true
        freq1.entries.forEach {
            if (it.value != freq2[it.key]) return  false
        }
        return result
    }
    }

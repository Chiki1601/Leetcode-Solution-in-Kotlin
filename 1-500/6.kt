class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1){
            return s
        }
        val a = MutableList(numRows){MutableList(s.length){""}}
        var curR = 0
        var downFlag = true
        var curC = 0
        for (i in 0 until s.length){
            a[curR][curC] = s.get(i).toString()
            if (downFlag){
                curR = curR + 1
            }
            else{
                curC = curC + 1
                curR = curR - 1
            }
            if (curR == 0){
                downFlag = true
            }
            if (curR == numRows-1){
                downFlag = false
            }
        }
        return a
            .map{it -> it
                    .filter{it->it != ""}
                    .joinToString("")}
            .joinToString("")
    }
}

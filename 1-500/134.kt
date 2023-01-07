class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var total = 0; var candidate = 0; var curr = 0
    for (i in 0..gas.size - 1) {
        curr += gas[i] - cost[i]
        total += gas[i] - cost[i]
        if (curr < 0) {
            candidate = i + 1
            curr = 0
        }
    }
    return if (total >= 0) candidate else -1
}
}

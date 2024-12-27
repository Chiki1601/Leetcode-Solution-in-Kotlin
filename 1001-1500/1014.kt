class Solution {
  fun maxScoreSightseeingPair(values: IntArray): Int {
    var max = 0
    var score = values[0]
    for (i in 1..<values.size) {
      score -= 1
      if (score + values[i] > max) max = score + values[i]
      if (values[i] > score) score = values[i]
    }
    return max
  }
}
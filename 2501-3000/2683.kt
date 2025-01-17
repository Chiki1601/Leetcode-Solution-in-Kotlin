class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        return derived.reduce(Int::xor) == 0
    }
}

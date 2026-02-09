//https://leetcode.com/problems/squares-of-a-sorted-array/description/
fun sortedSquares(nums: IntArray): IntArray {
    val sortedSquareNums = MutableList(nums.size) {0}
    var left = 0
    var right = nums.size - 1
    var latestIndex = nums.size - 1

    while (left <= right) {
        val leftNumSquared = nums[left] * nums[left]
        val rightNumSquared = nums[right] * nums[right]

        if (leftNumSquared < rightNumSquared) {
            sortedSquareNums[latestIndex] = rightNumSquared
            right--
        } else {  // >= case (handles both > and ==)
            sortedSquareNums[latestIndex] = leftNumSquared
            left++
        }
        latestIndex--
    }
    return sortedSquareNums.toIntArray()
}

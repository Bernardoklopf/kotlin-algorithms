fun findFirstOccurrence(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.size - 1
    var result = -1

    while (low <= high) {
        // Safe midpoint calculation to prevent overflow
        val mid = low + (high - low) / 2

        if (nums[mid] == target) {
            result = mid     // Found a candidate!
            high = mid - 1   // Keep looking to the left
        } else if (nums[mid] < target) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return result
}
/*
 * Complete the 'binarySearch' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY nums
 *  2. INTEGER target
 */

fun binarySearch(nums: Array<Int>, target: Int): Int {
    var left = 0
    var right = nums.size -1

    while(left <= right) {
        val mid = ((left + right) / 2)
        val midValue = nums[mid]

        if(midValue == target) {
            return mid
        } else if (midValue < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
}
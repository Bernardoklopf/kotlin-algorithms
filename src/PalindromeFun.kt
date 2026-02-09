fun isPalindrome(input: String): Boolean {
    var left = 0
    var right = input.length - 1

    while (left < right) {
        val charLeft = input[left]
        val charRight = input[right]

        when {
            !charLeft.isLetterOrDigit() -> left++
            !charRight.isLetterOrDigit() -> right--
            !charLeft.equals(charRight, ignoreCase = true) -> return false
            else -> {
                left++
                right--
            }
        }
    }
    return true
}

fun String.isRealPalindrome(): Boolean = isPalindrome(this)
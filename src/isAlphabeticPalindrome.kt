fun isAlphabeticPalindrome(code: String): Boolean {
    var left = 0
    var right = code.length - 1
    val set = setOf(1,2,3,3)

    while (left < right) {
        val lChar = code[left]
        val rChar = code[right]

        when {
            // 1. If left char is not a letter, skip forward
            !lChar.isLetter() -> left++

            // 2. If right char is not a letter, skip backward
            !rChar.isLetter() -> right--

            // 3. Compare characters (case-insensitive)
            // If they don't match, fail fast
            !lChar.equals(rChar, ignoreCase = true) -> return false

            // 4. If they match, move both pointers inward
            else -> {
                left++
                right--
            }
        }
    }

    return true
}
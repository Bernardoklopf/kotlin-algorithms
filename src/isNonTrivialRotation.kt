fun isNonTrivialRotation(s1: String, s2: String): Boolean {
    //1. check is they are identical. If yes, return false.
    if(s1.equals(s2) || s1.length.equals(s2.length).not()) return false
    //2. Check if s2 is a rotation of s1. If not, return true.
    val s1FullyRotated = s1 + s1
    val s2Size = s2.length
    for ((index, char) in s1.withIndex()) { //abcdeabcde
                                            //  cdeab
        if(char == s2.first()) {
            val left = index
            val right = (index + s2Size)
            val window = s1FullyRotated.subSequence(left, right)
            if(window.toString() == s2) return true
        }
    }
    return false
}
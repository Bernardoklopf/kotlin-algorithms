fun biggestUnrepeatedChars(s: String): Int {
    var left = 0
    var right = left + 1
    var maxLength = 0

    if(s.isEmpty()) return 0
    if(s.length == 1) return 1

    val charSet = mutableSetOf<Char>(s[left])

    while(right < s.length) {
        if(!charSet.contains(s[right])) {
            charSet.add(s[right])
            right++
            maxLength = maxOf(maxLength, right - left)
        } else {
            charSet.remove(s[left])
            left++
        }
    }

    return maxLength
}
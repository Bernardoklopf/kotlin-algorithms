fun findSmallestMissingPositive(orderNumbers: IntArray): Int {
    var smallestPositive = 1;

    orderNumbers.filter { it >= 0 }.sorted().forEach { if(it == smallestPositive) smallestPositive++ }

    return smallestPositive
}
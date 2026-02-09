fun countResponseTimeRegressions(responseTimes: IntArray): Int {
    val higherThanAvgTimes = mutableListOf<Int>()
    var accumulator: Long = 0

    // Write your code here
    responseTimes.forEachIndexed { index, time ->
        if (index == 0) {
            accumulator = time.toLong()
        } else {
            val previousAverage = accumulator / index

            if (time > previousAverage) {
                higherThanAvgTimes.add(time)
            }

            accumulator += time
        }
    }

    return higherThanAvgTimes.size
}
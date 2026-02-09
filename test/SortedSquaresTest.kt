import kotlin.test.Test

class SortedSquaresTest {
    @Test
    fun `should return the corresponding result`() {
        val input = intArrayOf(-7,-3,2,3,11)
        val expected = intArrayOf(4,9,9,49,121)
        val actual = sortedSquares(input)
        assert(expected.contentEquals(actual)) {
            "Expected ${expected.contentToString()} but got ${actual.contentToString()}"
        }
    }
}
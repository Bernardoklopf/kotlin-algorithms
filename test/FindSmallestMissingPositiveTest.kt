import kotlin.test.Test
import kotlin.test.assertEquals

class FindSmallestMissingPositiveTest {

    @Test
    fun `should return 1 when array is empty`() {
        assertEquals(1, findSmallestMissingPositive(intArrayOf()))
    }

    @Test
    fun `should return 1 when array has only negative numbers`() {
        assertEquals(1, findSmallestMissingPositive(intArrayOf(-3, -1, -5)))
    }

    @Test
    fun `should return 1 when array starts with 2`() {
        assertEquals(1, findSmallestMissingPositive(intArrayOf(2, 3, 4, 5)))
    }

    @Test
    fun `should return next missing positive`() {
        assertEquals(4, findSmallestMissingPositive(intArrayOf(1, 2, 3, 5, 6)))
    }

    @Test
    fun `should return next in sequence when all present`() {
        assertEquals(4, findSmallestMissingPositive(intArrayOf(1, 2, 3)))
    }

    @Test
    fun `should handle unsorted array`() {
        assertEquals(3, findSmallestMissingPositive(intArrayOf(7, 8, 9, 1, 2, 4, 5)))
    }

    @Test
    fun `should handle array with duplicates`() {
        assertEquals(3, findSmallestMissingPositive(intArrayOf(1, 1, 2, 2, 4, 4)))
    }

    @Test
    fun `should handle mixed positive and negative numbers`() {
        assertEquals(3, findSmallestMissingPositive(intArrayOf(-1, 0, 1, 2, 4, -5)))
    }

    @Test
    fun `should handle single element array with 1`() {
        assertEquals(2, findSmallestMissingPositive(intArrayOf(1)))
    }

    @Test
    fun `should handle single element array without 1`() {
        assertEquals(1, findSmallestMissingPositive(intArrayOf(5)))
    }
}

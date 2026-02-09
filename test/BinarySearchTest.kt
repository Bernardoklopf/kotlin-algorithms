import kotlin.test.Test
import kotlin.test.assertEquals

class BinarySearchTest {

    @Test
    fun `should find target in middle of array`() {
        val nums = arrayOf(1, 3, 5, 7, 9, 11, 13)
        assertEquals(3, binarySearch(nums, 7))
    }

    @Test
    fun `should find target at beginning of array`() {
        val nums = arrayOf(1, 3, 5, 7, 9, 11, 13)
        assertEquals(0, binarySearch(nums, 1))
    }

    @Test
    fun `should find target at end of array`() {
        val nums = arrayOf(1, 3, 5, 7, 9, 11, 13)
        assertEquals(6, binarySearch(nums, 13))
    }

    @Test
    fun `should return -1 when target not found`() {
        val nums = arrayOf(1, 3, 5, 7, 9, 11, 13)
        assertEquals(-1, binarySearch(nums, 4))
    }

    @Test
    fun `should return -1 for empty array`() {
        val nums = arrayOf<Int>()
        assertEquals(-1, binarySearch(nums, 5))
    }

    @Test
    fun `should find target in single element array`() {
        val nums = arrayOf(5)
        assertEquals(0, binarySearch(nums, 5))
    }

    @Test
    fun `should return -1 when target not in single element array`() {
        val nums = arrayOf(5)
        assertEquals(-1, binarySearch(nums, 3))
    }

    @Test
    fun `should find target in two element array`() {
        val nums = arrayOf(3, 7)
        assertEquals(1, binarySearch(nums, 7))
    }
}

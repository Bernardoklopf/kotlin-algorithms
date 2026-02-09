import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class IsNonTrivialRotationTest {

    @Test
    fun `should return true for valid rotation`() {
        assertTrue(isNonTrivialRotation("abcde", "cdeab"))
    }

    @Test
    fun `should return true for another valid rotation`() {
        assertTrue(isNonTrivialRotation("hello", "lohel"))
    }

    @Test
    fun `should return false for identical strings`() {
        assertFalse(isNonTrivialRotation("abcde", "abcde"))
    }

    @Test
    fun `should return false for non-rotation`() {
        assertFalse(isNonTrivialRotation("abcde", "abced"))
    }

    @Test
    fun `should return false for different lengths`() {
        assertFalse(isNonTrivialRotation("abc", "abcd"))
    }

    @Test
    fun `should return false for empty strings`() {
        assertFalse(isNonTrivialRotation("", ""))
    }

    @Test
    fun `should return true for single character rotation of repeated chars`() {
        assertTrue(isNonTrivialRotation("aaa", "aaa"))
    }

    @Test
    fun `should return true for rotation starting at last character`() {
        assertTrue(isNonTrivialRotation("abcde", "eabcd"))
    }

    @Test
    fun `should return true for rotation starting at second character`() {
        assertTrue(isNonTrivialRotation("abcde", "bcdea"))
    }

    @Test
    fun `should return false when string contains rotation pattern but not exact`() {
        assertFalse(isNonTrivialRotation("abcde", "cdeba"))
    }

    @Test
    fun `should handle single character strings correctly`() {
        assertFalse(isNonTrivialRotation("a", "a"))
    }

    @Test
    fun `should handle two character strings correctly`() {
        assertTrue(isNonTrivialRotation("ab", "ba"))
    }
}

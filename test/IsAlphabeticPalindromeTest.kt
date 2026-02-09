import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class IsAlphabeticPalindromeTest {

    @Test
    fun `should return true for simple alphabetic palindrome`() {
        assertTrue(isAlphabeticPalindrome("racecar"))
    }

    @Test
    fun `should return true for palindrome with mixed case`() {
        assertTrue(isAlphabeticPalindrome("RaceCar"))
    }

    @Test
    fun `should return true for palindrome ignoring numbers`() {
        assertTrue(isAlphabeticPalindrome("a1b2c2b1a"))
    }

    @Test
    fun `should return true for palindrome with special characters`() {
        assertTrue(isAlphabeticPalindrome("a!b@c#c@b!a"))
    }

    @Test
    fun `should return false for non-palindrome`() {
        assertFalse(isAlphabeticPalindrome("hello"))
    }

    @Test
    fun `should return true for empty string`() {
        assertTrue(isAlphabeticPalindrome(""))
    }

    @Test
    fun `should return true for single letter`() {
        assertTrue(isAlphabeticPalindrome("a"))
    }

    @Test
    fun `should return true for string with only non-letters`() {
        assertTrue(isAlphabeticPalindrome("123!@#"))
    }

    @Test
    fun `should return true when letters form palindrome`() {
        assertTrue(isAlphabeticPalindrome("A1B2C3C2B1A"))
    }

    @Test
    fun `should return false when letters don't form palindrome`() {
        assertFalse(isAlphabeticPalindrome("A1B2C3D2B1A"))
    }

    @Test
    fun `should handle complex case with many non-letters`() {
        assertTrue(isAlphabeticPalindrome("a!!!!!!a"))
    }

    @Test
    fun `should return true for two identical letters`() {
        assertTrue(isAlphabeticPalindrome("aa"))
    }

    @Test
    fun `should return false for two different letters`() {
        assertFalse(isAlphabeticPalindrome("ab"))
    }
}

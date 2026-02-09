import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class PalindromeTest {

    @Test
    fun `isPalindrome should return true for simple palindrome`() {
        assertTrue(isPalindrome("racecar"))
    }

    @Test
    fun `isPalindrome should return true for palindrome with mixed case`() {
        assertTrue(isPalindrome("RaceCar"))
    }

    @Test
    fun `isPalindrome should return true for palindrome with spaces`() {
        assertTrue(isPalindrome("race car"))
    }

    @Test
    fun `isPalindrome should return true for palindrome with punctuation`() {
        assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun `isPalindrome should return false for non-palindrome`() {
        assertFalse(isPalindrome("hello"))
    }

    @Test
    fun `isPalindrome should return true for empty string`() {
        assertTrue(isPalindrome(""))
    }

    @Test
    fun `isPalindrome should return true for single character`() {
        assertTrue(isPalindrome("a"))
    }

    @Test
    fun `isPalindrome should return true for alphanumeric palindrome`() {
        assertTrue(isPalindrome("A1B2B1A"))
    }

    @Test
    fun `isPalindrome should ignore non-alphanumeric characters`() {
        assertTrue(isPalindrome("!!!"))
    }

    @Test
    fun `isRealPalindrome extension should work on strings`() {
        assertTrue("racecar".isRealPalindrome())
    }

    @Test
    fun `isRealPalindrome should handle complex palindrome`() {
        assertTrue("Was it a car or a cat I saw?".isRealPalindrome())
    }

    @Test
    fun `isRealPalindrome should return false for non-palindrome`() {
        assertFalse("This is not a palindrome".isRealPalindrome())
    }
}

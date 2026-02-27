import kotlin.test.Test
import kotlin.test.assertEquals

class SlidingWindow {

    @Test
    fun abcd(){
        assertEquals(4,  biggestUnrepeatedChars("abcd"))
    }

    @Test
    fun abcda(){
        assertEquals(4,  biggestUnrepeatedChars("abcda"))
    }

    @Test
    fun abcdab(){
        assertEquals(4,  biggestUnrepeatedChars("abcdab"))
    }

    @Test
    fun abcdabc(){
        assertEquals(4,  biggestUnrepeatedChars("abcdabc"))
    }

    @Test
    fun abcabef(){
        assertEquals(5,  biggestUnrepeatedChars("abcabef"))
    }

    @Test
    fun abcdabaef(){
        assertEquals(4,  biggestUnrepeatedChars("abcdabaef"))
    }
}
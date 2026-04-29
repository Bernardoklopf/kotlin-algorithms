import kotlin.test.Test
import kotlin.test.assertEquals

class BreadthFirstSearchTest {
    @Test
    fun `should return 5`(){
        val depoMatrix = arrayOf(
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(1, 1, 0, 1),
            intArrayOf(0, 0, 9, 0)
        )

        assertEquals(5, amazonDepo(depoMatrix))
    }
}
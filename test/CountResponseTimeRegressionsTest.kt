import kotlin.test.Test
import kotlin.test.assertEquals

class CountResponseTimeRegressionsTest {

    @Test
    fun `should return 0 for empty array`() {
        assertEquals(0, countResponseTimeRegressions(intArrayOf()))
    }

    @Test
    fun `should return 0 for single element`() {
        assertEquals(0, countResponseTimeRegressions(intArrayOf(100)))
    }

    @Test
    fun `should return 0 when no regressions`() {
        assertEquals(0, countResponseTimeRegressions(intArrayOf(100, 90, 80, 70)))
    }

    @Test
    fun `should count all regressions when all times increase`() {
        assertEquals(3, countResponseTimeRegressions(intArrayOf(100, 110, 120, 130)))
    }

    @Test
    fun `should count only times higher than average`() {
        assertEquals(2, countResponseTimeRegressions(intArrayOf(100, 110, 90, 120)))
    }

    @Test
    fun `should handle mixed progression and regression`() {
        // Index 0: 5 (no comparison)
        // Index 1: 10 (avg of [5] = 5, 10 > 5) -> regression
        // Index 2: 3 (avg of [5,10] = 7.5, 3 < 7.5) -> no regression
        // Index 3: 8 (avg of [5,10,3] = 6, 8 > 6) -> regression
        // Expected: 2 regressions
        assertEquals(2, countResponseTimeRegressions(intArrayOf(5, 10, 3, 8)))
    }

    @Test
    fun `should handle equal to average correctly`() {
        // Index 0: 10 (no comparison)
        // Index 1: 10 (avg of [10] = 10, 10 > 10 is false) -> no regression
        // Expected: 0 regressions
        assertEquals(0, countResponseTimeRegressions(intArrayOf(10, 10)))
    }

    @Test
    fun `should handle large numbers`() {
        assertEquals(1, countResponseTimeRegressions(intArrayOf(1000, 2000)))
    }

    @Test
    fun `should handle two elements with regression`() {
        assertEquals(1, countResponseTimeRegressions(intArrayOf(100, 200)))
    }

    @Test
    fun `should handle two elements without regression`() {
        assertEquals(0, countResponseTimeRegressions(intArrayOf(200, 100)))
    }

    @Test
    fun `should handle long array with pattern`() {
        // Pattern: starts at 100, spikes, then normalizes
        // Index 0: 100 (no comparison)
        // Index 1: 200 (avg [100] = 100, 200 > 100) -> regression
        // Index 2: 50 (avg [100,200] = 150, 50 < 150) -> no regression
        // Index 3: 50 (avg [100,200,50] = 116, 50 < 116) -> no regression
        // Index 4: 100 (avg [100,200,50,50] = 100, 100 > 100 is false) -> no regression
        // Expected: 1 regression
        assertEquals(1, countResponseTimeRegressions(intArrayOf(100, 200, 50, 50, 100)))
    }
}

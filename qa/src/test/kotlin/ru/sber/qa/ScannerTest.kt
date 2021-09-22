package ru.sber.qa

import io.mockk.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

internal class ScannerTest {
    @BeforeEach
    fun setUp() {
        mockkObject(Random)
    }
    
    @Test
    @DisplayName("Get scanned data test")
    fun getScannedData() {
        val data = Random.nextBytes(100)
        every { Random.nextLong(5000L, 15000L) } returns 10_000L
        every { Random.nextBytes(100) } returns data
        assertDoesNotThrow { Scanner.getScanData() }
        assertEquals(data, Scanner.getScanData())
    }
    
    @AfterEach
    fun tearDown() {
        unmockkAll()
    }
}

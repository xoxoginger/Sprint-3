package ru.sber.qa

import io.mockk.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

internal class CertificateRequestTest {
  @BeforeEach
    fun setUp() {
        mockkObject(Scanner)
    }
    
    @Test
    @DisplayName("Validation data test")
    fun process(){
        every { Scanner.getScanData() } returns Random.nextBytes(100)
        val scannedData = Scanner.getScanData()
        val hrNumber = 1L
        val certificateRequest = CertificateRequest(1L, CertificateType.LABOUR_BOOK)
        val certificate = certificateRequest.process(hrNumber)
        
        assertEquals(certificate.scannedData, scannedData)
        assertEquals(certificate.processedBy, hrNumber)
        assertEquals(certificate.certificateRequest, certificateRequest)
    }
    
    @AfterEach
    fun tearDown() {
        unmockkAll()
    }
}

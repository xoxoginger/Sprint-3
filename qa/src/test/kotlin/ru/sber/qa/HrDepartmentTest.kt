package ru.sber.qa

import io.mockk.*
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.time.*

internal class HrDepartmentTest {
    private val certificate = mockk<Certificate>()
    private val certificateRequest = mockk<CertificateRequest>()
    private val hrEmployeeNumber = 100L
  
    @BeforeEach
    fun setUp() {
        val fixedClock = Clock.fixed(Instant.parse("2021-09-22T10:00:00Z"), ZoneOffset.UTC)
        HrDepartment.clock = fixedClock
    }
    
    @Test
    fun processNextRequest() {
        every { certificateRequest.process(hrEmployeeNumber) } returns certificate
        every { certificateRequest.certificateType } returns CertificateType.LABOUR_BOOK
    }
    
    @Test
    fun receiveRequest() {
        every { certificateRequest.certificateType } returns CertificateType.LABOUR_BOOK
        assertDoesNotThrow({ HrDepartment.receiveRequest(certificateRequest) })
    }
    
    @AfterEach
    fun unMockkAll() {
        unmockkAll()
    }
 }

package ru.sber.io

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream

/**
 * Реализовать методы архивации и разархивации файла.
 * Для реализиации использовать ZipInputStream и ZipOutputStream.
 */
class Archivator {

    /**
     * Метод, который архивирует файл logfile.log в архив logfile.zip.
     * Архив должен располагаться в том же каталоге, что и исходной файл.
     */
    fun zipLogfile() {
        val inputFile = "logfile.log"
        val outputFile = "logfile.zip"
        
        val fis = FileInputStream(inputFile)
        val zos = ZipOutputStream(FileOutputStream(outputFile))
            
        var buffer = ByteArray(1024)
        

        fis.use {
            buffer = fis.readBytes()
            fis.close()
        }

        zos.use {
            zos.putNextEntry(ZipEntry(inputFile))
            zos.write(buffer)
            zos.closeEntry()
            zos.close()
        }
    }

    /**
     * Метод, который извлекает файл из архива.
     * Извлечь из архива logfile.zip файл и сохарнить его в том же каталоге с именем unzippedLogfile.log
     */
    fun unzipLogfile() {
        val inputFile = File("logfile.zip")
        val outputFile = File("unzippedLogfile.log")

        val zis = ZipInputStream(FileInputStream(inputFile))
        val fos = FileOutputStream(outputFile)
        var buffer = ByteArray(1024)

        zis.use{
            zis.nextEntry
            buffer = zis.readBytes()
            zis.closeEntry()
            zis.close()
        }

        fos.use {
            fos.write(buffer)
            fos.close()
        }
   }
}


fun main() {
    val archivator = Archivator()
    archivator.zipLogfile()
    archivator.unzipLogfile()
}

package com.grishko188.lawnmower

import com.grishko188.lawnmower.engine.errors.IncorrectInputFileException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class MainTest {

    @Test
    fun main_noArguments_failedWithException() {
        Assertions.assertThrows(IllegalArgumentException::class.java) { Main.main(arrayOf()) }
    }

    @Test
    fun main_badFilePath_failedWithException() {
        Assertions.assertThrows(IncorrectInputFileException::class.java) {
            Main.main(arrayOf("User/path/wrong.txt"))
        }
    }

    @Test
    fun main_nullArguments_failedWithException() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            Main.main(null)
        }
    }

    @Test
    fun main_correctFilePath_success() {
        Main.main(arrayOf(INPUT_FILE_PATH))
    }

    companion object {
        const val INPUT_FILE_PATH = "input/LawnMowerInput.txt"
    }
}


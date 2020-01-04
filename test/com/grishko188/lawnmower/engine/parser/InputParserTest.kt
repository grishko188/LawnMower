package com.grishko188.lawnmower.engine.parser

import com.grishko188.lawnmower.engine.errors.IncorrectInputFileException
import com.grishko188.lawnmower.engine.errors.InvalidCommandException
import com.grishko188.lawnmower.engine.errors.InvalidDirectionException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InputParserTest {

    @Test
    fun parse_correctInputData_success() {
        val input = "5 5\n1 2 N\nLFLFLFLFF\n3 3 E\nFFRFFRFRRF"
        val meta = InputParser().parse(input)
        Assertions.assertNotNull(meta)
        Assertions.assertEquals(meta.lawnWidth, 5)
        Assertions.assertEquals(meta.lawnWidth, 5)
        Assertions.assertEquals(meta.mowerMetaData.size, 2)
    }

    @Test
    fun parse_noLawnSizes_failed() {
        val input = " \n1 2 N\nLFLFLFLFF\n3 3 E\nFFRFFRFRRF"
        Assertions.assertThrows(IncorrectInputFileException::class.java) { InputParser().parse(input) }
    }

    @Test
    fun parse_noNonNumericLawnSizes_failed() {
        val input = "X Y\n1 2 N\nLFLFLFLFF\n3 3 E\nFFRFFRFRRF"
        Assertions.assertThrows(IncorrectInputFileException::class.java) { InputParser().parse(input) }
    }

    @Test
    fun parse_unknownDirection_failed() {
        val input = "5 5\n1 2 G\nLFLFLFLFF\n3 3 E\nFFRFFRFRRF"
        Assertions.assertThrows(InvalidDirectionException::class.java) { InputParser().parse(input) }
    }

    @Test
    fun parse_unknownCommand_failed() {
        val input = "5 5\n1 2 N\nLFLFLFLFH\n3 3 E\nFFRFFRFRRF"
        Assertions.assertThrows(InvalidCommandException::class.java) { InputParser().parse(input) }
    }

    @Test
    fun parse_emptyCommandsList_failed() {
        val input = "5 5\n1 2 N\n \n3 3 E\nFFRFFRFRRF"
        Assertions.assertThrows(InvalidCommandException::class.java) { InputParser().parse(input) }
    }
}
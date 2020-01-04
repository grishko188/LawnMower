package com.grishko188.lawnmower.engine

import com.grishko188.lawnmower.engine.models.Command
import com.grishko188.lawnmower.engine.models.Direction
import com.grishko188.lawnmower.engine.models.Point
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CommandsProcessorTest {

    @Test
    fun rotateLeft_originNorth_expectedWest() {
        val direction = CommandsProcessor.rotate(Direction.NORTH, Command.ROTATE_LEFT)
        Assertions.assertEquals(Direction.WEST, direction)
    }

    @Test
    fun rotateLeft_originWest_expectedSouth() {
        val direction = CommandsProcessor.rotate(Direction.WEST, Command.ROTATE_LEFT)
        Assertions.assertEquals(Direction.SOUTH, direction)
    }

    @Test
    fun rotateLeft_originSouth_expectedEast() {
        val direction = CommandsProcessor.rotate(Direction.SOUTH, Command.ROTATE_LEFT)
        Assertions.assertEquals(Direction.EAST, direction)
    }

    @Test
    fun rotateLeft_originEast_expectedNorth() {
        val direction = CommandsProcessor.rotate(Direction.EAST, Command.ROTATE_LEFT)
        Assertions.assertEquals(Direction.NORTH, direction)
    }

    @Test
    fun rotateRight_originNorth_expectedEast() {
        val direction = CommandsProcessor.rotate(Direction.NORTH, Command.ROTATE_RIGHT)
        Assertions.assertEquals(Direction.EAST, direction)
    }

    @Test
    fun rotateRight_originEast_expectedSouth() {
        val direction = CommandsProcessor.rotate(Direction.EAST, Command.ROTATE_RIGHT)
        Assertions.assertEquals(Direction.SOUTH, direction)
    }

    @Test
    fun rotateRight_originSouth_expectedWest() {
        val direction = CommandsProcessor.rotate(Direction.SOUTH, Command.ROTATE_RIGHT)
        Assertions.assertEquals(Direction.WEST, direction)
    }

    @Test
    fun rotateRight_originWest_expectedNorth() {
        val direction = CommandsProcessor.rotate(Direction.WEST, Command.ROTATE_RIGHT)
        Assertions.assertEquals(Direction.NORTH, direction)
    }

    @Test
    fun move_directionNorth() {
        val originPoint = Point.of(2, 2)
        val actualPoint = CommandsProcessor.move(originPoint, Direction.NORTH)
        Assertions.assertEquals(Point.of(2, 3), actualPoint)
    }

    @Test
    fun move_directionSouth() {
        val originPoint = Point.of(2, 2)
        val actualPoint = CommandsProcessor.move(originPoint, Direction.SOUTH)
        Assertions.assertEquals(Point.of(2, 1), actualPoint)
    }

    @Test
    fun move_directionWest() {
        val originPoint = Point.of(2, 2)
        val actualPoint = CommandsProcessor.move(originPoint, Direction.WEST)
        Assertions.assertEquals(Point.of(1, 2), actualPoint)
    }

    @Test
    fun move_directionEast() {
        val originPoint = Point.of(2, 2)
        val actualPoint = CommandsProcessor.move(originPoint, Direction.EAST)
        Assertions.assertEquals(Point.of(3, 2), actualPoint)
    }
}
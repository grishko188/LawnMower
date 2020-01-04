package com.grishko188.lawnmower.engine

import com.grishko188.lawnmower.engine.models.Mower
import com.grishko188.lawnmower.engine.models.Command
import com.grishko188.lawnmower.engine.models.Direction
import com.grishko188.lawnmower.engine.models.Point
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.CompletableFuture

class LawnMowerControllerTest {

    @Test
    fun mow_firstPatter_success() {
        val completableFuture = CompletableFuture<String>()
        val lawnMowerController = LawnMowerController(5, 5)
        val mower = Mower(Point.of(1, 2), Direction.NORTH)
        val commands = listOf(
                Command.ROTATE_LEFT, Command.FORWARD,
                Command.ROTATE_LEFT, Command.FORWARD,
                Command.ROTATE_LEFT, Command.FORWARD,
                Command.ROTATE_LEFT, Command.FORWARD,
                Command.FORWARD
        )
        lawnMowerController.addMower(mower) { output ->
            completableFuture.complete(output)
        }
        lawnMowerController.mow(commands)
        Assertions.assertEquals("1 3 N", completableFuture.get())
    }

    @Test
    fun mow_secondPattern_success() {
        val completableFuture = CompletableFuture<String>()
        val lawnMowerController = LawnMowerController(5, 5)
        val mower = Mower(Point.of(3, 3), Direction.EAST)
        val commands = listOf(
                Command.FORWARD, Command.FORWARD, Command.ROTATE_RIGHT,
                Command.FORWARD, Command.FORWARD, Command.ROTATE_RIGHT,
                Command.FORWARD, Command.ROTATE_RIGHT, Command.ROTATE_RIGHT, Command.FORWARD
        )
        lawnMowerController.addMower(mower) { output -> completableFuture.complete(output) }
        lawnMowerController.mow(commands)

        Assertions.assertEquals("5 1 E", completableFuture.get())
    }

    @Test
    fun mow_edgeValues() {
        val completableFuture = CompletableFuture<String>()
        val lawnMowerController = LawnMowerController(5, 5)
        val mower = Mower(Point.of(0, 0), Direction.EAST)
        val commands = listOf(
                Command.FORWARD, Command.FORWARD, Command.FORWARD,
                Command.FORWARD, Command.FORWARD, Command.FORWARD,
                Command.ROTATE_LEFT, Command.FORWARD, Command.FORWARD
        )
        lawnMowerController.addMower(mower) { output -> completableFuture.complete(output) }
        lawnMowerController.mow(commands)
        Assertions.assertEquals("5 2 N", completableFuture.get())
    }
}
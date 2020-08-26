package com.example.marsroverkatatdd

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test


internal class MarsRoverTest {
    private lateinit var initialPosition: Position
    private lateinit var direction: Direction
    private lateinit var  marsRover: MarsRover

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `create a MarsRover Object with initial position and direction` () {
        initialPosition = Position(0, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)

        Assert.assertEquals(initialPosition, marsRover.position)
        Assert.assertEquals(direction, marsRover.direction)
    }

    @Test
    fun `rover receives a character array of commands`() {
        val commands = arrayOf('f', 'b', 'l', 'r')

        initialPosition = Position(0, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        Assert.assertEquals(commands, marsRover.commands)

    }

    @Test
    fun `if the direction is North, then f command will move +1 in y-axis `() {
        val commands = arrayOf('f')
        initialPosition = Position(0, 0)
        direction = Direction.North
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(0, 1)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.position)
    }

    @Test
    fun `if the direction is South, then f command will move +1 in y-axis `() {
        val commands = arrayOf('f')
        initialPosition = Position(0, 0)
        direction = Direction.South
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(0, -1)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.position)
    }

    @Test
    fun `if the direction is East, then f command will move +1 in x-axis `() {
        val commands = arrayOf('f')
        initialPosition = Position(0, 0)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(1, 0)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.position)
    }

    @Test
    fun `if the direction is West, then f command will move -1 in x-axis `() {
        val commands = arrayOf('f')
        initialPosition = Position(0, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(-1, 0)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.position)
    }

    private fun createMarsRover(position: Position, direction: Direction): MarsRover {
        return MarsRover(position, direction)
    }
}
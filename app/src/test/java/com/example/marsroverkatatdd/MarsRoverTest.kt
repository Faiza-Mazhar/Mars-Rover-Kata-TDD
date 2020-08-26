package com.example.marsroverkatatdd


import org.junit.Assert
import org.junit.Test


internal class MarsRoverTest {
    private lateinit var initialPosition: Position
    private lateinit var direction: Direction
    private lateinit var  marsRover: MarsRover


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

        Assert.assertEquals(commands.size, marsRover.commands.size)
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

    @Test
    fun `if the direction is North, then b command will move -1 in y-axis `() {
        val commands = arrayOf('b')
        initialPosition = Position(0, 0)
        direction = Direction.North
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(0, -1)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.position)
    }

    @Test
    fun `if the direction is South, then b command will move +1 in y-axis `() {
        val commands = arrayOf('b')
        initialPosition = Position(0, 0)
        direction = Direction.South
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(0, 1)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.position)
    }

    @Test
    fun `if the direction is East, then b command will move -1 in x-axis `() {
        val commands = arrayOf('b')
        initialPosition = Position(0, 0)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(-1, 0)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.position)
    }

    @Test
    fun `if the direction is West, then b command will move +1 in x-axis `() {
        val commands = arrayOf('b')
        initialPosition = Position(0, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(1, 0)
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.position)
    }

    @Test
    fun `if command is l and direction is North, then it changes it direction to West`(){
        val commands = arrayOf('l')
        initialPosition = Position(0, 0)
        direction = Direction.North
        marsRover = createMarsRover(initialPosition, direction)

        val expectedDirection = Direction.West
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedDirection, marsRover.direction)
    }

    @Test
    fun `if command is l and direction is East, then it changes it direction to North`(){
        val commands = arrayOf('l')
        initialPosition = Position(0, 0)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)

        val expectedDirection = Direction.North
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedDirection, marsRover.direction)
    }

    @Test
    fun `if command is l and direction is South, then it changes it direction to East`(){
        val commands = arrayOf('l')
        initialPosition = Position(0, 0)
        direction = Direction.South
        marsRover = createMarsRover(initialPosition, direction)

        val expectedDirection = Direction.East
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedDirection, marsRover.direction)
    }

    @Test
    fun `if command is l and direction is West, then it changes it direction to South`(){
        val commands = arrayOf('l')
        initialPosition = Position(0, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)

        val expectedDirection = Direction.South
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedDirection, marsRover.direction)
    }

    @Test
    fun `if command is r and direction is North, then it changes it direction to East`(){
        val commands = arrayOf('r')
        initialPosition = Position(0, 0)
        direction = Direction.North
        marsRover = createMarsRover(initialPosition, direction)

        val expectedDirection = Direction.East
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedDirection, marsRover.direction)
    }

    @Test
    fun `if command is r and direction is East, then it changes it direction to South`(){
        val commands = arrayOf('r')
        initialPosition = Position(0, 0)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)

        val expectedDirection = Direction.South
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedDirection, marsRover.direction)
    }

    @Test
    fun `if command is r and direction is South, then it changes it direction to West`(){
        val commands = arrayOf('r')
        initialPosition = Position(0, 0)
        direction = Direction.South
        marsRover = createMarsRover(initialPosition, direction)

        val expectedDirection = Direction.West
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedDirection, marsRover.direction)
    }

    @Test
    fun `if command is r and direction is West, then it changes it direction to North`(){
        val commands = arrayOf('r')
        initialPosition = Position(0, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)

        val expectedDirection = Direction.North
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedDirection, marsRover.direction)
    }

    private fun createMarsRover(position: Position, direction: Direction): MarsRover {
        return MarsRover(position, direction)
    }
}
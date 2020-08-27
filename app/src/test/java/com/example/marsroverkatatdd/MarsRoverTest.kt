package com.example.marsroverkatatdd


import org.junit.Assert
import org.junit.Test


internal class MarsRoverTest {
    private lateinit var initialPosition: Position
    private lateinit var direction: Direction
    private lateinit var  marsRover: MarsRover
    
    private val gridSize = 5


    @Test
    fun `create a MarsRover Object with initial position and direction` () {
        initialPosition = Position(0, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)

        Assert.assertEquals(initialPosition, marsRover.currentPosition)
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

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if the direction is South, then f command will move +1 in y-axis `() {
        val commands = arrayOf('f')
        initialPosition = Position(0, 0)
        direction = Direction.South
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(0, gridSize-1)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if the direction is East, then f command will move +1 in x-axis `() {
        val commands = arrayOf('f')
        initialPosition = Position(0, 0)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(1, 0)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if the direction is West, then f command will move -1 in x-axis `() {
        val commands = arrayOf('f')
        initialPosition = Position(1, 1)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(0, 1)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if the direction is North, then b command will move -1 in y-axis `() {
        val commands = arrayOf('b')
        initialPosition = Position(0, 0)
        direction = Direction.North
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(0, gridSize-1)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if the direction is South, then b command will move +1 in y-axis `() {
        val commands = arrayOf('b')
        initialPosition = Position(0, 0)
        direction = Direction.South
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(0, 1)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if the direction is East, then b command will move -1 in x-axis `() {
        val commands = arrayOf('b')
        initialPosition = Position(0, 0)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(gridSize-1, 0)

        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if the direction is West, then b command will move +1 in x-axis `() {
        val commands = arrayOf('b')
        initialPosition = Position(0, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)

        val expectedPosition = Position(1, 0)
        marsRover.startMarsRover(commands)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
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

    @Test
    fun `test commands to turn right, back, forward and left, will bring the rover in initial place` () {
        val commands = arrayOf('r', 'b', 'f', 'l')
        initialPosition = Position(0, 0)
        direction = Direction.North
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedDirection = Direction.North
        val expectedPosition = initialPosition

        Assert.assertEquals(expectedDirection, marsRover.direction)
        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if Rover is on right edge of x-axis, facing East with forward command, it goes to left edge`() {
        val commands = arrayOf('f')
        initialPosition = Position(gridSize-1, 0)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(0, 0)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if Rover is on left edge of x-axis, facing West with forward command, it goes to right edge`() {
        val commands = arrayOf('f')
        initialPosition = Position(0, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(gridSize-1, 0)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if Rover is on top edge of y-axis, facing North with forward command, it goes to bottom edge`() {
        val commands = arrayOf('f')
        initialPosition = Position(0,gridSize-1)
        direction = Direction.North
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(0, 0)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if Rover is on bottom edge of y-axis, facing South with forward command, it goes to bottom edge`() {
        val commands = arrayOf('f')
        initialPosition = Position(0,0)
        direction = Direction.South
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(0, gridSize-1)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if Rover is on right edge of x-axis, facing West with back command, it goes to left edge`() {
        val commands = arrayOf('b')
        initialPosition = Position(gridSize-1, 0)
        direction = Direction.West
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(0, 0)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if Rover is on left edge of x-axis, facing East with back command, it goes to right edge`() {
        val commands = arrayOf('b')
        initialPosition = Position(0, 0)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(gridSize-1, 0)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if Rover is on top edge of y-axis, facing South with back command, it goes to bottom edge`() {
        val commands = arrayOf('b')
        initialPosition = Position(0,gridSize-1)
        direction = Direction.South
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(0, 0)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if Rover is on bottom edge of y-axis, facing North with back command, it goes to top edge`() {
        val commands = arrayOf('b')
        initialPosition = Position(0,0)
        direction = Direction.North
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(0, gridSize-1)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if next position is a obstacle, then don't change the position` () {
        val commands = arrayOf('f')
        initialPosition = Position(1,3)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(1, 3)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    @Test
    fun `if next position is not a obstacle, then change the position`() {
        val commands = arrayOf('f')
        initialPosition = Position(2,3)
        direction = Direction.East
        marsRover = createMarsRover(initialPosition, direction)
        marsRover.startMarsRover(commands)

        val expectedPosition = Position(3, 3)

        Assert.assertEquals(expectedPosition, marsRover.currentPosition)
    }

    private fun createMarsRover(position: Position, direction: Direction): MarsRover {
        return MarsRover(position, direction, gridSize)
    }
}
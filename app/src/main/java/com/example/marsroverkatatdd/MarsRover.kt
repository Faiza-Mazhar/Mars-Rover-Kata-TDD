package com.example.marsroverkatatdd

class MarsRover(val position: Position, var direction: Direction, var gridSize: Int) {

    lateinit var commands: Array<Char>
    private var currentDirection = -1

    fun startMarsRover(commands: Array<Char>) {
        this.commands = commands

        commands.forEach { command ->
            when (command) {
                'f' -> {
                    when (direction) {
                        Direction.North -> position.y = (position.y + 1) % gridSize
                        Direction.South -> position.y = (position.y + gridSize - 1) % gridSize
                        Direction.East -> position.x = (position.x + 1) % gridSize
                        Direction.West -> position.x = (position.x + gridSize - 1) % gridSize
                    }
                }
                'b' -> {
                    when (direction) {
                        Direction.North -> position.y = (position.y + gridSize - 1) % gridSize
                        Direction.South -> position.y = (position.y + 1) % gridSize
                        Direction.East -> position.x = (position.x + gridSize - 1) % gridSize
                        Direction.West -> position.x = (position.x + 1) % gridSize
                    }
                }
                'l' -> {
                    currentDirection = ((direction.ordinal + Direction.values().size) - 1) % Direction.values().size
                    direction = Direction.values()[currentDirection]
                }
                'r' -> {
                    currentDirection = (direction.ordinal + 1) % Direction.values().size
                    direction = Direction.values()[currentDirection]
                }
            }
        }
    }
}



data class Position(var x: Int, var y: Int)


enum class Direction{
    North,
    East,
    South,
    West
}
package com.example.marsroverkatatdd

class MarsRover(internal var currentPosition: Position, var direction: Direction, var gridSize: Int) {

    lateinit var commands: Array<Char>
    private var currentDirection = -1

    private val obstacle = arrayOf(Position(2, 3), Position(3, 2))

    fun startMarsRover(commands: Array<Char>) {
        this.commands = commands
        commands.forEach { command ->
            val nextPosition = getNextPosition(command)
            if(!isObstacle(nextPosition)) {
                currentPosition = nextPosition
            }
        }
    }

    private fun isObstacle(position: Position): Boolean {
        return obstacle.any {
            it == position
        }
    }

    private fun getNextPosition(command: Char): Position {
        val newPosition = Position(currentPosition.x, currentPosition.y)
        when (command) {
            'f' -> {
                when (direction) {
                    Direction.North -> newPosition.y = (newPosition.y + 1) % gridSize
                    Direction.South -> newPosition.y = (newPosition.y + gridSize - 1) % gridSize
                    Direction.East -> newPosition.x = (newPosition.x + 1) % gridSize
                    Direction.West -> newPosition.x = (newPosition.x + gridSize - 1) % gridSize
                }
            }
            'b' -> {
                when (direction) {
                    Direction.North -> newPosition.y = (newPosition.y + gridSize - 1) % gridSize
                    Direction.South -> newPosition.y = (newPosition.y + 1) % gridSize
                    Direction.East -> newPosition.x = (newPosition.x + gridSize - 1) % gridSize
                    Direction.West -> newPosition.x = (newPosition.x + 1) % gridSize
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

        return newPosition
    }
}



data class Position(var x: Int, var y: Int)


enum class Direction{
    North,
    East,
    South,
    West
}
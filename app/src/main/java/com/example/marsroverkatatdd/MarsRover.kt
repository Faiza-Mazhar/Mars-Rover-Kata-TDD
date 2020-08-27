package com.example.marsroverkatatdd

class MarsRover(internal var currentPosition: Position, var direction: Direction, var gridSize: Int) {

    lateinit var commands: Array<Char>
    private var currentDirection = -1

    private val obstacle = arrayOf(Position(2, 3), Position(3, 2))

    fun startMarsRover(commands: Array<Char>): Boolean {
        this.commands = commands
        var obstacleEncountered = false;

        commands.forEach { command ->

            val nextPosition = getNextPosition(command)

            if(isObstacleAt(nextPosition)) {
                obstacleEncountered = true
                return@forEach

            } else {
                when(command) {
                    'l' -> computeLeftDirection()
                    'r' -> computeRightDirection()
                    else -> currentPosition = nextPosition
                }
            }
        }
        return obstacleEncountered
    }

    private fun isObstacleAt(position: Position): Boolean {
        return obstacle.any {
            it == position
        }
    }

    private fun getNextPosition(command: Char): Position {
        val newPosition = Position(currentPosition.x, currentPosition.y)
        when (command) {
            'f' -> {
                when (direction) {
                    Direction.North -> newPosition.y = addToPositionAxis(newPosition.y)
                    Direction.South -> newPosition.y = subtractFromPositionAxis(newPosition.y)
                    Direction.East -> newPosition.x = addToPositionAxis(newPosition.x)
                    Direction.West -> newPosition.x = subtractFromPositionAxis(newPosition.x)
                }
            }
            'b' -> {
                when (direction) {
                    Direction.North -> newPosition.y = subtractFromPositionAxis(newPosition.y)
                    Direction.South -> newPosition.y = addToPositionAxis(newPosition.y)
                    Direction.East -> newPosition.x = subtractFromPositionAxis(newPosition.x)
                    Direction.West -> newPosition.x = addToPositionAxis(newPosition.x)
                }
            }
        }
        return newPosition
    }

    private fun computeLeftDirection() {
        currentDirection = ((direction.ordinal + Direction.values().size) - 1) % Direction.values().size
        direction = Direction.values()[currentDirection]
    }

    private fun computeRightDirection() {
        currentDirection = (direction.ordinal + 1) % Direction.values().size
        direction = Direction.values()[currentDirection]
    }


    private fun addToPositionAxis(value: Int): Int{
        return (value + 1) % gridSize
    }

    private fun subtractFromPositionAxis(value: Int): Int{
        return (value + gridSize - 1) % gridSize
    }
}



data class Position(var x: Int, var y: Int)


enum class Direction{
    North,
    East,
    South,
    West
}
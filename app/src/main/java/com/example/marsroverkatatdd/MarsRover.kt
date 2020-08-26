package com.example.marsroverkatatdd

import java.lang.Math.abs


class MarsRover(val position: Position, var direction: Direction) {

    lateinit var commands: Array<Char>
    var currentDirection = -1
    fun startMarsRover(commands: Array<Char>) {
        this.commands = commands

        commands.forEach { command ->
            when (command) {
                'f' -> {
                    when (direction) {
                        Direction.North -> position.y++
                        Direction.South -> position.y--
                        Direction.East -> position.x++
                        Direction.West -> position.x--
                    }
                }
                'b' -> {
                    when (direction) {
                        Direction.North -> position.y--
                        Direction.South -> position.y++
                        Direction.East -> position.x--
                        Direction.West -> position.x++
                    }
                }
                'l' -> {
                    currentDirection = ((direction.ordinal + 4) - 1) % 4
                    direction = Direction.values()[currentDirection]
                }
                'r' -> {
                    currentDirection = (direction.ordinal + 1) % 4
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
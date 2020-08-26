package com.example.marsroverkatatdd

class MarsRover(val position: Position, val direction: Direction) {

    lateinit var commands: Array<Char>

    fun startMarsRover(commands: Array<Char>) {
        this.commands = commands

        commands.forEach { command ->
            if(command == 'f'){
                when(direction){
                    Direction.North -> position.y++
                    Direction.South -> position.y--
                    Direction.East -> position.x++
                    Direction.West -> position.x--
                }
            } else if (command == 'b') {
                when(direction){
                    Direction.North -> position.y--
                    Direction.South -> position.y++
                    Direction.East -> position.x--
                    Direction.West -> position.x++
                }
            }


        }
    }
}


data class Position(var x: Int, var y: Int)


enum class Direction{
    North,
    South,
    East,
    West
}
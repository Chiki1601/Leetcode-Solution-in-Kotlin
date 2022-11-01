class Solution {
    private data class Position(val x: Int, val y: Int)
    
    fun findBall(grid: Array<IntArray>): IntArray {
        val memoizedDestinations: MutableMap<Position, Int> = mutableMapOf()
        val destinations = MutableList<Int>(grid[0].size, { -1 })
        
        return destinations.mapIndexed { columnIdx, _ ->
            getDestination(Position(columnIdx, 0), memoizedDestinations, grid)
        }.toIntArray()
    }
    
    private fun getDestination(currentPosition: Position, memoizedDestinations: MutableMap<Position, Int>, grid: Array<IntArray>): Int {
        if (currentPosition.y > grid.lastIndex) {
            return currentPosition.x
        } else if (currentPosition !in memoizedDestinations) {
            val nextPosition = getNextPosition(currentPosition, grid)
            
            memoizedDestinations[currentPosition] = nextPosition?.let { getDestination(it, memoizedDestinations, grid) } ?: -1
        }
        
        return memoizedDestinations[currentPosition]!!
    }
    
    /**
    * Returns the next position the ball will end up in based on the current position, or null if the
    * ball gets stuck.
    */
    private fun getNextPosition(currentPosition: Position, grid: Array<IntArray>): Position? {
        val currentCellValue = grid[currentPosition.y][currentPosition.x]
        val nextColumn = currentPosition.x + currentCellValue
        
        
        return if (nextColumn < 0 || nextColumn > grid[0].lastIndex) {
            null
        } else if (currentCellValue - grid[currentPosition.y][nextColumn] != 0) {
            null
        } else {
            Position(nextColumn, currentPosition.y + 1)    
        }
    }
}

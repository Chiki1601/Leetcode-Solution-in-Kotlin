fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
    val map = HashMap<Int, ArrayList<IntArray>>()

    fun buildGraph() {
        for (f in flights) {
            map.getOrPut(f[0], { ArrayList() }).add(intArrayOf(f[1], f[2]))
        }
    }

    fun bfs(): Int {
        var stops = 0
        var min = Int.MAX_VALUE
        val q = ArrayDeque<IntArray>()
        
        q.offer(intArrayOf(src, 0))
        
        while (!q.isEmpty()) {
            val size = q.size
            
            for (dummy in 0..size - 1) {
                val node = q.poll()
                val city = node[0]
                val cost = node[1]

                if (city == dst) min = minOf(min, cost)

                if (map.contains(city)) {
                    for (nei in map[city]!!) {
                        // cut branch
                        val newCost = cost + nei[1]
                        if (newCost > min) continue
                        q.offer(intArrayOf(nei[0], newCost))
                    }
                }
            }
            
            if (stops++ > K) break
        }
        
        return if (min == Int.MAX_VALUE) -1 else min
    }

    buildGraph()

    return bfs()
}

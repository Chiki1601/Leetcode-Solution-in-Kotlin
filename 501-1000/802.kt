class Solution {
    fun DFS(node: Int, visited: IntArray, graph: Array<IntArray>): Boolean {
    if (visited[node] == 1) {
        return true
    }
    if (visited[node] == -1) {
        return false
    }

    visited[node] = -1

    for (neighbor in graph[node]) {
        if (!DFS(neighbor, visited, graph)) {
            return false
        }
    }
    visited[node] = 1
    return true
    }

    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val answer: MutableList<Int> = mutableListOf()
        val visited = IntArray(graph.size)
        for (i in graph.indices) {
            if (DFS(i, visited, graph)) {
                answer.add(i)
            }
        }
        answer.sort()
        return answer
    }
}

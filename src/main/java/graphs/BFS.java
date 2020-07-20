package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    static void bfsUtil(final Graph graph, int[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            System.out.print(vertex + " ");
            List<Integer> vertices = graph.adjList.get(vertex);

            for (int i : vertices) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    static void bfs(final Graph graph) {
        int v = graph.vertices;
        if (v <= 0) {
            return;
        }

        int[] visited = new int[v];

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                bfsUtil(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        // Adding edges one by one
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        bfs(graph);
    }
}

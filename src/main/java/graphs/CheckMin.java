package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CheckMin {

    public static int findMin(Graph g, int source, int destination) {
        if (source == destination) {
            return 0;
        }
        int v = g.vertices;
        int[] visited = new int[v];
        int[] distance = new int[v];

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();
            List<Integer> vertices = g.adjList.get(current);

            for (int vertex : vertices) {
                if (visited[vertex] == 0) {
                    q.add(vertex);
                    visited[vertex] = 1;
                    distance[vertex] = distance[current] + 1;
                    if (vertex == destination) {
                        return distance[vertex];
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(1, 4);
        System.out.println(findMin(g, 0, 4));
    }
}

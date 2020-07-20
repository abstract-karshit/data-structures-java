package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckPaths {

    static boolean checkPath(Graph g, int source, int destination) {
        if (source == destination) {
            return true;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[g.vertices];
        visited[source] = 1;
        q.add(source);

        while (!q.isEmpty()) {
            int vertex = q.poll();
            if (vertex == destination) {
                return true;
            }
            List<Integer> vertices = g.adjList.get(vertex);
            for (int i : vertices) {
                if (visited[i] == 0) {
                    q.add(i);
                    visited[i] = 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Graph g2 = new Graph(5);

        // Adding edges one by one
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 3);
        g2.addEdge(2, 3);

        System.out.println(checkPath(g2, 0, 4));

    }
}

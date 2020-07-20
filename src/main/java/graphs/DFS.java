package graphs;

import java.util.List;

public class DFS {

    static void dfsUtil(Graph graph, int[] visited, int start) {
        visited[start] = 1;
        System.out.print(start + " ");
        List<Integer> vertices = graph.adjList.get(start);
        for (int vertex : vertices) {
            if (visited[vertex] == 0) {
                dfsUtil(graph, visited, vertex);
            }
        }
    }

    static void dfs(Graph graph) {
        int v = graph.vertices;
        int[] visited = new int[v];

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                dfsUtil(graph, visited, i);
                System.out.println();
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

        dfs(graph);
    }
}

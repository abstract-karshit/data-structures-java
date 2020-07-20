package graphs;

import java.util.List;

class CheckCycle {

    private static boolean detectCycleUtil(Graph g, int start, int[] visited, int[] ancestors) {
        if (ancestors[start] == 1) {
            return true;
        }

        if (visited[start] == 1) {
            return false;
        }

        visited[start] = 1;
        ancestors[start] = 1;

        List<Integer> vertices = g.adjList.get(start);
        for (int vertex : vertices) {
            if (detectCycleUtil(g, vertex, visited, ancestors)) {
                return true;
            }
        }

        ancestors[start] = 0;
        return false;
    }

    public static boolean detectCycle(Graph g) {
        // Write -- Your -- Code
        int v = g.vertices;
        int[] visited = new int[v];
        int[] ancestors = new int[v];

        for (int i = 0; i < v; i++) {
            if (detectCycleUtil(g, i, visited, ancestors)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if (detectCycle(graph)) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't "
                + "contain cycle");
        }
    }
}

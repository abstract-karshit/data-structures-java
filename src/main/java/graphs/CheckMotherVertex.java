package graphs;

import java.util.Arrays;
import java.util.List;

class CheckMotherVertex {

    private static void dfsUtil(Graph g, int[] visited, int start) {
        visited[start] = 1;

        List<Integer> vertices = g.adjList.get(start);
        for (int vertex : vertices) {
            if (visited[vertex] == 0) {
                dfsUtil(g, visited, vertex);
            }
        }
    }
    static int findMother(Graph g) {
        int mother = 0;
        int v = g.vertices;
        int[] visited = new int[v];

        for(int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                dfsUtil(g, visited, i);
                mother = i;
            }
        }

        Arrays.fill(visited, 0);

        dfsUtil(g, visited, mother);

        for (int i = 0; i < v; i++) {
            if (visited[i] == 0) {
                return -1;
            }
        }

        return mother;
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        System.out.println("Mother is : " +  findMother(g));
    }
}

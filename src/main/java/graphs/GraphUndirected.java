package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphUndirected {

    int vertices;
    List<List<Integer>> adjList;

    public GraphUndirected(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void  addEdge(int x, int y) {
        adjList.get(x).add(y);
        adjList.get(y).add(x);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " - ");
            List<Integer> vertices = adjList.get(i);
            for (int vertex : vertices) {
                System.out.print(vertex + " - ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        int V = 9;
        GraphUndirected g = new GraphUndirected(V);

        // making above uhown graph
        g.addEdge(0, 1);
        g.addEdge(0, 7);
        g.addEdge(1, 2);
        g.addEdge(1, 7);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(6, 8);
        g.addEdge(7, 8);

        g.printGraph();

    }
}

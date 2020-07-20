package graphs;

import java.util.ArrayList;
import java.util.List;

class Graph {

    int vertices;
    List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");
            for (int vertex : adjList.get(i)) {
                System.out.print(vertex + " -> ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        // Creating a graph with 5 vertices
        Graph graph = new Graph(5);

        // Adding edges one by one
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}

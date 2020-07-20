package graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class CheckTree {

    public static boolean isTree(Graph g) {
        int v = g.vertices;
        int[] visited = new int[v];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = 1;
        int numVisited = 1;

        while(!q.isEmpty()) {
            int start = q.poll();
            List<Integer> vertices = g.adjList.get(start);

            for (int vertex : vertices) {
                if (visited[vertex] == 1) {
                    return false;
                }
                q.add(vertex);
                numVisited++;
            }
        }

        return numVisited == v;
    }

    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.printGraph();
        System.out.println("isTree : " + isTree(g));

        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(0, 3);
        g2.addEdge(3, 2);
        g2.printGraph();
        System.out.println("isTree : " + isTree(g2));

        Graph g3 = new Graph(6);
        g3.addEdge(0, 1);
        g3.addEdge(0, 2);
        g3.addEdge(0, 3);
        g3.addEdge(4, 5);
        g3.printGraph();
        System.out.println("isTree : " + isTree(g3));
    }
}

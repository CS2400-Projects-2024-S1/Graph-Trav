import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    // Create a graph
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Add edges to the graph
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS algorithm
    public void BFS(int s) {

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(13);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        g.addEdge(2, 5);
        g.addEdge(4, 7);
        g.addEdge(5, 6);
        g.addEdge(5, 8);
        g.addEdge(7, 8);
        g.addEdge(6, 3);
        g.addEdge(6, 8);
        g.addEdge(8, 9);
        g.addEdge(3, 2);
        g.addEdge(8, 6);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 1)");

        g.BFS(1);
    }
}

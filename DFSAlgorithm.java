import java.util.*;

public class DFSAlgorithm {
    private int V; // Number of Vertices
    private LinkedList<Integer>[] adj; // Adjacency lists

    // Constructor
    public DFSAlgorithm(int V) {
        this.V = V;
        adj = new LinkedList[V];

        // Adjacency lists for all vertices
        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();

    }

    // Method to add an edge between two vertices
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // Depth First Search algorithm
    public void DFS(int s) {
        // Initially mark all vertices as not visited
        Vector<Boolean> visited = new Vector<Boolean>(V);
        for (int i = 0; i < V; i++)
            visited.add(false);

        // Create a stack for DFS
        Stack<Integer> stack = new Stack<>();

        // Push source node
        stack.push(s);

        // Continue until the stack is empty
        while (!stack.empty()) {
            // Pop a vertex from stack and print it
            s = stack.peek();
            stack.pop();
            if (!visited.get(s)) {
                System.out.print(s + " ");
                visited.set(s, true);
            }
            // Get all adjacent vertices of the popped vertex
            Iterator<Integer> itr = adj[s].iterator();
            while (itr.hasNext()) {
                int v = itr.next();
                // If the adjacent vertex has not been visited, push it onto the stack
                if (!visited.get(v))
                    stack.push(v);
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph with 9 vertices
        DFSAlgorithm g = new DFSAlgorithm(9);

        // Add edges to the graph
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

        System.out.println("Following is the Depth First Traversal");
        // Perform Depth First Traversal starting from vertex 1
        g.DFS(1);
    }
}

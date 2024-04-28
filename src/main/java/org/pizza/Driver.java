package org.pizza;

public class Driver
{	
	public static void main(String[] args)
	{
		DirectedGraph<String> graph = new DirectedGraph<String>();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("I");

		graph.addEdge("A", "B");
		graph.addEdge("A", "D");
		graph.addEdge("A", "E");
		graph.addEdge("B", "E");
		graph.addEdge("D", "G");
		graph.addEdge("E", "F");
		graph.addEdge("E", "H");
		graph.addEdge("G", "H");
		graph.addEdge("F", "C");
		graph.addEdge("F", "H");
		graph.addEdge("H", "I");
		graph.addEdge("C", "B");
		graph.addEdge("I", "F");

		graph.display();
		System.out.println("Depth First Traversal: " + graph.getDepthFirstTraversal("A").toString());
		System.out.println("Breadth First Traversal: " + graph.getBreadthFirstTraversal("A").toString());
		

	}
    
}

package org.pizza;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ListGraphTest {

    DirectedGraph<Integer> graph = new DirectedGraph<>();

    @Test
    public void testAddVertex() {
        graph.addVertex(1);
        String expected = "[1]";
        String actual = graph.getBreadthFirstTraversal(1).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddEdge() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);
        assertTrue(graph.hasEdge(1, 2));
    }

    @Test
    public void testHasEdge() {
        assertFalse(graph.hasEdge(1, 2));
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);
        assertTrue(graph.hasEdge(1, 2));
        assertFalse(graph.hasEdge(1, 3));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(graph.isEmpty());
        graph.addVertex(1);
        assertFalse(graph.isEmpty());
    }

    @Test
    public void testGetNumberOfVertices() {
        assertEquals(0, graph.getNumberOfVertices());
        graph.addVertex(1);
        graph.addVertex(2);
        assertEquals(2, graph.getNumberOfVertices());
    }

    @Test
    public void testGetNumberOfEdges() {
        assertEquals(0, graph.getNumberOfEdges());
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);
        assertEquals(1, graph.getNumberOfEdges());  // Adjust for unidirectional edge
    }

    @Test
    public void testClear() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2);
        assertEquals(2, graph.getNumberOfVertices());
        assertEquals(1, graph.getNumberOfEdges());  // Adjust for unidirectional edge
        graph.clear();
        assertEquals(0, graph.getNumberOfVertices());
        assertEquals(0, graph.getNumberOfEdges());
    }

    @Test
    public void testGetBreadthFirstTraversal() {
        for (int i = 1; i <= 9; i++) {
            graph.addVertex(i);
        }
        // Creating a slightly different graph structure
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        String expected = "[1, 2, 3, 4, 5, 6, 7, 8, 9]";
        String actual = graph.getBreadthFirstTraversal(1).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDepthFirstTraversal() {
        for (int i = 1; i <= 9; i++) {
            graph.addVertex(i);
        }
        // Creating a slightly different graph structure
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);

        String expected = "[1, 2, 4, 5, 6, 7, 8, 9, 3]";
        String actual = graph.getDepthFirstTraversal(1).toString();
        assertEquals(expected, actual);
    }
}

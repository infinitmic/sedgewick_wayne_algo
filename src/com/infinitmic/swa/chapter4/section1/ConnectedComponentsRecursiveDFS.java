package com.infinitmic.swa.chapter4.section1;

import java.util.Iterator;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class ConnectedComponentsRecursiveDFS implements ConnectedComponents{

    private boolean[] visited;
    private int[] id;
    private int count;

    public ConnectedComponentsRecursiveDFS(Graph graph) {
        visited = new boolean[graph.vertices()];
        id = new int[graph.vertices()];

        for (int source = 0; source < graph.vertices(); source++) {
            if(!visited[source]) {
                depthFirstSearchIterative(graph, source);
                count++;
            }
        }
    }

    private void depthFirstSearchIterative(Graph graph, int sourceVertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(sourceVertex);
        visited[sourceVertex] = true;
        id[sourceVertex] = count;

        // Used to be able to iterate over each dependency list, keeping track of which
        // vertex in ech adjacent list needs to be explored next

        Iterator<Integer>[] adjacentIterators = (Iterator<Integer>[]) new Iterator[graph.vertices()];

        for(int vertexId = 0; vertexId < adjacentIterators.length; vertexId++) {
            if(graph.getAdjacencyList()[vertexId] != null) {
                adjacentIterators[vertexId] = graph.getAdjacencyList()[vertexId].iterator();
            }
        }

        while (!stack.isEmpty()) {
            int currentVertex = stack.peek();

            if(adjacentIterators[currentVertex].hasNext()) {
                int neighbour = adjacentIterators[currentVertex].next();

                if(!visited[neighbour]){
                    stack.push(neighbour);
                    visited[neighbour] = true;
                    id[neighbour] = count;
                }
            } else {
                stack.pop();
            }
        }
    }

    @Override
    public boolean connected(int vertex1, int vertex2) {
        return id[vertex1] == id[vertex2];
    }

    @Override
    public int id(int vertex) {
        return id[vertex];
    }

    @Override
    public int count() {
        return count;
    }
}
